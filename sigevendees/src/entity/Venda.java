package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Venda {

	@Id
	@GeneratedValue
	private int codVenda;

	@Column(nullable = false)
	private String formaPagamento;

	@Column(nullable = false)
	private Date dataRealizada;

	@Column(nullable = false)
	private float vlrTotal;

	@Column(nullable = false)
	private float vlrTotalDesconto;

	@JoinColumn(name = "codPedido")
	@ManyToOne
	private Pedido pedidoDaVenda;

	public Venda() {

	}

	public Venda(String formaPagamento, Date dataRealizada, float vlrTotal, float vlrTotalDesconto, Pedido pedido) {
		this.formaPagamento = formaPagamento;
		this.dataRealizada = dataRealizada;
		this.vlrTotal = vlrTotal;
		this.vlrTotalDesconto = vlrTotalDesconto;
		this.pedidoDaVenda = pedido;
	}

	public int getCodVenda() {
		return codVenda;
	}

	public void setCodVenda(int codVenda) {
		this.codVenda = codVenda;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Date getDataRealizada() {
		return dataRealizada;
	}

	public void setDataRealizada(Date dataRealizada) {
		this.dataRealizada = dataRealizada;
	}

	public float getVlrTotal() {
		return vlrTotal;
	}

	public void setVlrTotal(float vlrTotal) {
		this.vlrTotal = vlrTotal;
	}

	public float getVlrTotalDesconto() {
		return vlrTotalDesconto;
	}

	public void setVlrTotalDesconto(float vlrTotalDesconto) {
		this.vlrTotalDesconto = vlrTotalDesconto;
	}

	public Pedido getPedidoDaVenda() {
		return pedidoDaVenda;
	}

	public void setPedidoDaVenda(Pedido itensVenda) {
		this.pedidoDaVenda = itensVenda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codVenda;
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
		Venda other = (Venda) obj;
		if (codVenda != other.codVenda)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Venda [codVenda=" + codVenda + ", formaPagamento=" + formaPagamento + ", dataRealizada=" + dataRealizada
				+ ", vlrTotal=" + vlrTotal + ", vlrTotalDesconto=" + vlrTotalDesconto + ", pedidoDaVenda="
				+ pedidoDaVenda + "]";
	}
}
