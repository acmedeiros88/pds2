package entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

/* Esta classe representa a composicao da chave do produto, esta chave e composta por codigo do componente + codigo do produto*/

@Embeddable
public class ComponenteProdutoPK implements Serializable {
	private static final long serialVersionUID = 1L;

	private int codProduto;
	private int codComponente;

	public ComponenteProdutoPK() {

	}

	public ComponenteProdutoPK(int codProduto, int codComponente) {
		this.codProduto = codProduto;
		this.codComponente = codComponente;
	}

	public int getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(int codProduto) {
		this.codProduto = codProduto;
	}

	public int getCodComponente() {
		return codComponente;
	}

	public void setCodComponente(int codComponente) {
		this.codComponente = codComponente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codComponente;
		result = prime * result + codProduto;
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
		ComponenteProdutoPK other = (ComponenteProdutoPK) obj;
		if (codComponente != other.codComponente)
			return false;
		if (codProduto != other.codProduto)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ComponenteDoProduto [codProduto=" + codProduto + ", codComponente=" + codComponente + "]";
	}

}
