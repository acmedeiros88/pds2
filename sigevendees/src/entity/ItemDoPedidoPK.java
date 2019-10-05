package entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

/* Esta classe representa a composição da chave composta primaria do item do pedido, esta chave e composta por código do pedido + código do produto*/

@Embeddable
public class ItemDoPedidoPK implements Serializable {
	private static final long serialVersionUID = 1L;

	private int codPedido;
	private int codProduto;

	public ItemDoPedidoPK() {

	}

	public ItemDoPedidoPK(int codPedido, int codProduto) {
		this.codPedido = codPedido;
		this.codProduto = codProduto;
	}

	public int getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(int codPedido) {
		this.codPedido = codPedido;
	}

	public int getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(int codProduto) {
		this.codProduto = codProduto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codPedido;
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
		ItemDoPedidoPK other = (ItemDoPedidoPK) obj;
		if (codPedido != other.codPedido)
			return false;
		if (codProduto != other.codProduto)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemDoPedidoPK [codPedido=" + codPedido + ", codProduto=" + codProduto + "]";
	}

}
