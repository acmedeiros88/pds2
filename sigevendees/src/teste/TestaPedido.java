package teste;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Tuple;

import dao.ClienteDao;
import dao.PedidoDao;
import dao.ProdutoDao;
import entity.Cliente;
import entity.ItemDoPedido;
import entity.ItemDoPedidoPK;
import entity.Pedido;
import entity.Produto;

public class TestaPedido {

	public static void main(String[] args) {
		/*
		 * // ABAIXO ESTA O TESTE DA CLASSE PEDIDO;
		 * 
		 * // Identifica o cliente; Cliente cliente = new Cliente();
		 * cliente.setNumTelefone(1234); cliente.setNomeCliente("adriano");
		 * 
		 * // Identifica o 1º produto solicitado; Produto produto = new Produto();
		 * produto.setCodigo(1); produto.setDescricao("Bolo de morango"); // Cria a
		 * chave primaria composta do 1º item do pedido; ItemDoPedidoPK pk = new
		 * ItemDoPedidoPK(); pk.setCodPedido(0); pk.setCodProduto(produto.getCodigo());
		 * // Cria o 1º item do pedido: id, qtdProduto, vlrDescItem, vlrTotalItem;
		 * ItemDoPedido primeiro = new ItemDoPedido(pk, 1, 0, 7);
		 * 
		 * // Identifica o 2º produto solicitado; Produto produto1 = new Produto();
		 * produto1.setCodigo(2); produto1.setDescricao("Bolo de chocolate"); // Cria a
		 * chave primaria composta do 2º item do pedido ItemDoPedidoPK pk1 = new
		 * ItemDoPedidoPK(); pk1.setCodPedido(0);
		 * pk1.setCodProduto(produto1.getCodigo()); // Cria o 2º item do pedido: id,
		 * qtdProduto, vlrDescItem, vlrTotalItem; ItemDoPedido segundo = new
		 * ItemDoPedido(pk1, 2, 0, 14);
		 * 
		 * // Identifica o 3º produto solicitado; Produto produto2 = new Produto();
		 * produto2.setCodigo(3); produto2.setDescricao("Bolo de morango"); // Cria a
		 * chave primaria composta do 3º item do pedido ItemDoPedidoPK pk2 = new
		 * ItemDoPedidoPK(); pk2.setCodPedido(0);
		 * pk2.setCodProduto(produto2.getCodigo()); // Cria o 1º item do pedido: id,
		 * qtdProduto, vlrDescItem, vlrTotalItem; ItemDoPedido terceiro = new
		 * ItemDoPedido(pk2, 1, 0, 7);
		 * 
		 * // Adiciona o item a lista do pedido; List<ItemDoPedido> iten = new
		 * ArrayList<ItemDoPedido>(); iten.add(primeiro); iten.add(segundo);
		 * iten.add(terceiro);
		 * 
		 * // Cria o pedido; Pedido pedido = new Pedido(cliente, new Date(), new
		 * Date()); pedido.setItens(iten); System.out.print(pedido);
		 */

//ABAIXO ESTA O TESTE SALVAR PEDIDO NO BD
		/*
		 * // Identifica o cliente; ClienteDao daoCliente = new ClienteDao(); Cliente
		 * cliente = daoCliente.buscarPornumTelefone(123);
		 * 
		 * // cria o pedido e salva no BD PedidoDao dao = new PedidoDao(); Pedido pedido
		 * = new Pedido(cliente, new Date(), new Date()); dao.salvar(pedido); //Buscao o
		 * id do ultimo produto salvo no BD; int lastId = dao.getLastInsertId(); //Busca
		 * o pedido pelo o id; Pedido pedidoRetornado = dao.buscarPorCod(lastId);
		 * 
		 * //Cria uma lista de itens de pedido; List<ItemDoPedido> itens = new
		 * ArrayList<ItemDoPedido>(); // Cria uma lista de produtos; List<Produto>
		 * listaDeProdutos = new ArrayList<Produto>();
		 * 
		 * // Identifica e busca o produto solicitado; ProdutoDao daoProduto = new
		 * ProdutoDao(); Produto produto_A = daoProduto.buscarPorCod(8); // Adiciona o
		 * produto solicitado a lista; listaDeProdutos.add(produto_A); // cliente
		 * solicitou mais produto? //Sim // Identifica e busca o segundo produto
		 * solicitado, adiciona o produto a lista; Produto produto_B =
		 * daoProduto.buscarPorCod(10); listaDeProdutos.add(produto_B); // Identifica e
		 * busca o terceiro produto solicitado, adiciona o produto a lista; Produto
		 * produto_C = daoProduto.buscarPorCod(13); listaDeProdutos.add(produto_C);
		 * 
		 * // Cria uma chave primaria composta do item do pedido; ItemDoPedidoPK pk =
		 * new ItemDoPedidoPK(); // Percore a lista de produtos para criar os itens do
		 * pedido; for(Produto p: listaDeProdutos) {
		 * pk.setCodPedido(pedidoRetornado.getCodPedido());
		 * pk.setCodProduto(p.getCodigo()); itens.add(new ItemDoPedido(pk, 1, 0,
		 * p.getValor())); pk = new ItemDoPedidoPK(); } // Adiciona a lista de itens a
		 * lista do pedido; pedidoRetornado.setItens(itens); // Salva a lista de itens
		 * no BD; dao.atualizar(pedidoRetornado);
		 */
		PedidoDao dao = new PedidoDao();
		for (Pedido p : dao.listarPedidosItemProduzir()) {
			System.out.println();

			System.out.println(" --------------------------");
			System.out.println("pedido = " + p.getCodPedido());
			// if (p.getCodPedido() == 21) {
			System.out.println(p.getItens());
			if (p.getItens().size() > 0) {
				System.out.println(" itens do pedido");
				for (ItemDoPedido ip : p.getItens()) {
					System.out.println(" codigo do produto " + ip.getCod().getCodProduto());
					System.out.println(ip.getProduto().getDescricao());
					System.out.println(ip.getProduto().getValor());
				}
			} else {
				System.out.println(" pedido sem itens");
			}

			// }
		}
	}
}
