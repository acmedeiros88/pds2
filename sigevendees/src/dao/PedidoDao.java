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

	public List<Pedido> listarPedidos() {
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

	public List<Pedido> listarPedidosProduzir() {
		EntityManager entityManager = FactoryJPA.getEntityManagerFactory().createEntityManager();
		List<Pedido> pedidos;
		try {
			String jpql = "SELECT ped.codPedido, cli.nomeCliente, prod.descricao, item.qtdProduto FROM Produto prod "
					+ "INNER JOIN ItemDoPedido item ON(prod.codigo=item.cod.codProduto)" + "INNER JOIN "
					+ "(SELECT p FROM Pedido p WHERE p.codPedido IN (SELECT i.cod.codPedido FROM ItemDoPedido i WHERE i.statusDoItem LIKE('%PRODUZIR%'))) ped ON(item.cod.codPedido=ped.codPedido)"
					+ "INNER JOIN Cliente cli ON(cli.numTelefone=ped)";
			entityManager.getTransaction().begin();
			pedidos = entityManager.createQuery(jpql,Pedido.class).getResultList();
		} catch (EntityExistsException | TransactionalException e) {
			pedidos = null;
			FactoryJPA.shutdown();
		}
		return pedidos;
	}
}
/*
SELECT ped.codPedido, cli.nomeCliente,prod.desProduto, item.qtdProduto FROM produto prod
INNER JOIN itemdopedido item ON(prod.codProduto=item.codProduto)
INNER JOIN (SELECT * FROM pedido WHERE codPedido IN (SELECT codPedido FROM itemdopedido WHERE statusDoItem LIKE('%PRODUZIR%'))) ped ON(item.codPedido=ped.codPedido)
INNER JOIN cliente cli ON(cli.numTelefone=ped.codCliente);
*/
