package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import utils.Categoria;
import utils.Unitario;

@Entity
public class Componente extends Elemento {
	
	//Codigo do componente, sera gerado pelo BD;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Override
	public void setCodigo(int codigo) {
		super.setCodigo(codigo);
	}
	
	//Descrição do componente (ingrediente, embalagem);
	@Column(nullable = false)
	@Override
	public void setDescricao(String descricao) {
		super.setDescricao(descricao);
	}
	
	//Tipo do componente, no caso poderar ser (ingrediente, embalagem);
	@Column(nullable = false)
	@Override
	public void setTipoElemento(Categoria tipoElemento) {
		super.setTipoElemento(tipoElemento);
	}
	
	//Tipo unitatio do componente, no caso poderar ser (g='gramas', ml='mililitros', und='unidade');
	@Column(nullable = false)
	@Override
	public void setTipoUnitario(Unitario tipoUnitario) {
		super.setTipoUnitario(tipoUnitario);
	}
	
	//Valor de custo da aquisição do componetente;
	@Column(nullable = true)
	@Override
	public void setValor(float valor) {
		super.setValor(valor);
	}
	
	//Valor da quantidade do estoque minimo que o cliente precisa ou gostaria de ter;
	@Column(nullable = false)
	private float estoqueMinimo;
	
	//Valor da quantidade dos componentes disponivel em estoque;
	@Column(nullable = true)
	private float estoqueAtual;

	public Componente() {

	}

	public Componente(int codigo, String descricao, Categoria tipoElemento, Unitario tipoUnitario, float valor) {
		super(codigo, descricao, tipoElemento, tipoUnitario, valor);
	}

	public float getEstoqueMinimo() {
		return estoqueMinimo;
	}

	public void setEstoqueMinimo(float estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	public float getEstoqueAtual() {
		return estoqueAtual;
	}

	public void setEstoqueAtual(float estoqueAtual) {
		this.estoqueAtual = estoqueAtual;
	}

	@Override
	public String toString() {
		return "Componente [estoqueMinimo=" + estoqueMinimo + ", estoqueAtual=" + estoqueAtual + ", getCodigo()="
				+ getCodigo() + ", getDescricao()=" + getDescricao() + ", getTipoElemento()=" + getTipoElemento()
				+ ", getTipoUnitario()=" + getTipoUnitario() + ", getValor()=" + getValor() + ", toString()="
				+ super.toString() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + "]";
	}

}
