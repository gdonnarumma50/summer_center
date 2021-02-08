package model.dao;

import javax.persistence.PersistenceException;

import model.entity.Utente;

public interface UtenteManage {

	void save(Utente u) throws PersistenceException;
	/**
	 * Ritorna l'utente se esiste
	 * @param email
	 * @param password
	 * @return Utente, altrimenti null
	 */
	Utente getUserIfExists(String email, String password);
}
