package managedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import dao.ComponenteDao;
import dao.ProdutoDao;
import entity.Componente;
import entity.Elemento;
import entity.Produto;

@ManagedBean
@SessionScoped
public class GerenciaEstoqueBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Elemento elemento = new Elemento();

	private Componente componente = new Componente();
	
	private Componente componenteDoProduto = new Componente();;
	
	private float estoqueMinimo;
	private List<Componente> listaDeComponente;

	private Produto produto = new Produto();
	private String foiCadastrado;
	private String mensagem;
	/*
	 * Variável para renderizar os inputs necessário para o cadastro de componente e
	 * ou produto;
	 */
	private boolean tipoDoCadastro;

	@Inject
	private ComponenteDao daoComponente = new ComponenteDao();
	@Inject
	private ProdutoDao daoProduto = new ProdutoDao();

	public GerenciaEstoqueBean() {
		this.tipoDoCadastro = false;
	}

	@PostConstruct
	public void init() {
		this.listaDeComponente = daoComponente.listaComponente();
	}

	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		setMensagem(elemento.getDescricao());
		setFoiCadastrado(elemento.getTipoElemento());
		if (elemento.getTipoElemento().equals("ingrediente") || elemento.getTipoElemento().equals("embalagem")) {
			componente = new Componente(elemento.getDescricao(), elemento.getTipoElemento(), elemento.getTipoUnitario(),
					getEstoqueMinimo());
			if (daoComponente.salvar(componente)) {
				elemento = new Elemento();
				init();
				context.addMessage(null,
						new FacesMessage("Sucesso", "cadastrado " + getFoiCadastrado() + " " + getMensagem()));

			} else {
				context.addMessage(null, new FacesMessage("Erro",
						"Não foi possivel realizar o cadastro " + getFoiCadastrado() + " " + getMensagem()));
			}
		} else {
			produto = new Produto(elemento.getDescricao(), elemento.getTipoElemento(), "und", elemento.getValor());
			if (daoProduto.salvar(produto)) {
				elemento = new Elemento();
				context.addMessage(null,
						new FacesMessage("Sucesso", "cadastrado " + getFoiCadastrado() + " " + getMensagem()));

			} else {
				context.addMessage(null, new FacesMessage("Erro",
						"Não foi possivel realizar o cadastro " + getFoiCadastrado() + " " + getMensagem()));
			}
		}
	}

	// Método chamado no Ajax do selectOneRadio(tipoCadastro) ao selecionar o tipo
	// de cadastro
	// (bolo, salgado,ingrediente,embalagem) a ser realizado;
	public void inputsCadastro() {
		if (elemento.getTipoElemento().equals("bolo") || elemento.getTipoElemento().equals("salgado")) {
			setTipoCadastro(true);
		} else {
			setTipoCadastro(false);
		}
	}
	public boolean isTipoCadastro() {
		return tipoDoCadastro;
	}

	public void setTipoCadastro(boolean tipoCadastro) {
		this.tipoDoCadastro = tipoCadastro;
	}

	public Elemento getElemento() {
		return elemento;
	}

	public void setElemento(Elemento elemento) {
		this.elemento = elemento;
	}

	public Componente getComponente() {
		return componente;
	}

	public void setComponente(Componente componente) {
		this.componente = componente;
	}

	public float getEstoqueMinimo() {
		return estoqueMinimo;
	}

	public void setEstoqueMinimo(float estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	public List<Componente> getListaDeComponente() {
		return listaDeComponente;
	}

	public void setListaDeComponente(List<Componente> listaDeComponente) {
		this.listaDeComponente = listaDeComponente;
	}
	
	public Componente getComponenteDoProduto() {
		return componenteDoProduto;
	}

	public void setComponenteDoProduto(Componente componenteDoProduto) {
		this.componenteDoProduto = componenteDoProduto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String getFoiCadastrado() {
		return foiCadastrado;
	}

	public void setFoiCadastrado(String foiCadastrado) {
		this.foiCadastrado = foiCadastrado;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
