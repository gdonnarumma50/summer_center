package model.dao;

import java.util.List;

import model.entity.Iscrizione;

public interface IscrizioneManage {
	void save(Iscrizione i);
	
	List<Iscrizione> getIscrizioniByGenitore(String cfGenitore);
}
