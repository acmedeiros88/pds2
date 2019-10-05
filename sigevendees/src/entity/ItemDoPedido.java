package entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/*Esta classe representa  a tabela associativa entre o relacionamento de pedido e produto,
 * no qual um pedido pode ser composto por vários produtos*/

@Entity
public class ItemDoPedido {

	@EmbeddedId
	private ItemDoPedidoPK cod;
	private int qtdProduto;
	private float vlrDescItem;
	private float vlrTotalItem;
	private String situacao;

	public ItemDoPedido() {

	}

	public ItemDoPedido(ItemDoPedidoPK cod, int qtdProduto, float vlrDescItem, float vlrTotalItem, String situacao) {
		this.cod = cod;
		this.qtdProduto = qtdProduto;
		this.vlrDescItem = vlrDescItem;
		this.vlrTotalItem = vlrTotalItem;
		this.situacao = situacao;
	}

	public ItemDoPedidoPK getCod() {
		return cod;
	}

	public void setCod(ItemDoPedidoPK cod) {
		this.cod = cod;
	}

	public int getQtdProduto() {
		return qtdProduto;
	}

	public void setQtdProduto(int qtdProduto) {
		this.qtdProduto = qtdProduto;
	}

	public float getVlrDescItem() {
		return vlrDescItem;
	}

	public void setVlrDescItem(float vlrDescItem) {
		this.vlrDescItem = vlrDescItem;
	}

	public float getVlrTotalItem() {
		return vlrTotalItem;
	}

	public void setVlrTotalItem(float vlrTotalItem) {
		this.vlrTotalItem = vlrTotalItem;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemDoPedido other = (ItemDoPedido) obj;
		if (cod == null) {
			if (other.cod != null)
				return false;
		} else if (!cod.equals(other.cod))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemDoPedido [cod=" + cod + ", qtdProduto=" + qtdProduto + ", vlrDescItem=" + vlrDescItem
				+ ", vlrTotalItem=" + vlrTotalItem + ", situacao=" + situacao + "]";
	}
}
