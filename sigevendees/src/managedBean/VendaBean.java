package managedBean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utils.OpcoesDePagamento;

@ManagedBean
@SessionScoped
public class VendaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	
	// Retorna todas as opções de forma de pagamento que podem ser utilizado em uma venda;
	public OpcoesDePagamento[] getOpcoesPagamento() {
		return OpcoesDePagamento.values();
	}
// A baixo estão todos os métodos GET e SET dos atributos da classe;
}
