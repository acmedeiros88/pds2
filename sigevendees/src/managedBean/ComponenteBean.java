package managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import dao.ComponenteDao;
import entity.Componente;

@ManagedBean
@SessionScoped
public class ComponenteBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Componente componente = new Componente();
	private List<Componente> componentes;
	private String mensagem;
	private String foiCadastrado;

	@Inject
	private ComponenteDao dao = new ComponenteDao();

	public void salvarComponente() {
		FacesContext context = FacesContext.getCurrentInstance();
		setMensagem(componente.getDescricao());
		setFoiCadastrado(componente.getTipoElemento());
		if (dao.salvar(componente)) {
			componente = new Componente();
			context.addMessage(null,
					new FacesMessage("Sucesso", "cadastrado " + getFoiCadastrado() + " " + getMensagem()));
		} else {
			context.addMessage(null, new FacesMessage("Erro",
					"Não foi possivel realizar o cadastro " + getFoiCadastrado() + " " + getMensagem()));
		}
	}

	public Componente getComponente() {
		return componente;
	}

	public void setComponente(Componente componente) {
		this.componente = componente;
	}

	public List<Componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(List<Componente> componentes) {
		this.componentes = componentes;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getFoiCadastrado() {
		return foiCadastrado;
	}

	public void setFoiCadastrado(String foiCadastrado) {
		this.foiCadastrado = foiCadastrado;
	}
}
