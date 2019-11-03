package entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Venda {

	@Id
	@GeneratedValue
	private int codVenda;

	@Column(nullable = false)
	private String opcPagamento;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataRealizada;

	@Column(nullable = false)
	private float vlrTotal;

	@OneToMany(targetEntity = Pedido.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Pedido> pedidos;

	public Venda() {

	}

	public Venda(String opcPagamento, Date dataRealizada, float vlrTotal, List<Pedido> pedidos) {
		this.opcPagamento = opcPagamento;
		this.dataRealizada = dataRealizada;
		this.vlrTotal = vlrTotal;
		this.pedidos = pedidos;
	}

	public int getCodVenda() {
		return codVenda;
	}

	public void setCodVenda(int codVenda) {
		this.codVenda = codVenda;
	}

	public String getOpcPagamento() {
		return opcPagamento;
	}

	public void setOpcPagamento(String opcPagamento) {
		this.opcPagamento = opcPagamento;
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

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
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
		return "Venda [codVenda=" + codVenda + ", opcPagamento=" + opcPagamento + ", dataRealizada=" + dataRealizada
				+ ", vlrTotal=" + vlrTotal + ", pedidos=" + pedidos + "]";
	}
}
