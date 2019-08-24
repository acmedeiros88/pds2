package teste;

import dao.ComponenteDao;
import entity.Componente;
import entity.Elemento;

public class TestaComponente {
	public static void main(String[] args) {
		
		Elemento el = new Elemento();
		el.setDescricao("farinha de trigo");
		el.setTipoElemento("ingrediente");
		el.setTipoUnitario("g");
		
		Componente comp = new Componente(el.getDescricao(),el.getTipoElemento(),el.getTipoUnitario(),5000);
		
		ComponenteDao dao = new ComponenteDao();
		dao.salvar(comp);
	}
}
