package managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.PrimeFaces;

import dao.ComponenteDao;
import entity.Componente;

@ManagedBean
@SessionScoped
public class ComponenteBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Componente componente = new Componente();
	private List<Componente> componentes;

	@Inject
	private ComponenteDao dao = new ComponenteDao();

	public void salvarComponente() {
		if (dao.salvar(componente)) {
			componente = new Componente();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!",
					"Cadastro realizado com sucesso!");
			PrimeFaces.current().dialog().showMessageDynamic(message);
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Erro no cadastro!"));
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
}
