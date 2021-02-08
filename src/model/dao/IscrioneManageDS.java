package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import listener.LocalEntityManagerFactory;
import model.entity.Iscrizione;

public class IscrioneManageDS implements IscrizioneManage {
	
	public IscrioneManageDS() {
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
	
	public void save(Iscrizione i) throws PersistenceException {
		if(i!=null) {
			em.getTransaction().begin();
			em.persist(i);
			em.getTransaction().commit();
		}
	}
	
	private EntityManager em;

}
