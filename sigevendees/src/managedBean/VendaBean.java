package managedBean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import dao.PedidoDao;
import entity.Cliente;
import entity.ItemDoPedido;
import entity.Pedido;
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
	private int contItem;
	
	@Inject
	private PedidoDao daoPedido = new PedidoDao();
	
	public VendaBean() {
		this.pedidoVenda = new Pedido();
		this.contItem = 1;
	}

	@PostConstruct
	public void init() {

	}
	
	public String vendaPedido(List<Pedido> ped) {
		pedidoVenda = ped.get(0);
		setClienteVenda(pedidoVenda.getCliente());
		float valorTotal = 0;
		float descontoTotal = 0;
		for (ItemDoPedido itens : pedidoVenda.getItens()) {
			itens.setQtdVendida(itens.getQtdProduto());
			itens.setStatusDoItem(Situacao.FINALIZADO.toString());
			valorTotal += itens.getVlrTotalItem();
			descontoTotal += itens.getVlrDescItem();
		}
		this.venda = new Venda(getFormaPgm(), new Date(), valorTotal, descontoTotal, pedidoVenda);
		return "/resources/views/venda/venda";
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

	public int getContItem() {
		return contItem;
	}

	public void setContItem(int contItem) {
		this.contItem = contItem;
	}
}
