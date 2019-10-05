package teste;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Cliente;
import entity.ItemDoPedido;
import entity.ItemDoPedidoPK;
import entity.Pedido;
import entity.Produto;

public class TestaPedido {

	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		Produto produto = new Produto();

		cliente.setNomeCliente("adriano");
		produto.setCodigo(1);

		ItemDoPedidoPK pk = new ItemDoPedidoPK();
		pk.setCodProduto(produto.getCodigo());
		pk.setCodPedido(0);

		produto.setCodigo(2);

		ItemDoPedidoPK pk1 = new ItemDoPedidoPK();
		pk1.setCodProduto(produto.getCodigo());
		pk1.setCodPedido(0);

		List<ItemDoPedido> iten = new ArrayList<ItemDoPedido>();

		iten.add(new ItemDoPedido(pk, 1, 0, 7, "a Produzir"));
		iten.add(new ItemDoPedido(pk1, 2, 0, 14, "a Produzir"));

		Pedido pedido = new Pedido(cliente, iten, new Date(), new Date());

		System.out.print(pedido);

	}

}
