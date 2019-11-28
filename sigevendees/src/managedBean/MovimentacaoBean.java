package managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

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

	private Cliente cliente;
	private String idCliente;
	private Produto produto;
	private Date dataInicial;
	private Date dataFinal;
	private int qtdTotalUndVendida;
	private float valorTotalVenda;
	private float valorTotalCusto;
	ArrayList<Pedido> itens;

	public MovimentacaoBean() {
		this.cliente = new Cliente();
		this.produto = new Produto();
		this.itens = new ArrayList<Pedido>();
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
		// Abaixo está o calculo do valor de custo do periodo solicitado;
		float somaCusto = 0;
		int somaQtdVendido = 0;
		for (Pedido pedidoCusto : daoPedido.listarPedidosItemProduzidoPorPeriodo(getDataInicial(), getDataFinal())) {
			for (ItemDoPedido itemPedidoCusto : pedidoCusto.getItens()) {
				for (ComponenteDoProduto componentes : itemPedidoCusto.getProduto().getComponentes()) {
					float custoMedioUnitarioDoComponente = componentes.getComponente().getValor();
					float qtdUtilizadoNoProduto = componentes.getQtdUtilizada();
					int qtdProduzida = itemPedidoCusto.getQtdProduto();
					somaCusto += qtdProduzida * (custoMedioUnitarioDoComponente * qtdUtilizadoNoProduto);
				}
			}
		}

		// Abaixo está o calculo de venda do periodo solicitado;
		float somaVlrTotal = 0;
		for (Venda vendas : daoVenda.listarVendasPorPeriodo(getDataInicial(), getDataFinal())) {
			itens.add(vendas.getItensVenda());
			somaVlrTotal += vendas.getVlrTotal();
		}
		for (Pedido pedidos : itens) {
			for (ItemDoPedido itemPedido : pedidos.getItens()) {
				somaQtdVendido += itemPedido.getQtdVendida();
			}
		}
		setValorTotalCusto(somaCusto);
		setQtdTotalUndVendida(somaQtdVendido);
		setValorTotalVenda(somaVlrTotal);
		itens.clear();
	}

	public void buscarCliente() {
		FacesContext context = FacesContext.getCurrentInstance();
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
		int somaQtdVendido = 0;
		float somaVlrTotal = 0;
		if (!produto.equals(null)) {
			for (Venda vendaProduto : daoVenda.listarVendasPorProduto(getDataInicial(), getDataFinal(),produto.getCodigo())) {
				itens.add(vendaProduto.getItensVenda());
			}
			for (Pedido pedidoDaVenda : itens) {
				for (ItemDoPedido itemDopedidoDaVenda : pedidoDaVenda.getItens()) {
					if (itemDopedidoDaVenda.getCod().getCodProduto() == produto.getCodigo()) {
						somaQtdVendido += itemDopedidoDaVenda.getQtdVendida();
						somaVlrTotal += (itemDopedidoDaVenda.getProduto().getValor()
								* itemDopedidoDaVenda.getQtdVendida()) - itemDopedidoDaVenda.getVlrDescItem();
					}
				}
			}
			setQtdTotalUndVendida(somaQtdVendido);
			setValorTotalVenda(somaVlrTotal);
		} else {
			for (Venda v : daoVenda.listarVendasPorCliente(getDataInicial(), getDataFinal(), cliente.getNumTelefone())) {
				itens.add(v.getItensVenda());
				somaVlrTotal += v.getVlrTotal();
			}
			System.out.println("-----------------------------------");
			for (Pedido p : itens) {
				for (ItemDoPedido ip : p.getItens()) {
					somaQtdVendido += ip.getQtdVendida();
					System.out.println("ITEN DA VENDA: " + ip.getProduto());
				}
			}
			System.out.println("TOTAL DE UNIDADE: " + somaQtdVendido);
			System.out.println("VALOR TOTAL: " + somaVlrTotal);
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

	public ArrayList<Pedido> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Pedido> itens) {
		this.itens = itens;
	}
}
