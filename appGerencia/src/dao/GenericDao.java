package dao;

import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.TransactionalException;

import fabricaConecxao.FabricaJPA;

public class GenericDao implements InterfaceDao {

	public boolean salvar(Object objeto) {
		EntityManager entityManager = FabricaJPA.getEntityManagerFactory().createEntityManager();
		boolean resultado = true;
		try {
			entityManager.getTransaction().begin();

			entityManager.persist(objeto);

			entityManager.getTransaction().commit();
		} catch (EntityExistsException | TransactionalException e) {
			resultado = false;
			FabricaJPA.shutdown();
		}

		return resultado;
	}

	public boolean atualizar(Object objeto) {
		boolean resultado = true;
		EntityManager entityManager = FabricaJPA.getEntityManagerFactory().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(objeto);
			entityManager.getTransaction().commit();
			resultado = true;
		} catch (EntityExistsException | TransactionalException e) {
			resultado = false;
			FabricaJPA.shutdown();
		}
		return resultado;
	}

	public boolean deletar(Class<?> classe, int id) {
		EntityManager entityManager = FabricaJPA.getEntityManagerFactory().createEntityManager();
		boolean resultado = true;
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entityManager.find(classe, id));

			entityManager.getTransaction().commit();
		} catch (EntityExistsException | TransactionalException e) {
			resultado = false;
			FabricaJPA.shutdown();
		}

		return resultado;
	}

	public Object buscarPorId(Class<?> classe, int id) {
		EntityManager entityManager = FabricaJPA.getEntityManagerFactory().createEntityManager();
		Object resultado;
		try {
			entityManager.getTransaction().begin();

			resultado = entityManager.find(classe, id);

			entityManager.getTransaction().commit();
		} catch (EntityExistsException | TransactionalException e) {
			resultado = null;
			FabricaJPA.shutdown();
		}

		return resultado;
	}

	@SuppressWarnings("unchecked")
	public List<?> listarTodos(Class<?> classe) {
		EntityManager entityManager = FabricaJPA.getEntityManagerFactory().createEntityManager();
		List<Object> lista;
		try {
			String tabela = classe.getName();
			String jpql = "from "+ tabela;
			TypedQuery<Object> q = (TypedQuery<Object>) entityManager.createQuery(jpql, classe);
			lista = (List<Object>) q.getResultList();
		} catch (EntityExistsException | TransactionalException e) {
			lista = null;
			FabricaJPA.shutdown();
		}

		return lista;
	}

}
