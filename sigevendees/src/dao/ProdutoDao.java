package dao;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.transaction.TransactionalException;

import entity.ComponenteProdutoPK;
import entity.Produto;
import factoryConnection.FactoryJPA;

public class ProdutoDao {

	public boolean salvar(Produto produto) {
		return GenericDao.salvar(produto);
	}

	public boolean atualizar(Produto produto) {
		return GenericDao.atualizar(produto);
	}

	public boolean deletar(ComponenteProdutoPK cod) {
		EntityManager entityManager = FactoryJPA.getEntityManagerFactory().createEntityManager();
		boolean resultado = true;
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entityManager.find(Produto.class, cod));

			entityManager.getTransaction().commit();
		} catch (EntityExistsException | TransactionalException e) {
			resultado = false;
			FactoryJPA.shutdown();
		}

		return resultado;
	}

	public Produto buscarPorCod(ComponenteProdutoPK cod) {
		EntityManager entityManager = FactoryJPA.getEntityManagerFactory().createEntityManager();
		Produto resultado;
		try {
			entityManager.getTransaction().begin();
			resultado = entityManager.find(Produto.class, cod);
			entityManager.getTransaction().commit();
		} catch (EntityExistsException | TransactionalException e) {
			resultado = null;
			FactoryJPA.shutdown();
		}
		return resultado;
	}
}
