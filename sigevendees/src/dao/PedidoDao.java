package dao;

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
}
