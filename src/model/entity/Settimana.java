package model.entity;

import static model.entity.Settimana.FIND_BY_SETTIMANE_DISPONIBILI;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Settimana
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name=FIND_BY_SETTIMANE_DISPONIBILI, query="SELECT s FROM Settimana s WHERE s.disponibilita > 0")
})
public class Settimana implements Serializable {

	public Settimana() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	public Date getDataFine() {
		return dataFine;
	}
	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}
	public int getDisponibilita() {
		return disponibilita;
	}
	public void setDisponibilita(int disponibilita) {
		this.disponibilita = disponibilita;
	}
	
	
	@Override
	public String toString() {
		return "Settimana [id=" + id + ", dataInizio=" + dataInizio + ", dataFine=" + dataFine + ", disponibilita="
				+ disponibilita + "]";
	}


	private static final long serialVersionUID = 1L;
	public static final String FIND_BY_SETTIMANE_DISPONIBILI = "Settimana.findBySettimaneDisponibili";

	@Id
	@GeneratedValue
	private int id;
	private Date dataInizio;
	private Date dataFine;
	private int disponibilita;
   
}