package teste;

import java.util.Date;
import dao.ComponenteDao;
import entity.Aquisicao;
import entity.Componente;

public class TestaAquisicao {
	public static void main(String[] args) {
		
		ComponenteDao dao = new ComponenteDao();
		Componente c = new Componente();
		
		//Busca o componente Farinha de Trigo no BD;
		c=dao.buscarPorCod(5);
		
		//Pega a data atual do sistema que esta sendo feito o registro da aquisição;
		Date data = new Date();
		//SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		//Cria um objeto de aquisição;
		Aquisicao aq = new Aquisicao(c,50,2.99f,data);
		
		//Salva as informações no BD;
		//dao.salvarAquisicaoDeComponente(aq);
		
		float x = c.getEstoqueAtual();
		float y = x+aq.getQtdAdquirida();
		c.setEstoqueAtual(y);
		c.setValor(aq.getCustoDaAquisicao());
		dao.atualizarEstoque(c);
	}
}
