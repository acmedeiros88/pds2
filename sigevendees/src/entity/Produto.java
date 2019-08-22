package entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Produto extends Elemento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//Codigo do produto, sera gerado pelo BD;
	@EmbeddedId
	private ComponenteProdutoPK cod;
	
	
	
}
