package entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pedido {

	@Id
	@GeneratedValue
	private int codPedido;

	@JoinColumn(name = "codCliente")
	@ManyToOne
	private Cliente cliente;

	@OneToMany(targetEntity = ItemDoPedido.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ItemDoPedido> itens;

	@Column(nullable = false)
	private Date dataSolicitado;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataEntrega;

	public Pedido() {

	}

	public Pedido(Cliente cliente, Date dataSolicitado, Date dataEntrega) {
		this.cliente = cliente;
		this.dataSolicitado = dataSolicitado;
		this.dataEntrega = dataEntrega;
	}

	public int getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(int codPedido) {
		this.codPedido = codPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemDoPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemDoPedido> itens) {
		this.itens = itens;
	}

	public Date getDataSolicitado() {
		return dataSolicitado;
	}

	public void setDataSolicitado(Date dataSolicitado) {
		this.dataSolicitado = dataSolicitado;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codPedido;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (codPedido != other.codPedido)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pedido [codPedido=" + codPedido + ", cliente=" + cliente.getNomeCliente() + ", itens=" + itens
				+ ", dataSolicitado=" + dataSolicitado + ", dataEntrega=" + dataEntrega + "]";
	}
}
