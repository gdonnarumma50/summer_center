package model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import listener.LocalEntityManagerFactory;
import model.entity.Bambino;
import model.entity.Settimana;

public class SettimanaManageDS implements SettimanaManage {

	public SettimanaManageDS() {
		try{
			em = LocalEntityManagerFactory.getEntityManager();
		} catch( RuntimeException ex){
			ex.printStackTrace(System.err);
			throw ex;
		}
	}
	
	public void close(){
		em.close();
	}
	
	@Override
	public Settimana getSettimana(int id) {
		return em.find(Settimana.class, id);
	}

	@Override
	public List<Settimana> getSettimaneDisponibili() {
		try {
			return em.createNamedQuery(Settimana.FIND_BY_SETTIMANE_DISPONIBILI, Settimana.class).getResultList();
		} finally {
			close();
		} 
	}
	
	private EntityManager em;

}
