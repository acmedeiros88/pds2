package dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.transaction.TransactionalException;

import entity.Aquisicao;
import entity.Componente;
import factoryConnection.FactoryJPA;

public class ComponenteDao {

	public boolean salvar(Componente componente) {
		return GenericDao.salvar(componente);
	}

	public boolean atualizar(Componente componente) {
		return GenericDao.atualizar(componente);
	}

	public Componente buscarPorCod(int codComponente) {
		return (Componente) GenericDao.buscarPorId(Componente.class, codComponente);
	}

	public boolean deletarComponente(int codComponente) {
		return GenericDao.deletar(Componente.class, codComponente);
	}

	@SuppressWarnings("unchecked")
	public List<Componente> listaComponente() {
		return (List<Componente>) GenericDao.listarTodos(Componente.class);
	}

	public boolean salvarAquisicaoDeComponente(Aquisicao aquisicao) {
		return GenericDao.salvar(aquisicao);
	}

	public boolean atualizarEstoque(Componente componente) {
		EntityManager entityManager = FactoryJPA.getEntityManagerFactory().createEntityManager();
		try {
			String jpql = "UPDATE Componente SET valorDeCusto = :custo, estoqueAtual = :qtdAdquirida WHERE codComponente = :value";
			entityManager.getTransaction().begin();
			entityManager.createQuery(jpql).setParameter("qtdAdquirida", componente.getEstoqueAtual())
					.setParameter("custo", componente.getValor()).setParameter("value", componente.getCodigo()).executeUpdate();
			entityManager.getTransaction().commit();
		} catch (EntityExistsException | TransactionalException e) {
			FactoryJPA.shutdown();
			return false;
		}
		return true;
	}
}
