package pratProg_A04;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pratProg_A04.Pais;
import pratProg_A04.ServicePais;

/**
 * Servlet implementation class ManterClienteController
 */
@WebServlet("/ManterPais.do")
public class ManterPaisController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		long pop = Long.parseLong(request.getParameter("populacao"));
		double area = Double.parseDouble(request.getParameter("area"));		
		String acao = request.getParameter("acao");
		
		//instanciar o javabean
		Pais pais = new Pais();
		pais.setNome(nome);
		pais.setPopulacao(pop);
		pais.setArea(area);
		
		//instanciar o service
		ServicePais cp = new ServicePais();
		cp.criar(pais);
		pais = cp.carregar(pais.getId());
		
		

		RequestDispatcher dispatcher = null;
		switch(acao){
		case "Incluir":
			cp.criar(pais);
			
			//manda parametro para o JSP via request
			request.setAttribute("pais", pais);
			dispatcher = request.getRequestDispatcher("Pais.jsp");
			break;
		case "Listar":
			ArrayList<Pais> paises = cp.listarTodos();
			request.setAttribute("paises", paises);
			dispatcher = request.getRequestDispatcher("ListaDePais.jsp");
		}
		
		
		//despachar para o JSP correto
		dispatcher.forward(request, response);
		
	}

}
