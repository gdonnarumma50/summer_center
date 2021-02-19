package control.gestioneIscrizione;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import model.dao.IscrizioneManage;
import model.dao.IscrizioneManageDS;
import model.entity.Genitore;
import model.entity.Iscrizione;
import model.entity.Utente;



/**
 * Servlet implementation class SingolaIscrizioneControl
 */
@WebServlet("/dettagli_iscrizione")
public class SingolaIscrizioneControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SingolaIscrizioneControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utente u = (Utente) request.getSession(false).getAttribute("utente");
		if(u==null) {
			response.sendError(401, "Autenticazione non effettuata!");
			return;
		} 
		
		if(!(u instanceof Genitore)) {
			response.sendError(403, "Non sei autorizzato!");
			return;
		}
		
		String idIscrizione = request.getParameter("idIscrizione");
		
		if (idIscrizione != null) {
			IscrizioneManage iscrizioneManage = new IscrizioneManageDS();
			Iscrizione iscrizione = iscrizioneManage.getIscrizione(Integer.parseInt( idIscrizione ));
				
			request.setAttribute("iscrizione", iscrizione);
		}
		
		
		/**
		 * Dispatch verso la lista delle iscrizioni
		 */
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/dettagli_iscrizione.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
