package entity;

public class Elemento {

	private int codigo;
	private String descricao;
	private String tipoElemento;
	private String tipoUnitario;
	private float valor;

	public Elemento() {

	}

	public Elemento(String descricao, String tipoElemento, String tipoUnitario, float valor) {
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

	public String getTipoElemento() {
		return tipoElemento;
	}

	public void setTipoElemento(String tipoElemento) {
		this.tipoElemento = tipoElemento;
	}

	public String getTipoUnitario() {
		return tipoUnitario;
	}

	public void setTipoUnitario(String tipoUnitario) {
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
