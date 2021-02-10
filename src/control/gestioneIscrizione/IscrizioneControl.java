package control.gestioneIscrizione;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
import model.dao.IscrioneManageDS;
import model.dao.IscrizioneManage;
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
		
		//L'ho disabilitato poichè nel db non ci sono settimane
		/*
		SettimanaManage settimanaManage = new SettimanaManageDS();
		List<Settimana> settimane = settimanaManage.getSettimaneDisponibili();
		request.setAttribute("settimane", settimane);
		*/
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/iscrizione.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codiceFiscale = (String) request.getAttribute("codiceFiscale");
		String nome = (String) request.getAttribute("nome");
		String cognome = (String) request.getAttribute("cognome");
		String dataNascita = (String) request.getAttribute("dataNascita");
		String luogoNascita = (String) request.getAttribute("luogoNascita");
		char genere = (char) request.getAttribute("genere");
		boolean disabilita = (boolean) request.getAttribute("disabilita");
		boolean esigenzeAlimentari = (boolean) request.getAttribute("esigenzeAlimentari");
		boolean ausilioMaterialeGalleggiante = (boolean) request.getAttribute("ausilioMaterialeGalleggiante");
		String infoEsigenzeAlimentari = (String) request.getAttribute("infoEsigenzeAlimentari");
		String farmaci = (String) request.getAttribute("farmaci");
		String infoAllergie = (String) request.getAttribute("infoAllergie");
		String documentoIdentita = (String) request.getAttribute("documentoIdentita");
		String certificatoMedico = (String) request.getAttribute("certificatoMedico");
		boolean servizioSportivo = (boolean) request.getAttribute("servizioSportivo");
		String tagliaIndumenti = (String) request.getAttribute("tagliaIndumenti");
		String tipoSoggiorno = (String) request.getAttribute("tipoSoggiorno");
		String periodoSoggiorno = (String) request.getAttribute("periodoSoggiorno");
		Integer[] settimane = (Integer[]) request.getAttribute("settimane");
		
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
				bambino.setDocumentoIdentita(documentoIdentita);
				bambino.setCertificatoMedico(certificatoMedico);
				bambino.setTagliaIndumenti(tagliaIndumenti);
				bambinoManage.update(bambino);
			} else {
				newBambino.setCodiceFiscale(codiceFiscale);
				newBambino.setNome(nome);
				newBambino.setCognome(cognome);
				newBambino.setDataNascita(new Date(dataNascita));
				newBambino.setLuogoNascita(luogoNascita);
				newBambino.setGenere(genere);
				newBambino.setDisabilita(disabilita);
				newBambino.setEsigenzeAlimentari(esigenzeAlimentari);
				newBambino.setAusilioMaterialeGalleggiante(ausilioMaterialeGalleggiante);
				newBambino.setInfoEsigenzeAlimentari(infoEsigenzeAlimentari);
				newBambino.setFarmaci(farmaci);
				newBambino.setInfoAllergie(infoAllergie);
				newBambino.setDocumentoIdentita(documentoIdentita);
				newBambino.setCertificatoMedico(certificatoMedico);
				newBambino.setTagliaIndumenti(tagliaIndumenti);
				newBambino.setGenitore(genitore);
				bambinoManage.save(newBambino);
			}
			
			//Compongo le settimane dati gli id dalla richiesta
			SettimanaManage settimanaManage = new SettimanaManageDS();
			List<Settimana> listaSettimane = new ArrayList<Settimana>();
			for(Integer id:settimane) {
				listaSettimane.add(settimanaManage.getSettimana(id));
			}
			
			float prezzo = this.calcolaPrezzo(listaSettimane.size(), tipoSoggiorno, disabilita, servizioSportivo);
			
			IscrizioneManage iscrizioneManage = new IscrioneManageDS();
			Iscrizione iscrizione = new Iscrizione();
			iscrizione.setPrezzo(prezzo);
			iscrizione.setTipoSoggiorno(tipoSoggiorno);
			iscrizione.setRichiestaDisdetta(false);
			iscrizione.setRimborsoDisdetta(0);
			iscrizione.setDataIscrizione(new Date());
			iscrizione.setQrCode("QRCODE");
			if(bambino!=null) {
				iscrizione.setBambino(bambino);
			} else {
				iscrizione.setBambino(newBambino);
			}
			iscrizione.setGenitore(genitore);
			iscrizione.setSettimane(listaSettimane);
		} catch(PersistenceException e) {
			
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
