package dao;

import java.util.List;

import entity.Cliente;

public class ClienteDao {
	public boolean salvar(Cliente cliente) {
		if(GenericDao.buscarPorId(Cliente.class,cliente.getNumTelefone())==null) {
			return GenericDao.salvar(cliente);
		}
		return GenericDao.atualizar(cliente);
	}

	public Cliente buscarPornumTelefone(int numTelefone) {
		return (Cliente) GenericDao.buscarPorId(Cliente.class,numTelefone);
	}

	public boolean deletarCliente(int numTelefone) {
		return GenericDao.deletar(Cliente.class, numTelefone);
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> getListaClientes(){
		return (List<Cliente>) GenericDao.listarTodos(Cliente.class);
	}
}
