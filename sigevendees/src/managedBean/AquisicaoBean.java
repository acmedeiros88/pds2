package managedBean;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import dao.ComponenteDao;
import entity.Aquisicao;
import entity.Componente;

@ManagedBean
@SessionScoped
public class AquisicaoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Aquisicao aquisicao = new Aquisicao();

	private Componente componenteAdquirido = new Componente();

	private int codComponente;

	@Inject
	private ComponenteDao dao = new ComponenteDao();

	@PostConstruct
	public void init() {

	}

	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();

		this.aquisicao.setComponenteAdquirido(dao.buscarPorCod(getCodComponente()));
		this.componenteAdquirido = this.aquisicao.getComponenteAdquirido();
		this.componenteAdquirido
				.setEstoqueAtual(this.componenteAdquirido.getEstoqueAtual() + this.aquisicao.getQtdAdquirida());
		this.componenteAdquirido.setValor(this.aquisicao.getCustoDaAquisicao());
		Date data = new Date();
		this.aquisicao.setDataDaAquisicao(data);

		if (dao.salvarAquisicaoDeComponente(this.aquisicao)) {

			dao.atualizarEstoqueComponente(this.componenteAdquirido);
			this.componenteAdquirido = new Componente();
			this.aquisicao = new Aquisicao();

			context.addMessage(null, new FacesMessage("Sucesso", "Estoque do componente atualizado"));
		} else {
			context.addMessage(null, new FacesMessage("Erro", "Não foi possivel realizar o registro da aquisição"));
		}
	}

	public Aquisicao getAquisicao() {
		return aquisicao;
	}

	public void setAquisicao(Aquisicao aquisicao) {
		this.aquisicao = aquisicao;
	}

	public int getCodComponente() {
		return codComponente;
	}

	public void setCodComponente(int codComponente) {
		this.codComponente = codComponente;
	}

	public Componente getComponenteAdquirido() {
		return componenteAdquirido;
	}

	public void setComponenteAdquirido(Componente componenteAdquirido) {
		this.componenteAdquirido = componenteAdquirido;
	}

}
