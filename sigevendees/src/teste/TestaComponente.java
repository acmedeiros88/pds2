package teste;

import dao.ComponenteDao;
import entity.Componente;
import entity.Elemento;

public class TestaComponente {
	public static void main(String[] args) {
		Elemento el = new Elemento();
		el.setDescricao("Teste descrição");
		el.setTipoElemento("ingrediente");
		el.setTipoUnitario("g");
		
		Componente comp = new Componente(el.getDescricao(),el.getTipoElemento(),el.getTipoUnitario());
		
		//Componente c = new Componente("testeComponente","ingrediente","und");
		
		ComponenteDao dao = new ComponenteDao();
		
		//dao.salvar(c);
		dao.salvar(comp);
	}
}
