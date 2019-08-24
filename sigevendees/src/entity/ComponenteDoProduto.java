package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/*Esta classe representa  a tabela associativa entre o relacionamento de produto e componente, no qual um produto pode ser compostro por varios componentes*/

@Entity
public class ComponenteDoProduto implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ComponenteProdutoPK cod;
	private float qtdUtilizada;
	private Date dataProducao;

	public ComponenteDoProduto() {

	}

	public ComponenteDoProduto(ComponenteProdutoPK cod, float qtdUtilizada) {
		this.cod = cod;
		this.qtdUtilizada = qtdUtilizada;
	}

	public ComponenteProdutoPK getCod() {
		return cod;
	}

	public void setCod(ComponenteProdutoPK cod) {
		this.cod = cod;
	}

	public float getQtdUtilizada() {
		return qtdUtilizada;
	}

	public void setQtdUtilizada(float qtdUtilizada) {
		this.qtdUtilizada = qtdUtilizada;
	}

	public Date getDateProducao() {
		return dataProducao;
	}

	public void setDateProducao(Date dateProducao) {
		this.dataProducao = dateProducao;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComponenteDoProduto other = (ComponenteDoProduto) obj;
		if (cod == null) {
			if (other.cod != null)
				return false;
		} else if (!cod.equals(other.cod))
			return false;
		return true;
	}
}
