package teste;

import java.util.Date;
import dao.PedidoDao;
import dao.VendaDao;
import entity.ItemDoPedido;
import entity.Pedido;
import entity.Venda;
import enumOpc.OpcoesDePagamento;
import enumOpc.Situacao;

public class TestaVenda {

	public static void main(String[] args) {
		PedidoDao daoPedido = new PedidoDao();
		VendaDao daoVenda = new VendaDao();
		Pedido pedidoVenda = daoPedido.buscarPorCod(16);
		float valorTotal = 0;
		float descontoTotal = 0;
		String pgm = OpcoesDePagamento.DINHEIRO.toString();
		for (ItemDoPedido itens : pedidoVenda.getItens()) {
			itens.setQtdVendida(itens.getQtdProduto());
			itens.setStatusDoItem(Situacao.FINALIZADO.toString());
			valorTotal += itens.getVlrTotalItem();
			descontoTotal += itens.getVlrDescItem();
		}
		
		Venda venda = new Venda(pgm, new Date(), valorTotal, descontoTotal, pedidoVenda);
		daoVenda.salvar(venda);
		daoPedido.atualizar(pedidoVenda);
		
	}

}
