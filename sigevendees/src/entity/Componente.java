package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Componente extends Elemento {

	// Código do produto, será gerado pelo BD;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codComponente")
	@Override
	public int getCodigo() {
		return super.getCodigo();
	}

	@Column(name = "desComponente", nullable = false)
	@Override
	public String getDescricao() {
		return super.getDescricao();
	}

	@Column(name = "tipoComponente", nullable = false)
	@Override
	public String getTipoElemento() {
		return super.getTipoElemento();
	}

	@Column(name = "tipoUnitario", nullable = false)
	@Override
	public String getTipoUnitario() {
		return super.getTipoUnitario();
	}

	@Column(name = "precoMedioDoCustoUnitario", nullable = true)
	@Override
	public float getValor() {
		return super.getValor();
	}

	@Column(name = "estoqueMinimo", nullable = true)
	private float estoqueMinimo;

	@Column(name = "estoqueAtual", nullable = true)
	private float estoqueAtual;

	public Componente() {

	}

	public Componente(String descricao, String tipoElemento, String tipoUnitario, float estoqueMin) {
		setDescricao(descricao);
		setTipoElemento(tipoElemento);
		setTipoUnitario(tipoUnitario);
		this.estoqueMinimo = estoqueMin;
	}

	public float getEstoqueMinimo() {
		return estoqueMinimo;
	}

	public void setEstoqueMinimo(float estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	public float getEstoqueAtual() {
		return estoqueAtual;
	}

	public void setEstoqueAtual(float estoqueAtual) {
		this.estoqueAtual = estoqueAtual;
	}

	@Override
	public String toString() {
		return "Componente [" + "getCodigo()=" + getCodigo() + ", getDescricao()=" + getDescricao()
				+ ", getTipoElemento()=" + getTipoElemento() + ", getTipoUnitario()=" + getTipoUnitario()
				+ ", getValor()=" + getValor() + ", getEstoqueMinimo()=" + getEstoqueMinimo() + ", getEstoqueAtual()="
				+ getEstoqueAtual() + "]";
	}
}
