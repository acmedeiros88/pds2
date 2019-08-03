package dao;

import java.util.List;

import entity.Componente;

public class ComponenteDao {
	GenericDao daoGenerico = new GenericDao();

	public boolean salvar(Componente componente) {
		return daoGenerico.salvar(componente);
	}

	public boolean atualizar(Componente componente) {
		return daoGenerico.atualizar(componente);
	}

	public Componente buscarPorCodComponente(int codComponente) {
		return (Componente) daoGenerico.buscarPorId(Componente.class, codComponente);
	}

	public boolean deletarComponente(int codComponente) {
		return daoGenerico.deletar(Componente.class, codComponente);
	}

	@SuppressWarnings("unchecked")
	public List<Componente> getListaComponentes() {
		return (List<Componente>) daoGenerico.listarTodos(Componente.class);
	}
}
