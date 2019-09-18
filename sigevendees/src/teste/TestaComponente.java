package teste;

import dao.ComponenteDao;
import entity.Componente;
import entity.Elemento;

public class TestaComponente {
	public static void main(String[] args) {
		
		//Testando inserir novo cadastro de componente no BD;
		
		// Cria um elemento com os dados vindo do formulario;
		Elemento el = new Elemento();
		el.setDescricao("farinha de trigo");
		el.setTipoElemento("ingrediente");
		el.setTipoUnitario("g");
		
		// Cria um objeto do tipo Componente com os atributos do elemento setados no request do formulario;
		Componente comp = new Componente(el.getDescricao(),el.getTipoElemento(),el.getTipoUnitario(),5000);
		
		// Salva o objeto componente no BD;
		ComponenteDao dao = new ComponenteDao();
		dao.salvar(comp);
	}
}
