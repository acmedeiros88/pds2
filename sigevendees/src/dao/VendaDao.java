package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.transaction.TransactionalException;
import entity.Venda;
import factoryConnection.FactoryJPA;

public class VendaDao {

	public boolean salvar(Venda venda) {
		return GenericDao.salvar(venda);
	}

	/*
	 * @SuppressWarnings("unchecked") public List<Venda> listarVendas() { return
	 * (List<Venda>) GenericDao.listarTodos(Venda.class); }
	 */
	public List<Venda> listarVendasPorPeriodo(Date inicio, Date fim) {
		EntityManager entityManager = FactoryJPA.getEntityManagerFactory().createEntityManager();
		List<Venda> vendas;
		try {
			String jpql = "SELECT v FROM Venda v WHERE date(v.dataRealizada) BETWEEN  :inicio AND :fim";
			entityManager.getTransaction().begin();
			vendas = entityManager.createQuery(jpql, Venda.class).setParameter("inicio", inicio)
					.setParameter("fim", fim).getResultList();
		} catch (EntityExistsException | TransactionalException e) {
			vendas = null;
			FactoryJPA.shutdown();
		}
		return vendas;
	}

	public List<Venda> listarVendasPorCliente(Date inicio, Date fim, int cliente) {
		EntityManager entityManager = FactoryJPA.getEntityManagerFactory().createEntityManager();
		List<Venda> vendas;
		try {
			String jpql = "SELECT v FROM Venda v WHERE (date(v.dataRealizada) BETWEEN :inicio AND :fim) AND v.itensVenda IN"
					+ "(SELECT p.codPedido FROM Pedido p WHERE codCliente=:cliente)";
			entityManager.getTransaction().begin();
			vendas = entityManager.createQuery(jpql, Venda.class).setParameter("inicio", inicio)
					.setParameter("fim", fim).setParameter("cliente", cliente).getResultList();
		} catch (EntityExistsException | TransactionalException e) {
			vendas = null;
			FactoryJPA.shutdown();
		}
		return vendas;
	}

	public List<Venda> listarVendasPorProduto(Date inicio, Date fim, int produto) {
		EntityManager entityManager = FactoryJPA.getEntityManagerFactory().createEntityManager();
		List<Venda> vendas;
		try {
			String jpql = "SELECT v FROM Venda v WHERE (date(v.dataRealizada) BETWEEN :inicio AND :fim) AND v.itensVenda IN"
					+ "(SELECT i.cod.codPedido FROM ItemDoPedido i WHERE i.cod.codProduto=:produto)";
			entityManager.getTransaction().begin();
			vendas = entityManager.createQuery(jpql, Venda.class).setParameter("inicio", inicio)
					.setParameter("fim", fim).setParameter("produto", produto).getResultList();
		} catch (EntityExistsException | TransactionalException e) {
			vendas = null;
			FactoryJPA.shutdown();
		}
		return vendas;
	}
}
