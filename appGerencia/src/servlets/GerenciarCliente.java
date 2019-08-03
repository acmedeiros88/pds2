package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;
import entity.Cliente;

/**
 * Servlet implementation class GerenciarCliente
 */
@WebServlet("/GerenciarCliente")
public class GerenciarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GerenciarCliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int telefoneCliente = Integer.parseInt(request.getParameter("telefoneCliente"));
		String nomeCliente = request.getParameter("nomeCliente");
		String estabelecimentoCliente = request.getParameter("estabelecimentoCliente");
		String observacaoCliente = request.getParameter("observacaoCliente");
		String acao = request.getParameter("acao");
		String destino = null;
		String mensagem = null;
		ClienteDao dao = new ClienteDao();
		Cliente cliente = new Cliente();
		if(acao==null) {
			acao="Buscar";
		}
		switch (acao) {
		case "Salvar":
			cliente.setNumTelefone(telefoneCliente);
			cliente.setNomeCliente(nomeCliente);
			cliente.setEstabelecimentoCliente(estabelecimentoCliente);
			cliente.setObservacaoCliente(observacaoCliente);
			dao.salvar(cliente);
			destino = "cliente.jsp";
			mensagem = "Cliente cadastrado/Atualizado com sucesso";
			break;
		case "Excluir":
			dao.deletarCliente(telefoneCliente);
			mensagem = "Cliente removido com sucesso";
			destino = "cliente.jsp";
			break;
		default:
			cliente=dao.buscarPornumTelefone(telefoneCliente);
			request.setAttribute("cliente", cliente);
			destino="cliente.jsp";
		}
		if (destino != null) {
			request.setAttribute("mensagem", mensagem);
			request.getRequestDispatcher(destino).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
