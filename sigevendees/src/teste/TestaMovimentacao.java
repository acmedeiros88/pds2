package teste;

import java.util.ArrayList;
import java.util.Date;

import dao.PedidoDao;
import dao.VendaDao;
import entity.ComponenteDoProduto;
import entity.ItemDoPedido;
import entity.Pedido;
import entity.Venda;

public class TestaMovimentacao {

	public static void main(String[] args) {
		
		PedidoDao daoPedido = new PedidoDao();
		VendaDao daoVenda = new VendaDao();
		
		Date inicial= new Date();
		Date fim = new Date();
		int qtdTotalUndVendida = 0;
		float vlrTotal = 0;
		ArrayList<Pedido> itens = new ArrayList<Pedido>();
		
// ABAIXO ESTÁ O TESTE PARA CONSULTAR HISTÓRICO DE VENDA POR PERIODO DO CLIENTE;
				for (Venda v: daoVenda.listarVendasPorCliente(inicial, fim, 123)) {
					System.out.println(v);
					vlrTotal+=v.getVlrTotal();
					for(ItemDoPedido ip: v.getPedidoDaVenda().getItens()) {
						qtdTotalUndVendida+=ip.getQtdVendida();
						System.out.println("ITEN DA VENDA: "+ip.getProduto());
					}
				}
				System.out.println("-----------------------------------");
				System.out.println("TOTAL DE UNIDADE: "+qtdTotalUndVendida);
				System.out.println("VALOR TOTAL: "+vlrTotal);
/*
// ABAIXO ESTÁ O TESTE PARA CONSULTAR HISTÓRICO DE VENDA POR PERIODO DO PRODUTO;
				for(Venda vp: daoVenda.listarVendasPorProduto(inicial, fim, 14)) {
					itens.add(vp.getPedidoDaVenda());
					System.out.println(vp);
				}
				System.out.println("-----------------------------------");
				for(Pedido pv: itens) {
					for(ItemDoPedido ipv: pv.getItens()) {
						if(ipv.getCod().getCodProduto()==14) {
							qtdTotalUndVendida+= ipv.getQtdVendida();
							vlrTotal+=(ipv.getProduto().getValor()*ipv.getQtdVendida())-ipv.getVlrDescItem();
							System.out.println("ITEN DA VENDA: "+ipv.getProduto());
						}
					}
				}
				System.out.println("TOTAL DE UNIDADE: "+qtdTotalUndVendida);
				System.out.println("VALOR TOTAL: "+vlrTotal);
			
// ABAIXO ESTÁ O TESTE PARA VALOR DE CUSTO DO PERIODO SOLICITADO;
		float custo = 0;
		for(Pedido pc: daoPedido.listarPedidosItemProduzidoPorPeriodo(inicial, fim)) {
			for(ItemDoPedido ipc: pc.getItens()) {
				for(ComponenteDoProduto cpc: ipc.getProduto().getComponentes()) {
					float custoMedioUnitarioDoComponente = cpc.getComponente().getValor();
					float qtdUtilizadoNoProduto = cpc.getQtdUtilizada();
					int qtdProduzida = ipc.getQtdProduto();
					custo+= qtdProduzida*(custoMedioUnitarioDoComponente*qtdUtilizadoNoProduto);
				}
			}
		}
		System.out.println("CUSTO TOTAL: "+custo);

		
		for (Venda v: daoVenda.listarVendasPorCliente(inicial, fim, 123)) {
			itens.add(v.getPedidoDaVenda());
			System.out.println(v);
			vlrTotal+=v.getVlrTotal();
		}
		System.out.println("-----------------------------------");
		for(Pedido p: itens) {
			for(ItemDoPedido ip: p.getItens()) {
				qtdTotalUndVendida+=ip.getQtdVendida();
				System.out.println("ITEN DA VENDA: "+ip.getProduto());
			}
		}
		System.out.println("TOTAL DE UNIDADE: "+qtdTotalUndVendida);
		System.out.println("VALOR TOTAL: "+vlrTotal);
		*/
	}

}
