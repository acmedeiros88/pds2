package dao;

import java.util.List;

public interface InterfaceDao {
	
	public boolean salvar(Object objeto);
	
	public boolean atualizar(Object objeto);
	
	public boolean deletar(Class<?> classe, int id);
	
	public Object buscarPorId(Class<?> classe, int id);
	
	public List<?> listarTodos(Class<?> classe);
}
