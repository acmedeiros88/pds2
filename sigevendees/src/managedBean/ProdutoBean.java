package managedBean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entity.Produto;

@ManagedBean
@SessionScoped
public class ProdutoBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Produto produto = new Produto();

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}

