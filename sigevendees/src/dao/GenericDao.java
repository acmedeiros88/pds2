package dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.transaction.TransactionalException;
import factoryConnection.FactoryJPA;

public class GenericDao {

	public static boolean salvar(Object objeto) {
		EntityManager entityManager = FactoryJPA.getEntityManagerFactory().createEntityManager();
		boolean resultado = true;
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(objeto);
			entityManager.getTransaction().commit();
		} catch (EntityExistsException | TransactionalException e) {
			resultado = false;
			FactoryJPA.shutdown();
		}
		return resultado;
	}

	public static boolean atualizar(Object objeto) {
		boolean resultado = true;
		EntityManager entityManager = FactoryJPA.getEntityManagerFactory().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(objeto);
			entityManager.getTransaction().commit();
			resultado = true;
		} catch (EntityExistsException | TransactionalException e) {
			resultado = false;
			FactoryJPA.shutdown();
		}
		return resultado;
	}

	public static boolean deletar(Class<?> classe, float id) {
		EntityManager entityManager = FactoryJPA.getEntityManagerFactory().createEntityManager();
		boolean resultado = true;
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entityManager.find(classe, id));

			entityManager.getTransaction().commit();
		} catch (EntityExistsException | TransactionalException e) {
			resultado = false;
			FactoryJPA.shutdown();
		}

		return resultado;
	}

	public static Object buscarPorId(Class<?> classe, float id) {
		EntityManager entityManager = FactoryJPA.getEntityManagerFactory().createEntityManager();
		Object resultado;
		try {
			entityManager.getTransaction().begin();
			resultado = entityManager.find(classe, id);
			entityManager.getTransaction().commit();
		} catch (EntityExistsException | TransactionalException e) {
			resultado = null;
			FactoryJPA.shutdown();
		}
		return resultado;
	}

	public static List<?> listarTodos(Class<?> classe) {
		EntityManager entityManager = FactoryJPA.getEntityManagerFactory().createEntityManager();
		List<?> lista;
		try {
			String tabela = classe.getName();
			String jpql = "SELECT t FROM " + tabela + " t";
			lista = entityManager.createQuery(jpql, classe).getResultList();
		} catch (EntityExistsException | TransactionalException e) {
			lista = null;
			FactoryJPA.shutdown();
		}
		return lista;
	}
}
