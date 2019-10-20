package teste;

import java.util.List;

import dao.ClienteDao;
import entity.Cliente;

public class TestaCliente {

	public static void main(String[] args) {

		ClienteDao dao = new ClienteDao();
		
	/*
		//Testando inserir novo cadastro de cliente no BD;
		int tel = 123;
		String nome = "Cliente c1";
		String estabelecimento = "Estabelecimento do cliente c1";
		String obs = "Testando salvar cliente no BD";
		Cliente c1 = new Cliente(tel, nome, estabelecimento, obs);
		dao.salvar(c1);
		
		//Testando inserir mais cadastro de cliente no BD;
		int tel02 = 456;
		String nome02 = "Cliente c2";
		String estabelecimento02 = "Estabelecimento do cliente c4";
		String obs02 = "Testando salvar cliente 02 no BD";
		Cliente c2 = new Cliente(tel02, nome02, estabelecimento02, obs02);
		dao.salvar(c2);
		
		
		//Testando atualizar cadastro de cliente no BD;
		Cliente update = new Cliente();
		update = dao.buscarPornumTelefone(666666666);
		update.setNomeCliente("Cliente Atualizado");
		update.setObservacaoCliente("Testando update Cliente");

		dao.salvar(update);
		
		//Testando deletar cadastro de cliente no BD
		dao.deletarCliente(666666666);

	     //Testando buscar cadastro no BD por numero de telefone do cliente; 	
		 Cliente c = new Cliente();
		 c= dao.buscarPornumTelefone(123);
		 System.out.println(c);
		 

		 //Testando buscar todos os cadastro de cliente no BD;
		 List<Cliente> lista = dao.listarClientes();
		 for(Cliente l : lista) {
			 System.out.println(l.getNomeCliente());
		 }
	*/	 
		 // Teste da busca por nome do cliente;
		 System.out.println(dao.buscarPornome("Adriano"));
	}

}
