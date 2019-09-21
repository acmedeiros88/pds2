package managedBean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import dao.ClienteDao;
import entity.Cliente;

@ManagedBean
@SessionScoped
public class ClienteBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Cliente cliente;

	// Variável que recebera o cliente retornado da busca no BD;
	protected Cliente clienteRetornado;

	FacesContext context;

	@Inject
	private ClienteDao dao;

	@PostConstruct
	public void init() {
		this.cliente = new Cliente();
		this.dao = new ClienteDao();
	}

	public void salvar() {
		this.context = FacesContext.getCurrentInstance();
		if (dao.salvar(this.cliente)) {
			this.cliente = new Cliente();
			/*
			 * verifica se o cliente já possui cadastro, se não possui cadastro e um novo
			 * cliente a ser cadastrado, se possui cadastro e um cliente a fazer atualização
			 * de cadastro;
			 */
			if (clienteRetornado == null) {
				context.addMessage(null, new FacesMessage("Sucesso", "Cliente cadastrado"));
			} else {
				context.addMessage(null, new FacesMessage("Sucesso", "Cadastro atualizado"));
			}

		} else {
			context.addMessage(null, new FacesMessage("Erro", "Não foi possivel realizar o cadastro"));
		}
	}

	/*
	 * quando o input id="telefoneCliente perde o foco faz a busca no BD do número
	 * de telefone digitado no input;
	 */
	public void buscarCliente() {
		this.context = FacesContext.getCurrentInstance();
		clienteRetornado = dao.buscarPornumTelefone(cliente.getNumTelefone());
		if (clienteRetornado != null) {
			this.cliente.setNumTelefone(this.cliente.getNumTelefone());
			this.cliente.setNomeCliente(clienteRetornado.getNomeCliente());
			this.cliente.setEstabelecimentoCliente(clienteRetornado.getEstabelecimentoCliente());
			this.cliente.setObservacaoCliente(clienteRetornado.getObservacaoCliente());
		} else {
			this.cliente.setNomeCliente(null);
			this.cliente.setEstabelecimentoCliente(null);
			this.cliente.setObservacaoCliente(null);
			context.addMessage(null, new FacesMessage("Aviso", "Cliente não possui cadastro"));
		}
	}

	public void excluirCliente() {
		this.context = FacesContext.getCurrentInstance();
		if (dao.deletarCliente(cliente.getNumTelefone())) {
			this.cliente = new Cliente();
			context.addMessage(null, new FacesMessage("Sucesso", "Cadastro do cliente excluido"));
		} else {

			context.addMessage(null, new FacesMessage("Erro", "Não foi possivel excluir o cadastro do cliente"));
		}
	}

	/*
	 * Método utilizado no commandButton id="cancelarAcaoCliente", se o comerciante
	 * desistir de realizar o cadastro do cliente e já ter preenchido os inputs,
	 * assim quando clicar no botão CANCELAR limpas os inputs da tela;
	 */
	public void resetInputs() {
		this.cliente.setNumTelefone(0);
		this.cliente.setNomeCliente(null);
		this.cliente.setEstabelecimentoCliente(null);
		this.cliente.setObservacaoCliente(null);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
