package managedBean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import dao.ComponenteDao;
import entity.Componente;
import entity.Elemento;
import entity.Produto;

@ManagedBean
@SessionScoped
public class GerenciaEstoqueBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Elemento elemento = new Elemento();
	private Componente componente;
	private Produto produto;
	private String foiCadastrado;
	private String mensagem;
	/*
	 * variavel para renderizar os inputs necessario para o cadastro de componentes
	 * e ou produto;
	 */
	private boolean tipoCadastro;

	@Inject
	private ComponenteDao dao = new ComponenteDao();

	public GerenciaEstoqueBean() {
		this.tipoCadastro = false;
	}

	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		setMensagem(elemento.getDescricao());
		setFoiCadastrado(elemento.getTipoElemento());
		if (elemento.getTipoElemento().equals("ingrediente") || elemento.getTipoElemento().equals("embalagem")) {
			componente = new Componente(elemento.getDescricao(), elemento.getTipoElemento(),
					elemento.getTipoUnitario());
			if (dao.salvar(componente)) {
				context.addMessage(null,
						new FacesMessage("Sucesso", "cadastrado " + getFoiCadastrado() + " " + getMensagem()));
			} else {
				context.addMessage(null, new FacesMessage("Erro",
						"Nao foi possivel realizar o cadastro " + getFoiCadastrado() + " " + getMensagem()));
			}
		}
	}

	// metodo chamado no ajax do selectOneRadio(tipoCadastro) ao selecionar o tipo
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
		return tipoCadastro;
	}

	public void setTipoCadastro(boolean tipoCadastro) {
		this.tipoCadastro = tipoCadastro;
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
