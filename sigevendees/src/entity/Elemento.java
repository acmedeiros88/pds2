package entity;

import utils.Categoria;
import utils.Unitario;

public class Elemento {

	private int codigo;
	private String descricao;
	private Categoria tipoElemento;
	private Unitario tipoUnitario;
	private float valor;

	public Elemento() {

	}

	public Elemento(int codigo, String descricao, Categoria tipoElemento, Unitario tipoUnitario, float valor) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.tipoElemento = tipoElemento;
		this.tipoUnitario = tipoUnitario;
		this.valor = valor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getTipoElemento() {
		return tipoElemento;
	}

	public void setTipoElemento(Categoria tipoElemento) {
		this.tipoElemento = tipoElemento;
	}

	public Unitario getTipoUnitario() {
		return tipoUnitario;
	}

	public void setTipoUnitario(Unitario tipoUnitario) {
		this.tipoUnitario = tipoUnitario;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
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
		Elemento other = (Elemento) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
}
