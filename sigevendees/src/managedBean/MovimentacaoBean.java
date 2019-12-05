package managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import dao.ClienteDao;
import dao.PedidoDao;
import dao.ProdutoDao;
import dao.VendaDao;
import entity.Cliente;
import entity.ComponenteDoProduto;
import entity.ItemDoPedido;
import entity.Pedido;
import entity.Produto;
import entity.Venda;

@ManagedBean
@SessionScoped
public class MovimentacaoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	FacesContext context;
	private Cliente cliente;
	private String idCliente;
	private Produto produto;
	private Date dataInicial;
	private Date dataFinal;
	private int qtdTotalUndVendida;
	private float valorTotalVenda;
	private float valorTotalCusto;
	private List<Venda> vendas;
	private List<ItemDoPedido> itens;
	
	//Variável utilizada para exibir a coluna cliente na tabela id="tabelaDadosConsultaHistorico" nas consultas de historico de vendas por produto;
	private boolean exibir;
	
	public MovimentacaoBean() {
		this.cliente = new Cliente();
		this.produto = new Produto();
		this.vendas = new ArrayList<Venda>();
		this.itens = new ArrayList<ItemDoPedido>();
		this.exibir = false;
	}

	@Inject
	private PedidoDao daoPedido = new PedidoDao();
	@Inject
	private VendaDao daoVenda = new VendaDao();
	@Inject
	private ClienteDao daoCliente = new ClienteDao();
	@Inject
	private ProdutoDao daoProduto = new ProdutoDao();

	public void buscarBalancoDoPeriodo() {
		context = FacesContext.getCurrentInstance();
		vendas = daoVenda.listarVendasPorPeriodo(getDataInicial(), getDataFinal());
		if (!vendas.isEmpty()) {
			// Abaixo está o calculo do valor de custo do período solicitado;
			float somaCusto = 0;
			int somaQtdVendido = 0;
			for (Pedido pedidoCusto : daoPedido.listarPedidosItemProduzidoPorPeriodo(getDataInicial(),
					getDataFinal())) {
				for (ItemDoPedido itemPedidoCusto : pedidoCusto.getItens()) {
					for (ComponenteDoProduto componentes : itemPedidoCusto.getProduto().getComponentes()) {
						float custoMedioUnitarioDoComponente = componentes.getComponente().getValor();
						float qtdUtilizadoNoProduto = componentes.getQtdUtilizada();
						int qtdProduzida = itemPedidoCusto.getQtdProduto();
						somaCusto += qtdProduzida * (custoMedioUnitarioDoComponente * qtdUtilizadoNoProduto);
					}
				}
			}
			// Abaixo está o calculo de vendas do período solicitado;
			float somaVlrTotal = 0;
			for (Venda v : vendas) {
				somaVlrTotal += v.getVlrTotal();
				for (ItemDoPedido itemPedido : v.getPedidoDaVenda().getItens()) {
					somaQtdVendido += itemPedido.getQtdVendida();
				}
			}
			setValorTotalCusto(somaCusto);
			setQtdTotalUndVendida(somaQtdVendido);
			setValorTotalVenda(somaVlrTotal);
		} else {
			context.addMessage(null, new FacesMessage("Aviso", "Não possui movimentação no período informado"));
		}
	}

	public void buscarCliente() {
		context = FacesContext.getCurrentInstance();
		int telefone = 0;
		try {
			telefone = Integer.parseInt(getIdCliente());
			cliente.setNumTelefone(telefone);
			cliente = daoCliente.buscarPornumTelefone(cliente.getNumTelefone());
		} catch (NumberFormatException e) {
			this.cliente = daoCliente.buscarPornome(getIdCliente());
		}

		if (cliente != null) {
			setIdCliente(cliente.getNomeCliente());
		} else {
			cliente = new Cliente();
			context.addMessage(null, new FacesMessage("Aviso", "Cliente não possui cadastro"));
		}
	}

	public void buscarProduto() {
		produto = daoProduto.buscarPorCod(produto.getCodigo());
	}

	public void buscarHistoricoDoPeriodo() {
		context = FacesContext.getCurrentInstance();
		int somaQtdVendido = 0;
		float somaVlrTotal = 0;
		if (produto.getCodigo() > 0) {
			vendas = daoVenda.listarVendasPorProduto(getDataInicial(), getDataFinal(), produto.getCodigo());
			if (!vendas.isEmpty()) {
				setExibir(true);
				for (Venda produtoVenda : vendas) {
					for (ItemDoPedido itemDoPedidoDaVenda : produtoVenda.getPedidoDaVenda().getItens()) {
						if (itemDoPedidoDaVenda.getCod().getCodProduto() == produto.getCodigo()) {
							somaQtdVendido += itemDoPedidoDaVenda.getQtdVendida();
							somaVlrTotal += (itemDoPedidoDaVenda.getProduto().getValor()
									* itemDoPedidoDaVenda.getQtdVendida()) - itemDoPedidoDaVenda.getVlrDescItem();
							itens.add(itemDoPedidoDaVenda);
						}
					}
				}
				setQtdTotalUndVendida(somaQtdVendido);
				setValorTotalVenda(somaVlrTotal);
			} else {
				context.addMessage(null, new FacesMessage("Aviso", "Não possui histórico no período informado"));
			}
		} else {
			vendas = daoVenda.listarVendasPorCliente(getDataInicial(), getDataFinal(), cliente.getNumTelefone());
			if (!vendas.isEmpty()) {
				setExibir(false);
				for (Venda clienteVenda : vendas) {
					somaVlrTotal += clienteVenda.getVlrTotal();
					for (ItemDoPedido itemDoPedidoDaVenda : clienteVenda.getPedidoDaVenda().getItens()) {
						somaQtdVendido += itemDoPedidoDaVenda.getQtdVendida();
						itens.add(itemDoPedidoDaVenda);
					}
				}
				setQtdTotalUndVendida(somaQtdVendido);
				setValorTotalVenda(somaVlrTotal);
			} else {
				context.addMessage(null, new FacesMessage("Aviso", "Não possui histórico no período informado"));
			}
		}
	}

// A baixo estão todos os métodos GET e SET dos atributos da classe;
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public int getQtdTotalUndVendida() {
		return qtdTotalUndVendida;
	}

	public void setQtdTotalUndVendida(int qtdTotalUndVendida) {
		this.qtdTotalUndVendida = qtdTotalUndVendida;
	}

	public float getValorTotalVenda() {
		return valorTotalVenda;
	}

	public void setValorTotalVenda(float valorTotal) {
		this.valorTotalVenda = valorTotal;
	}

	public float getValorTotalCusto() {
		return valorTotalCusto;
	}

	public void setValorTotalCusto(float valorTotalCusto) {
		this.valorTotalCusto = valorTotalCusto;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

	public List<ItemDoPedido> getItens() {
		return itens;
	}

	public boolean isExibir() {
		return exibir;
	}

	public void setExibir(boolean apresentar) {
		this.exibir = apresentar;
	}
}
