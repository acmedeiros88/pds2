package managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import dao.PedidoDao;
import dao.ProdutoDao;
import dao.VendaDao;
import entity.Cliente;
import entity.ItemDoPedido;
import entity.Pedido;
import entity.Produto;
import entity.Venda;
import enumOpc.OpcoesDePagamento;
import enumOpc.Situacao;

@ManagedBean
@SessionScoped
public class VendaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Venda venda;
	private String formaPgm;
	private Pedido pedidoVenda;
	private Cliente clienteVenda;
	private Produto produto;
	private List<ItemDoPedido> itensVendaGeral;
	protected String vlrDescItem;
	protected String qtdItem;
	
	protected FacesContext context;
	@Inject
	private PedidoDao daoPedido = new PedidoDao();
	@Inject
	private VendaDao daoVenda = new VendaDao();
	@Inject
	private ProdutoDao daoProduto = new ProdutoDao();
	
	public VendaBean() {
		this.pedidoVenda = new Pedido();
		this.itensVendaGeral = new ArrayList<ItemDoPedido>();
		this.produto = new Produto();
	}

	@PostConstruct
	public void init() {
		for(Pedido p: daoPedido.listarPedidosVendaGeral()) {
			for(ItemDoPedido i: p.getItens()) {
				this.itensVendaGeral.add(i);
			}
		}
	}

	public String registrarVendaPedido(List<Pedido> pedido) {
		pedidoVenda = pedido.get(0);
		setClienteVenda(pedidoVenda.getCliente());
		float valorTotal = 0;
		float descontoTotal = 0;
		for (ItemDoPedido itens : pedidoVenda.getItens()) {
			itens.setQtdVendida(itens.getQtdProduto());
			itens.setStatusDoItem(Situacao.FINALIZADO.toString());
			valorTotal += itens.getVlrTotalItem();
			descontoTotal += itens.getVlrDescItem();
		}
		this.venda = new Venda(null, new Date(), valorTotal, descontoTotal, pedidoVenda);
		return "/resources/views/venda/venda";
	}

	public void salvar() {
		context = FacesContext.getCurrentInstance();
		this.venda.setFormaPagamento(getFormaPgm());
		if (daoVenda.salvar(this.venda) && daoPedido.atualizar(this.venda.getItensVenda())) {
			this.venda = new Venda();
			setFormaPgm(null);
			setClienteVenda(null);
			context.addMessage(null, new FacesMessage("Sucesso", "Venda registrada"));
		} else {
			context.addMessage(null, new FacesMessage("Erro", "Não foi possivel realizar o registro da venda"));
		}
	}

	// Retorna todas as opções de forma de pagamento que podem ser utilizado em uma venda;
	public OpcoesDePagamento[] getOpcoesPagamento() {
		return OpcoesDePagamento.values();
	}

// A baixo estão todos os métodos GET e SET dos atributos da classe;
	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Pedido getPedidoVenda() {
		return pedidoVenda;
	}

	public void setPedidoVenda(Pedido pedidoVenda) {
		this.pedidoVenda = pedidoVenda;
	}

	public String getFormaPgm() {
		return formaPgm;
	}

	public void setFormaPgm(String formaPgm) {
		this.formaPgm = formaPgm;
	}

	public Cliente getClienteVenda() {
		return clienteVenda;
	}

	public void setClienteVenda(Cliente clienteVenda) {
		this.clienteVenda = clienteVenda;
	}

	public List<ItemDoPedido> getItensVendaGeral() {
		return itensVendaGeral;
	}

	public void setItensVendaGeral(List<ItemDoPedido> itensVendaGeral) {
		this.itensVendaGeral = itensVendaGeral;
	}

	public String getVlrDescItem() {
		return vlrDescItem;
	}

	public void setVlrDescItem(String vlrDescItem) {
		this.vlrDescItem = vlrDescItem;
	}

	public String getQtdItem() {
		return qtdItem;
	}

	public void setQtdItem(String qtdItem) {
		this.qtdItem = qtdItem;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
