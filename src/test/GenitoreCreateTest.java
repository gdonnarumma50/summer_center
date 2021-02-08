package test;

import java.io.IOException;
import java.util.Date;

import javax.persistence.PersistenceException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entity.Genitore;
import model.dao.*;

/**
 * Servlet implementation class GenitoreCreateTest
 */
@WebServlet("/GenitoreCreateTest")
public class GenitoreCreateTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenitoreCreateTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtenteManage utenteManage = new UtenteManageDS();
		try {
			Genitore g = new Genitore();
			g.setCodiceFiscale("PROVA3");
			g.setNome("Prova");
			g.setCognome("Prova2");
			g.setGenere('M');
			g.setDataNascita(new Date(1999,04,05));
			g.setEmail("gert");
			g.setPassword("test");
			
			utenteManage.save(g);
		} catch(PersistenceException e) {
			System.out.println("errore");
		}
		response.sendError(200);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
