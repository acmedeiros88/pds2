package dao;

import java.util.List;

import entity.Cliente;

public class ClienteDao {

	GenericDao daoGenerico = new GenericDao();

	public boolean salvar(Cliente cliente) {
		if(daoGenerico.buscarPorId(Cliente.class,cliente.getNumTelefone())==null) {
			return daoGenerico.salvar(cliente);
		}
		return daoGenerico.atualizar(cliente);
	}

	public Cliente buscarPornumTelefone(int numTelefone) {
		return (Cliente) daoGenerico.buscarPorId(Cliente.class,numTelefone);
	}

	public boolean deletarCliente(int numTelefone) {
		return daoGenerico.deletar(Cliente.class, numTelefone);
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> getListaClientes(){
		return (List<Cliente>) daoGenerico.listarTodos(Cliente.class);
	}
	
	
}
