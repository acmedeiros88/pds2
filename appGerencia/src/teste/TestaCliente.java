package teste;

import java.util.ArrayList;
import java.util.List;

import dao.ClienteDao;
import entity.Cliente;

public class TestaCliente {

	public static void main(String[] args) {

		ClienteDao dao = new ClienteDao();
		/*
		 * int tel = 123456789; String nome = "Cliente c1"; String estabelecimento =
		 * "Estabelecimento do cliente c1"; String obs =
		 * "Testando salvar cliente no BD"; Cliente c1 = new Cliente(tel, nome,
		 * estabelecimento, obs);
		 */
		/*
		  int tel02 = 666666666; String nome02 = "Cliente c4"; String estabelecimento02
		  = "Estabelecimento do cliente c4"; String obs02 =
		  "Testando salvar cliente 04 no BD"; Cliente c2 = new Cliente(tel02, nome02,
		  estabelecimento02, obs02);
		  
		 dao.salvar(c2);
		 */

		/*
		 * Cliente update = new Cliente(); update = dao.buscarPornumTelefone(101112131);
		 * update.setNomeCliente("Cliente Atualizado");
		 * update.setObservacaoCliente("Testando update Cliente");
		 * 
		 * dao.atualizar(update);
		 */

		// dao.deletarCliente(101112131);
		
		/*Cliente c = new Cliente();
		c= dao.buscarPornumTelefone(123456789);
		System.out.println(c);*/
		
		/*
		List<Cliente> lista = dao.getListaClientes();
		for(Cliente l : lista) {
			System.out.println(l.getNomeCliente());
		}
		*/
	}

}
