package dao;

import java.util.List;

import entity.Produto;

public class ProdutoDao {

	public boolean salvar(Produto produto) {
		return GenericDao.salvar(produto);
	}

	public boolean atualizar(Produto produto) {
		return GenericDao.atualizar(produto);
	}

	public boolean deletarProduto(int cod) {
		return GenericDao.deletar(Produto.class, cod);
	}

	public Produto buscarPorCod(int cod) {
		return (Produto) GenericDao.buscarPorId(Produto.class, cod);
	}

	@SuppressWarnings("unchecked")
	public List<Produto> listaProduto() {
		return (List<Produto>) GenericDao.listarTodos(Produto.class);
	}
}
