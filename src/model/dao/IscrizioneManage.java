package model.dao;

import java.util.List;

import model.entity.Iscrizione;

public interface IscrizioneManage {
	
	void save(Iscrizione i);
	
	Iscrizione getIscrizione(int idIscrizione);
	
	List<Iscrizione> getIscrizioniByGenitore(String cfGenitore);
	
	List<Iscrizione> getAll();
}
