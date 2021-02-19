package control.gestioneAutenticazione;

import java.io.IOException;
import java.sql.SQLException;

import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

import model.dao.UtenteManage;
import model.dao.UtenteManageDS;
import model.entity.Bambino;
import model.entity.Genitore;
import model.entity.Utente;

/**
 * Servlet implementation class LoginControl
 */
@WebServlet(description = "Control per il login", urlPatterns = { "/login" })
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UtenteManage utenteManage = new UtenteManageDS();
		Utente utente = utenteManage.getUserIfExists(email, password);
	
		if(utente!=null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("utente", utente);
			Utente u = (Utente) session.getAttribute("utente");
			System.out.println(u);
			response.sendRedirect(request.getContextPath() + "/dashboard.jsp");
		} else {
			request.setAttribute("errorMessage", "Credenziali errate!");
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/");
			dispatcher.forward(request, response);
		}
		
		
	}
}
