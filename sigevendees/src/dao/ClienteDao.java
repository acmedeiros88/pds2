package dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.TransactionalException;

import entity.Cliente;
import factoryConnection.FactoryJPA;

public class ClienteDao {
	public boolean salvar(Cliente cliente) {
		if (GenericDao.buscarPorId(Cliente.class, cliente.getNumTelefone()) == null) {
			return GenericDao.salvar(cliente);
		}
		return GenericDao.atualizar(cliente);
	}

	public Cliente buscarPornumTelefone(int numTelefone) {
		return (Cliente) GenericDao.buscarPorId(Cliente.class, numTelefone);
	}

	public Cliente buscarPornome(String nome) {
		EntityManager entityManager = FactoryJPA.getEntityManagerFactory().createEntityManager();
		Cliente resultado = null;
		try {
			String jpql = "SELECT c FROM Cliente c WHERE c.nomeCliente LIKE CONCAT( '%',TRIM(:nome),'%')";
			entityManager.getTransaction().begin();
			try {
				resultado = (Cliente) entityManager.createQuery(jpql).setParameter("nome", nome).getSingleResult();
			} catch (NoResultException e) {
				return resultado;
			}

		} catch (EntityExistsException | TransactionalException e) {
			FactoryJPA.shutdown();
			return resultado;
		}
		return resultado;
	}

	public boolean deletarCliente(int numTelefone) {
		return GenericDao.deletar(Cliente.class, numTelefone);
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> listarClientes() {
		return (List<Cliente>) GenericDao.listarTodos(Cliente.class);
	}
}
