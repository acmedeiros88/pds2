package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Componente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false)
	private int codComponente;
	@Column(nullable=false)
	private String desComponente;
	@Column(nullable=false)
	private String tipoComponente;
	@Column(nullable=false)
	private String tipoUnitario;
	@Column(nullable=false)
	private float valorDeCompra;
	@Column(nullable=false)
	private float valorEmEstoque;
	@Column(nullable=false)
	private float estoqueMinimo;
	@Column(nullable=false)
	private float estoqueAtual;

	public Componente() {

	}

	public Componente(String desComponente, String tipoComponente, String tipoUnitario, float estoqueMinimo) {
		this.desComponente = desComponente;
		this.tipoComponente = tipoComponente;
		this.tipoUnitario = tipoUnitario;
		this.estoqueMinimo = estoqueMinimo;
	}

	public int getCodComponente() {
		return codComponente;
	}

	public void setCodComponente(int codComponente) {
		this.codComponente = codComponente;
	}

	public String getDesComponente() {
		return desComponente;
	}

	public void setDesComponente(String desComponente) {
		this.desComponente = desComponente;
	}

	public String getTipoComponente() {
		return tipoComponente;
	}

	public void setTipoComponente(String tipoComponente) {
		this.tipoComponente = tipoComponente;
	}

	public String getTipoUnitario() {
		return tipoUnitario;
	}

	public void setTipoUnitario(String tipoUnitario) {
		this.tipoUnitario = tipoUnitario;
	}

	public float getValorDeCompra() {
		return valorDeCompra;
	}

	public void setValorDeCompra(float valorDeCompra) {
		this.valorDeCompra = valorDeCompra;
	}

	public float getValorEmEstoque() {
		return valorEmEstoque;
	}

	public void setValorEmEstoque(float valorEmEstoque) {
		this.valorEmEstoque = valorEmEstoque;
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
}
