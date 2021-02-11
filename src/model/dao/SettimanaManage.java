package model.dao;
import model.entity.Settimana;
import java.util.List;

public interface SettimanaManage {
	/**
	 * Ritorna una settimana dato l'id
	 * @return Settimana, altrimenti null
	 */
	Settimana getSettimana(int id);
	
	List<Settimana> getSettimaneDisponibili();
}
