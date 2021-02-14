package control.gestioneIscrizione;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BambinoManage;
import model.dao.BambinoManageDS;
import model.dao.IscrizioneManage;
import model.dao.IscrizioneManageDS;
import model.entity.Bambino;
import model.entity.Genitore;
import model.entity.Iscrizione;
import model.entity.Utente;
import model.dao.SettimanaManage;
import model.dao.SettimanaManageDS;
import model.dao.UtenteManage;
import model.dao.UtenteManageDS;
import model.entity.Settimana;

/**
 * Servlet implementation class IscrizioneControl
 */
@WebServlet("/iscrizione")
public class IscrizioneControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IscrizioneControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utente u = (Utente) request.getSession(false).getAttribute("utente");
		if(u==null) {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return;
		} 
		
		if(!(u instanceof Genitore)) {
			//TODO: page forbidden
			return;
		}
		
		BambinoManage bambinoManage = new BambinoManageDS();
		List<Bambino> bambini = bambinoManage.getBambini(u.getCodiceFiscale());
		request.setAttribute("bambini", bambini);
		
		SettimanaManage settimanaManage = new SettimanaManageDS();
		List<Settimana> settimane = settimanaManage.getSettimaneDisponibili();
		
		List<Settimana> maggio = new ArrayList<Settimana>();
		List<Settimana> giugno = new ArrayList<Settimana>();
		List<Settimana> luglio = new ArrayList<Settimana>();
		List<Settimana> agosto = new ArrayList<Settimana>();
		List<Settimana> settembre = new ArrayList<Settimana>();
		
		for(Settimana s: settimane) {
			int mese = s.getDataInizio().getMonth();
			
			if(mese == 4) {
				maggio.add(s);
				
			} else if(mese == 5) {
				giugno.add(s);
				
			} else if(mese == 6) {
				luglio.add(s);
				
			} else if(mese == 7) {
				agosto.add(s);
				
			} else if(mese == 8) {
				settembre.add(s);
				
			}
		}
		
		request.setAttribute("maggio", maggio);
		request.setAttribute("giugno", giugno);
		request.setAttribute("luglio", luglio);
		request.setAttribute("agosto", agosto);
		request.setAttribute("settembre", settembre);
		

		/**
		 * Dispatch verso il form di inserimento
		 */
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/iscrizione.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codiceFiscale = (String) request.getParameter("codiceFiscale");
		String nome = (String) request.getParameter("nome");
		String cognome = (String) request.getParameter("cognome");
		String dataNascita = (String) request.getParameter("dataNascita");
		String luogoNascita = (String) request.getParameter("luogoNascita");
		char genere = request.getParameter("genere").charAt(0);
		boolean disabilita = Boolean.parseBoolean(request.getParameter("disabilita"));
		boolean esigenzeAlimentari = Boolean.parseBoolean(request.getParameter("esigenzeAlimentari"));
		boolean ausilioMaterialeGalleggiante = Boolean.parseBoolean(request.getParameter("ausilioMaterialeGalleggiante"));
		String infoEsigenzeAlimentari = (String) request.getParameter("infoEsigenzeAlimentari");
		String farmaci = (String) request.getParameter("farmaci");
		String infoAllergie = (String) request.getParameter("infoAllergie");
		String documentoIdentita = (String) request.getParameter("documentoIdentita");
		String certificatoMedico = (String) request.getParameter("certificatoMedico");
		boolean servizioSportivo = Boolean.parseBoolean(request.getParameter("servizioSportivo"));
		String tagliaIndumenti = (String) request.getParameter("tagliaIndumenti");
		String tipoSoggiorno = (String) request.getParameter("tipoSoggiorno");
		String periodoSoggiorno = (String) request.getParameter("periodoSoggiorno");
		String[] settimane = request.getParameterValues("settimane");
		
		String[] dataN = dataNascita.split("-", 3);
		
		for(String s:settimane) {
			System.out.println(s);
		}
		
		Genitore genitore = (Genitore) request.getSession(false).getAttribute("utente");
		
		if(genitore==null) {
			//TODO: page 403 forbidden
			return;
		}
	
		
		BambinoManage bambinoManage = new BambinoManageDS();
		Bambino bambino = bambinoManage.getBambino(codiceFiscale);
		UtenteManage utenteManage = new UtenteManageDS();
		
		Bambino newBambino = new Bambino();
		try {
			if(bambino!=null) {
				bambino.setDisabilita(disabilita);
				bambino.setEsigenzeAlimentari(esigenzeAlimentari);
				bambino.setAusilioMaterialeGalleggiante(ausilioMaterialeGalleggiante);
				bambino.setInfoEsigenzeAlimentari(infoEsigenzeAlimentari);
				bambino.setFarmaci(farmaci);
				bambino.setInfoAllergie(infoAllergie);
				bambino.setDocumentoIdentita("./");
				bambino.setCertificatoMedico("./");
				bambino.setTagliaIndumenti(tagliaIndumenti);
				bambinoManage.update(bambino);
			} else {
				newBambino.setCodiceFiscale(codiceFiscale);
				newBambino.setNome(nome);
				newBambino.setCognome(cognome);
				//new Date(Integer.parseInt(dataN[0]), Integer.parseInt(dataN[1]), Integer.parseInt(dataN[2]))
				newBambino.setDataNascita(java.sql.Date.valueOf(dataNascita));
				newBambino.setLuogoNascita(luogoNascita);
				newBambino.setGenere(genere);
				newBambino.setDisabilita(disabilita);
				newBambino.setEsigenzeAlimentari(esigenzeAlimentari);
				newBambino.setAusilioMaterialeGalleggiante(ausilioMaterialeGalleggiante);
				newBambino.setInfoEsigenzeAlimentari(infoEsigenzeAlimentari);
				newBambino.setFarmaci(farmaci);
				newBambino.setInfoAllergie(infoAllergie);
				newBambino.setDocumentoIdentita("./");
				newBambino.setCertificatoMedico("./");
				newBambino.setTagliaIndumenti(tagliaIndumenti);
				newBambino.setGenitore(genitore);
				bambinoManage.save(newBambino);
			}
			
			//Compongo le settimane dati gli id dalla richiesta
			SettimanaManage settimanaManage = new SettimanaManageDS();
			List<Settimana> listaSettimane = new ArrayList<Settimana>();
			for(String id:settimane) {
				listaSettimane.add(settimanaManage.getSettimana(Integer.parseInt(id)));
			}
			
			float prezzo = this.calcolaPrezzo(listaSettimane.size(), tipoSoggiorno, disabilita, servizioSportivo);
			
			IscrizioneManage iscrizioneManage = new IscrizioneManageDS();
			Iscrizione iscrizione = new Iscrizione();
			iscrizione.setPrezzo(prezzo);
			iscrizione.setTipoSoggiorno(tipoSoggiorno);
			iscrizione.setRichiestaDisdetta(false);
			iscrizione.setRimborsoDisdetta(0);
			iscrizione.setDataIscrizione(new Date());
			iscrizione.setServizioSportivo(servizioSportivo);
			iscrizione.setQrCode("QRCODE");
			if(bambino!=null) {
				iscrizione.setBambino(bambino);
			} else {
				iscrizione.setBambino(newBambino);
			}
			iscrizione.setGenitore(genitore);
			iscrizione.setSettimane(listaSettimane);
			
			iscrizioneManage.save(iscrizione);
		} catch(PersistenceException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	private float calcolaPrezzo(int settimane, String tipoSoggiorno, boolean disabilita, boolean servizioSportivo) {
		float prezzo = 0;
		
		if(tipoSoggiorno.equalsIgnoreCase("PART-TIME")) {
			prezzo += PART_TIME*settimane;
		} else {
			prezzo += FULL_TIME*settimane;
		}
		
		if(disabilita) {
			prezzo += DISABILITA*settimane;
		}
		
		if(servizioSportivo) {
			prezzo += SERVIZIO_SPORTIVO;
		}
		
		return prezzo;
	}
	
	private static final float PART_TIME = 50;
	private static final float FULL_TIME = 100;
	private static final float DISABILITA = 50;
	private static final float SERVIZIO_SPORTIVO = 20;

}
