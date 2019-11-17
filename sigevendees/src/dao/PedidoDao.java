package dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.TransactionalException;

import entity.Pedido;
import factoryConnection.FactoryJPA;

public class PedidoDao {

	public boolean salvar(Pedido pedido) {
		return GenericDao.salvar(pedido);
	}

	public boolean atualizar(Pedido pedido) {
		return GenericDao.atualizar(pedido);
	}

	public Pedido buscarPorCod(int cod) {
		return (Pedido) GenericDao.buscarPorId(Pedido.class, cod);
	}

	public boolean deletarPedido(int cod) {
		return GenericDao.deletar(Pedido.class, cod);
	}

	public int getLastInsertId() {
		EntityManager entityManager = FactoryJPA.getEntityManagerFactory().createEntityManager();
		int resultado = -1;
		try {
			String jpql = "SELECT MAX(codPedido) FROM Pedido";
			Query query = entityManager.createQuery(jpql);
			resultado = (int) query.getSingleResult();
		} catch (EntityExistsException | TransactionalException e) {
			FactoryJPA.shutdown();
			return resultado;
		}
		return resultado;
	}

	public List<Pedido> listarPedidosItemProduzir() {
		EntityManager entityManager = FactoryJPA.getEntityManagerFactory().createEntityManager();
		List<Pedido> pedidos;
		try {
			String jpql = "SELECT p FROM Pedido p WHERE p.codPedido IN (SELECT i.cod.codPedido FROM ItemDoPedido i WHERE i.statusDoItem LIKE('%PRODUZIR%'))";
			entityManager.getTransaction().begin();
			pedidos = entityManager.createQuery(jpql, Pedido.class).getResultList();
		} catch (EntityExistsException | TransactionalException e) {
			pedidos = null;
			FactoryJPA.shutdown();
		}
		return pedidos;
	}

	public List<Pedido> listarPedidosItemProduzido() {
		EntityManager entityManager = FactoryJPA.getEntityManagerFactory().createEntityManager();
		List<Pedido> pedidos;
		try {
			String jpql = "SELECT p FROM Pedido p WHERE p.codPedido IN (SELECT i.cod.codPedido FROM ItemDoPedido i WHERE i.statusDoItem LIKE('%PRODUZIDO%'))";
			entityManager.getTransaction().begin();
			pedidos = entityManager.createQuery(jpql, Pedido.class).getResultList();
		} catch (EntityExistsException | TransactionalException e) {
			pedidos = null;
			FactoryJPA.shutdown();
		}
		return pedidos;
	}

	public List<Pedido> listarPedidosVendaGeral() {
		EntityManager entityManager = FactoryJPA.getEntityManagerFactory().createEntityManager();
		List<Pedido> pedidos;
		try {
			String jpql = "SELECT p FROM Pedido p WHERE p.codPedido IN (SELECT i.cod.codPedido FROM ItemDoPedido i WHERE i.statusDoItem LIKE('%PRODUZIDO%')) AND codCliente=1";
			entityManager.getTransaction().begin();
			pedidos = entityManager.createQuery(jpql, Pedido.class).getResultList();
		} catch (EntityExistsException | TransactionalException e) {
			pedidos = null;
			FactoryJPA.shutdown();
		}
		return pedidos;
	}
}