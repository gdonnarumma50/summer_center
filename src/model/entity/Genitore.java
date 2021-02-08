package model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Genitore
 *
 */
@Entity
@DiscriminatorValue("genitore")
public class Genitore extends Utente {
	
	public Genitore() {
	}
	
	public String getLuogoNascita() {
		return luogoNascita;
	}
	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCAP() {
		return CAP;
	}
	public void setCAP(String cAP) {
		CAP = cAP;
	}
	public String getProfessione() {
		return professione;
	}
	public void setProfessione(String professione) {
		this.professione = professione;
	}
	public String getNumTelefonoSecondario() {
		return numTelefonoSecondario;
	}
	public void setNumTelefonoSecondario(String numTelefonoSecondario) {
		this.numTelefonoSecondario = numTelefonoSecondario;
	}
	public String getDocumentoIdentita() {
		return documentoIdentita;
	}
	public void setDocumentoIdentita(String documentoIdentita) {
		this.documentoIdentita = documentoIdentita;
	}
	public boolean isConsensoInfo() {
		return consensoInfo;
	}
	public void setConsensoInfo(boolean consensoInfo) {
		this.consensoInfo = consensoInfo;
	}
	public boolean isConsensoImgEVideo() {
		return consensoImgEVideo;
	}
	public void setConsensoImgEVideo(boolean consensoImgEVideo) {
		this.consensoImgEVideo = consensoImgEVideo;
	}
	public String getDelega() {
		return delega;
	}
	public void setDelega(String delega) {
		this.delega = delega;
	}
	public String getInfoFamiliari() {
		return infoFamiliari;
	}
	public void setInfoFamiliari(String infoFamiliari) {
		this.infoFamiliari = infoFamiliari;
	}

	@Override
	public String toString() {
		return "Genitore [luogoNascita=" + luogoNascita + ", indirizzo=" + indirizzo + ", citta=" + citta
				+ ", provincia=" + provincia + ", CAP=" + CAP + ", professione=" + professione
				+ ", numTelefonoSecondario=" + numTelefonoSecondario + ", documentoIdentita=" + documentoIdentita
				+ ", consensoInfo=" + consensoInfo + ", consensoImgEVideo=" + consensoImgEVideo + ", delega=" + delega
				+ ", infoFamiliari=" + infoFamiliari + "]";
	}


	private String luogoNascita;
	private String indirizzo;
	private String citta;
	private String provincia;
	private String CAP;
	private String professione;
	private String numTelefonoSecondario;
	private String documentoIdentita;
	private boolean consensoInfo;
	private boolean consensoImgEVideo;
	private String delega;
	private String infoFamiliari;

}

