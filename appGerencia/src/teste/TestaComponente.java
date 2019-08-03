package teste;

import dao.ComponenteDao;
import entity.Componente;

public class TestaComponente {

	public static void main(String[] args) {
		ComponenteDao dao = new ComponenteDao();

		Componente f = new Componente();
		f.setDesComponente("Pote de 250ml");
		f.setTipoUnitario("und");
		f.setTipoComponente("Embalagem");
		f.setEstoqueMinimo(100);
		dao.salvar(f);
	}
}
