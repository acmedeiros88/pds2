package entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import utils.Categoria;
import utils.Unitario;

@Entity
public class Produto extends Elemento {
	
	//Codigo do produto, sera gerado pelo BD;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Override
	public void setCodigo(int codigo) {
		super.setCodigo(codigo);
	}

	// Descrição do produto(Bolo, Salgado);
	@Column(nullable = false)
	@Override
	public void setDescricao(String descricao) {
		super.setDescricao(descricao);
	}

	// Tipo do produto poderar ser Bolo ou Salgado;
	@Column(nullable = false)
	@Override
	public void setTipoElemento(Categoria tipoElemento) {
		super.setTipoElemento(tipoElemento);
	}

	// Tipo unitario do produto final no sera "unidade";
	@Column(nullable = false)
	@Override
	public void setTipoUnitario(Unitario tipoUnitario) {
		super.setTipoUnitario(tipoUnitario);
	}

	// Valor final para a venda do produto;
	@Column(nullable = false)
	@Override
	public void setValor(float valor) {
		super.setValor(valor);
	}

	// O produto é composto por varios comoponentes (ingredientes utilizados para a produção do produto(bolo, salgado));
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Componente> listaComponente;

	// Quantidade do componente que sera utilizado para compor o produto;
	@Column(nullable = false)
	private float qtdUtilComponente;

	public List<Componente> getListaComponente() {
		return listaComponente;
	}

	public void setListaComponente(List<Componente> listaComponente) {
		this.listaComponente = listaComponente;
	}

	public float getQtdUtilComponente() {
		return qtdUtilComponente;
	}

	public void setQtdUtilComponente(float qtdUtilComponente) {
		this.qtdUtilComponente = qtdUtilComponente;
	}

	@Override
	public String toString() {
		return "Produto [listaComponente=" + listaComponente + ", qtdUtilComponente=" + qtdUtilComponente
				+ ", getCodigo()=" + getCodigo() + ", getDescricao()=" + getDescricao() + ", getTipoElemento()="
				+ getTipoElemento() + ", getTipoUnitario()=" + getTipoUnitario() + ", getValor()=" + getValor()
				+ ", toString()=" + super.toString() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass()
				+ "]";
	}
}
