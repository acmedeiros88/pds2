package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/*Esta classe é responsável por o registro de aquisições de componentes, o qual ira a qtdAdquirida atualiza o valor do estoque atual;*/

@Entity
public class Aquisicao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codAquisicao;

	@OneToOne
	private Componente componenteAdquirido;

	@Column(nullable = false)
	private float qtdAdquirida;

	@Column(nullable = false)
	private float custoDaAquisicao;

	@Column(nullable = false)
	private Date dataDaAquisicao;

	public Aquisicao() {

	}

	public Aquisicao(Componente componenteAdquirido, float qtdAdquirida, float custoDaAquisicao, Date dataDaAquisicao) {
		this.componenteAdquirido = componenteAdquirido;
		this.qtdAdquirida = qtdAdquirida;
		this.custoDaAquisicao = custoDaAquisicao;
		this.dataDaAquisicao = dataDaAquisicao;
	}

	public int getCodAquisicao() {
		return codAquisicao;
	}

	public void setCodAquisicao(int codAquisicao) {
		this.codAquisicao = codAquisicao;
	}

	public Componente getComponenteAdquirido() {
		return componenteAdquirido;
	}

	public void setComponenteAdquirido(Componente componenteAdquirido) {
		this.componenteAdquirido = componenteAdquirido;
	}

	public float getQtdAdquirida() {
		return qtdAdquirida;
	}

	public void setQtdAdquirida(float qtdAdquirida) {
		this.qtdAdquirida = qtdAdquirida;
	}

	public float getCustoDaAquisicao() {
		return custoDaAquisicao;
	}

	public void setCustoDaAquisicao(float custoDaAquisicao) {
		this.custoDaAquisicao = custoDaAquisicao;
	}

	public Date getDataDaAquisicao() {
		return dataDaAquisicao;
	}

	public void setDataDaAquisicao(Date dataDaAquisicao) {
		this.dataDaAquisicao = dataDaAquisicao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codAquisicao;
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
		Aquisicao other = (Aquisicao) obj;
		if (codAquisicao != other.codAquisicao)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aquisicao [codAquisicao=" + codAquisicao + ", componenteAdquirido=" + componenteAdquirido
				+ ", qtdAdquirida=" + qtdAdquirida + ", custoDaAquisicao=" + custoDaAquisicao + ", dataDaAquisicao="
				+ dataDaAquisicao + "]";
	}
}
