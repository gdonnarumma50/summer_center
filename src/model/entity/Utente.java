package model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
/**
 * Entity implementation class for Entity: Utente
 *
 */
@Entity
@Table(name = "utente")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ruolo")
public abstract class Utente implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Utente() {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	public char getGenere() {
		return genere;
	}
	public void setGenere(char genere) {
		this.genere = genere;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getEta() {
		return eta;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}
	public String getNumTelefono() {
		return numTelefono;
	}
	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}

	@Override
	public String toString() {
		return "Utente [codiceFiscale=" + codiceFiscale + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email
				+ ", dataNascita=" + dataNascita + ", genere=" + genere + ", password=" + password + ", numTelefono="
				+ numTelefono + ", eta=" + eta + "]";
	}

	public static final boolean matches(Utente u) {
		if(!u.getNome().matches("^[A-Za-z ]{3,}$")
			|| !u.getCognome().matches("^[A-Za-z ]{3,}$")
			|| !u.getCodiceFiscale().matches("^[a-zA-Z]{6}[0-9]{2}[abcdehlmprstABCDEHLMPRST]{1}[0-9]{2}([a-zA-Z]{1}[0-9]{3})[a-zA-Z]{1}$")
			|| !u.getEmail().matches("\\S+@\\S+\\.\\S+")
			|| !u.getNumTelefono().matches("^[0-9]{8,16}$")
			|| !u.getPassword().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")
			|| u.getDataNascita().after(new Date())) {
			
			return false;
			
		} else return true;
	}

	@Id
	@Column(name="codiceFiscaleUtente")
	private String codiceFiscale;
	private String nome;
	private String cognome;
	private String email;
	private Date dataNascita;
	private char genere;
	private String password;
	private String numTelefono;
	@Transient
	private int eta;
   
}
