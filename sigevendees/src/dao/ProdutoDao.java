package dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.TransactionalException;

import entity.Produto;
import factoryConnection.FactoryJPA;

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

	public int getLastInsertId() {
		EntityManager entityManager = FactoryJPA.getEntityManagerFactory().createEntityManager();
		int resultado = -1;
		try {
			String jpql = "SELECT MAX(codigo) FROM Produto";
			Query query = entityManager.createQuery(jpql);
			resultado = (int) query.getSingleResult();
		} catch (EntityExistsException | TransactionalException e) {
			FactoryJPA.shutdown();
			return resultado;
		}
		return resultado;
	}

	@SuppressWarnings("unchecked")
	public List<Produto> listaProduto() {
		return (List<Produto>) GenericDao.listarTodos(Produto.class);
	}
}
