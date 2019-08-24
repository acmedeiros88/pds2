package teste;

import java.util.ArrayList;
import java.util.List;

import dao.ProdutoDao;
import entity.ComponenteDoProduto;
import entity.ComponenteProdutoPK;
import entity.Elemento;
import entity.Produto;

public class TestaProduto {

	public static void main(String[] args) {
		
		/* Cria um elemento */
		Elemento el = new Elemento();
		el.setDescricao("Teste produto");
		el.setTipoElemento("bolo");
		el.setTipoUnitario("und");
		el.setValor((float) 7.00);
		
		/*DAO para persistir no BD*/
		ProdutoDao dao = new ProdutoDao();
		
		/* Cria um produto, busca o elemento e salva como um produto 
		Produto p1 = new Produto(el.getDescricao(), el.getTipoElemento(), el.getTipoUnitario(), el.getValor());
		
		Salva o produto no BD
		dao.salvar(p1);
		*/
		
		/*Buscar o ultimo produto salvo no BD, nesse caso é o primeiro produto do BD*/
		Produto p2 = dao.buscarPorCod(1);
		
		/* Cria uma lista de componentes e busca a lista de componentes do produto */
		List<ComponenteDoProduto> lista = p2.getComponentes();

		/* Cria a chave composta */
		ComponenteProdutoPK pk1 = new ComponenteProdutoPK();
		pk1.setCodProduto(p2.getCodigo());
		pk1.setCodComponente(4);
		
		ComponenteProdutoPK pk2 = new ComponenteProdutoPK();
		pk2.setCodProduto(p2.getCodigo());
		pk2.setCodComponente(5);
		
		ComponenteProdutoPK pk3 = new ComponenteProdutoPK();
		pk3.setCodProduto(p2.getCodigo());
		pk3.setCodComponente(6);

		/* Adiciona na lista a chave composta e a quantidade utilizada */
		lista.add(new ComponenteDoProduto(pk1, 100));
		lista.add(new ComponenteDoProduto(pk2, 200));
		lista.add(new ComponenteDoProduto(pk3, 300));

		/* adiciona na lista de componentes do produto */
		p2.setComponentes(lista);

		/* Atualiza a lista de componentes do produto */
		dao.atualizar(p2);

	}

}
