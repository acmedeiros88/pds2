package dao;

import java.util.List;

import entity.Componente;

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
}
