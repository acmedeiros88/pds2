package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Produto extends Elemento {
	
	//Codigo do produto, sera gerado pelo BD;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="codProduto")
	@Override
	public void setCodigo(int codigo) {
		super.setCodigo(codigo);
	}
}
