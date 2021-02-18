package model.entity;

import static model.entity.Iscrizione.FIND_ISCRIZIONE_BY_GENITORE;
import static model.entity.Iscrizione.FIND_ALL;
import static model.entity.Iscrizione.FIND_ISCRIZIONE;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Iscrizione
 *
 */
@Entity
@Table(name="iscrizione")
@NamedQueries({
	@NamedQuery(name=FIND_ISCRIZIONE_BY_GENITORE, query="SELECT i FROM Iscrizione i WHERE i.genitore.codiceFiscale=:cfGenitore"),
	@NamedQuery(name=FIND_ALL, query="SELECT i FROM Iscrizione i"),
	@NamedQuery(name=FIND_ISCRIZIONE, query="SELECT i FROM Iscrizione i WHERE i.idIscrizione=:idIscrizione")
})
public class Iscrizione implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Iscrizione() {
		super();
	}
	
	public int getIdIscrizione() {
		return idIscrizione;
	}
	public void setIdIscrizione(int idIscrizione) {
		this.idIscrizione = idIscrizione;
	}
	public Date getDataIscrizione() {
		return dataIscrizione;
	}
	public void setDataIscrizione(Date dataIscrizione) {
		this.dataIscrizione = dataIscrizione;
	}
	public String getQrCode() {
		return qrCode;
	}
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}
	public float getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	public boolean isRichiestaDisdetta() {
		return richiestaDisdetta;
	}
	public void setRichiestaDisdetta(boolean richiestaDisdetta) {
		this.richiestaDisdetta = richiestaDisdetta;
	}
	public float getRimborsoDisdetta() {
		return rimborsoDisdetta;
	}
	public void setRimborsoDisdetta(float rimborsoDisdetta) {
		this.rimborsoDisdetta = rimborsoDisdetta;
	}
	public boolean isServizioSportivo() {
		return servizioSportivo;
	}
	public void setServizioSportivo(boolean servizioSportivo) {
		this.servizioSportivo = servizioSportivo;
	}
	public String getTipoSoggiorno() {
		return tipoSoggiorno;
	}
	public void setTipoSoggiorno(String tipoSoggiorno) {
		this.tipoSoggiorno = tipoSoggiorno;
	}
	public Bambino getBambino() {
		return bambino;
	}
	public void setBambino(Bambino bambino) {
		this.bambino = bambino;
	}
	public Genitore getGenitore() {
		return genitore;
	}
	public void setGenitore(Genitore genitore) {
		this.genitore = genitore;
	}

	public List<Settimana> getSettimane() {
		return settimane;
	}

	public void setSettimane(List<Settimana> settimane) {
		this.settimane = settimane;
	}

	public boolean isPagata() {
		return pagata;
	}

	public void setPagata(boolean pagata) {
		this.pagata = pagata;
	}

	@Override
	public String toString() {
		return "Iscrizione [idIscrizione=" + idIscrizione + ", dataIscrizione=" + dataIscrizione + ", qrCode=" + qrCode
				+ ", prezzo=" + prezzo + ", richiestaDisdetta=" + richiestaDisdetta + ", rimborsoDisdetta="
				+ rimborsoDisdetta + ", servizioSportivo=" + servizioSportivo + ", tipoSoggiorno=" + tipoSoggiorno
				+ ", pagata=" + pagata + ", bambino=" + bambino + ", genitore=" + genitore + ", settimane=" + settimane
				+ "]";
	}
	
	public static final boolean matches(Iscrizione i) {
		if(!i.getQrCode().matches("^[A-Za-z 0-9 ]{2,}$")
			|| i.getDataIscrizione().after(new Date())
			|| !i.getTipoSoggiorno().matches("^[A-Za-z -]{9,9}$")
			|| i.getSettimane()==null)
		{
			
			return false;
			
		} else return true;
	}


	public static final String FIND_ISCRIZIONE_BY_GENITORE = "Iscrizione.findIscrizioneByGenitore";
	public static final String FIND_ALL = "Iscrizione.findAll";
	public static final String FIND_ISCRIZIONE = "Iscrizione.findByKey";


	@Id
	@Column(name="idiscrizione")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idIscrizione;
	private Date dataIscrizione;
	private String qrCode;
	private float prezzo;
	private boolean richiestaDisdetta;
	private float rimborsoDisdetta;
	private boolean servizioSportivo;
	private String tipoSoggiorno;
	private boolean pagata;
	@ManyToOne
	@JoinColumn(name = "cfBambino", referencedColumnName = "codiceFiscale")
	private Bambino bambino;
	@ManyToOne
	@JoinColumn(name = "cfGenitore", referencedColumnName = "codiceFiscaleUtente")
	private Genitore genitore;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
	  name = "iscrizionesettimana", 
	  joinColumns = @JoinColumn(name = "idiscrizione"), 
	  inverseJoinColumns = @JoinColumn(name = "idsettimana"))
	private List<Settimana> settimane;
   
}
