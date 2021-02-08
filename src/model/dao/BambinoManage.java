package model.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import model.entity.Bambino;

public interface BambinoManage {

	void save(Bambino b) throws PersistenceException;
	void update(Bambino b) throws PersistenceException;
	List<Bambino> getBambini(String cfGenitore);
	/**
	 * Ritorna un bambino dato il codice fiscale
	 * @param codiceFiscale
	 * @return Bambino se esiste, altrimenti null
	 */
	Bambino getBambino(String codiceFiscale);
}
