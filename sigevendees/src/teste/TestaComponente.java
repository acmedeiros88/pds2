package teste;

import dao.ComponenteDao;
import entity.Componente;

public class TestaComponente {
	public static void main(String[] args) {
		Componente c = new Componente("testeComponente","ingrediente","und");
		
		ComponenteDao dao = new ComponenteDao();
		
		dao.salvar(c);
	}
}
