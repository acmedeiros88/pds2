package dao;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.transaction.TransactionalException;

import entity.ItemDoPedido;
import entity.Venda;
import factoryConnection.FactoryJPA;

public class VendaDao {
	public boolean salvar(Venda venda) {
		return GenericDao.salvar(venda);
	}

	public boolean atualizarItem(ItemDoPedido item) {
		boolean resultado = true;
		EntityManager entityManager = FactoryJPA.getEntityManagerFactory().createEntityManager();
		try {
			String jpql = "UPDATE ItemDoPedido item SET item.qtdVendida = :qtdVendida, item.statusDoItem = :statusDoItem WHERE item.cod = :cod";
			entityManager.getTransaction().begin();
			entityManager.createQuery(jpql).setParameter("qtdVendida", item.getQtdVendida())
					.setParameter("statusDoItem", item.getStatusDoItem()).setParameter("cod", item.getCod())
					.executeUpdate();
			entityManager.getTransaction().commit();
		} catch (EntityExistsException | TransactionalException e) {
			resultado = false;
			FactoryJPA.shutdown();
		}
		return resultado;
	}
}
