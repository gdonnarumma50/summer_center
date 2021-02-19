package model.entity;

import java.io.Serializable;
import static model.entity.Bambino.FIND_BY_GENITORE;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Bambino
 *
 */
@Entity
@Table(name="bambino")
@NamedQueries({
	@NamedQuery(name=FIND_BY_GENITORE, query="SELECT b FROM Bambino b WHERE b.genitore.codiceFiscale=:cfGenitore")
})
public class Bambino implements Serializable {

	public Bambino() {
	}
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getLuogoNascita() {
		return luogoNascita;
	}
	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}
	public int getEta() {
		return eta;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}
	public boolean isDisabilita() {
		return disabilita;
	}
	public void setDisabilita(boolean disabilita) {
		this.disabilita = disabilita;
	}
	public String getDocumentoIdentita() {
		return documentoIdentita;
	}
	public void setDocumentoIdentita(String documentoIdentita) {
		this.documentoIdentita = documentoIdentita;
	}
	public boolean isAusilioMaterialeGalleggiante() {
		return ausilioMaterialeGalleggiante;
	}
	public void setAusilioMaterialeGalleggiante(boolean ausilioMaterialeGalleggiante) {
		this.ausilioMaterialeGalleggiante = ausilioMaterialeGalleggiante;
	}
	public String getCertificatoMedico() {
		return certificatoMedico;
	}
	public void setCertificatoMedico(String certificatoMedico) {
		this.certificatoMedico = certificatoMedico;
	}
	public String getFarmaci() {
		return farmaci;
	}
	public void setFarmaci(String farmaci) {
		this.farmaci = farmaci;
	}
	public String getInfoEsigenzeAlimentari() {
		return infoEsigenzeAlimentari;
	}
	public void setInfoEsigenzeAlimentari(String infoEsigenzeAlimentari) {
		this.infoEsigenzeAlimentari = infoEsigenzeAlimentari;
	}
	public boolean isEsigenzeAlimentari() {
		return esigenzeAlimentari;
	}
	public void setEsigenzeAlimentari(boolean esigenzeAlimentari) {
		this.esigenzeAlimentari = esigenzeAlimentari;
	}
	public String getTagliaIndumenti() {
		return tagliaIndumenti;
	}
	public void setTagliaIndumenti(String tagliaIndumenti) {
		this.tagliaIndumenti = tagliaIndumenti;
	}
	public Genitore getGenitore() {
		return genitore;
	}
	public void setGenitore(Genitore genitore) {
		this.genitore = genitore;
	}
	
	
	public String getInfoAllergie() {
		return infoAllergie;
	}

	public void setInfoAllergie(String infoAllergie) {
		this.infoAllergie = infoAllergie;
	}

	public char getGenere() {
		return genere;
	}

	public void setGenere(char genere) {
		this.genere = genere;
	}

	@Override
	public String toString() {
		return "Bambino [codiceFiscale=" + codiceFiscale + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita="
				+ dataNascita + ", luogoNascita=" + luogoNascita + ", eta=" + eta + ", disabilita=" + disabilita
				+ ", documentoIdentita=" + documentoIdentita + ", ausilioMaterialeGalleggiante="
				+ ausilioMaterialeGalleggiante + ", certificatoMedico=" + certificatoMedico + ", farmaci=" + farmaci
				+ ", infoEsigenzeAlimentari=" + infoEsigenzeAlimentari + ", esigenzeAlimentari=" + esigenzeAlimentari
				+ ", tagliaIndumenti=" + tagliaIndumenti + ", infoAllergie=" + infoAllergie + ", genere=" + genere
				+ ", genitore=" + genitore + "]";
	}

	public static final boolean matches(Bambino b) {
		if(!b.getNome().matches("^[A-Za-z ]{3,}$")
			|| (!b.getCognome().matches("^[A-Za-z ]{3,}$"))
			|| (!b.getCodiceFiscale().matches("^[a-zA-Z]{6}[0-9]{2}[abcdehlmprstABCDEHLMPRST]{1}[0-9]{2}([a-zA-Z]{1}[0-9]{3})[a-zA-Z]{1}$"))
			|| (b.getEta()>=18)
			|| (b.getDataNascita()==null)
			|| (!b.getLuogoNascita().matches("^[A-Za-z ]{3,}$"))
			|| (b.getCertificatoMedico()!=null && !b.getCertificatoMedico().matches("([a-zA-Z0-9\\s_\\\\.\\-\\(\\):])+(.jpeg|.png|.pdf)$"))
			|| (b.getDocumentoIdentita()!=null && !b.getDocumentoIdentita().matches("([a-zA-Z0-9\\s_\\\\.\\-\\(\\):])+(.jpeg|.png|.pdf)$"))
			|| (b.getInfoEsigenzeAlimentari()!=null && !b.getInfoEsigenzeAlimentari().matches("^[A-Za-z 0-9 ]{0,}$"))
			|| (b.getFarmaci()!=null && !b.getFarmaci().matches("^[A-Za-z 0-9 ]{0,}$"))
			|| (b.getInfoAllergie()!=null && !b.getInfoAllergie().matches("^[A-Za-z 0-9 ]{0,}$"))
			|| (b.getTagliaIndumenti()!=null && !b.getTagliaIndumenti().matches("^[A-Za-z ]{1,4}$"))) {
			
			return false;
			
		} else return true;
	}


	private static final long serialVersionUID = 1L;
	public static final String FIND_BY_GENITORE = "Bambino.findByGenitore";

	@Id
	private String codiceFiscale;
	private String nome;
	private String cognome;
	private Date dataNascita;
	private String luogoNascita;
	@Transient
	private int eta;
	private boolean disabilita;
	private String documentoIdentita;
	private boolean ausilioMaterialeGalleggiante;
	private String certificatoMedico;
	private String farmaci;
	private String infoEsigenzeAlimentari;
	private boolean esigenzeAlimentari;
	private String tagliaIndumenti;
	private String infoAllergie;
	private char genere;
	@ManyToOne
	@JoinColumn(name = "cfGenitore", referencedColumnName = "codiceFiscaleUtente")
	private Genitore genitore;
   
}
