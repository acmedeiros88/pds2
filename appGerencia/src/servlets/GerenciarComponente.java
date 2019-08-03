package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.ComponenteDao;
import entity.Componente;

/**
 * Servlet implementation class GerenciarComponente
 */
@WebServlet("/GerenciarComponente")
public class GerenciarComponente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GerenciarComponente() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tipoComponente = request.getParameter("tipodeProduto");
		String desComponente = request.getParameter("inputDescricaoProduto");
		float estoqueMinimo = Float.parseFloat(request.getParameter("estoqueMinProduto"));
		String tipoUnitario = request.getParameter("tipoUnitario");
		String destino = null;
		String mensagem = null;
		ComponenteDao dao = new ComponenteDao();

		Componente componente = new Componente(desComponente, tipoComponente, tipoUnitario, estoqueMinimo);
		dao.salvar(componente);
		destino = "estoque.jsp";
		if (componente.getTipoComponente().equalsIgnoreCase("Ingrediente")) {
			mensagem = "Ingrediente cadastrado com sucesso";
		} else {
			mensagem = "Embalagem cadastrado com sucesso";
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
