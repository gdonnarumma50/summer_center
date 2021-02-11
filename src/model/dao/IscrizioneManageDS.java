package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import listener.LocalEntityManagerFactory;
import model.entity.Iscrizione;

public class IscrizioneManageDS implements IscrizioneManage {
	
	public IscrizioneManageDS() {
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

	@Override
	public List<Iscrizione> getIscrizioniByGenitore(String cfGenitore) {
	try {
		return em.createNamedQuery(Iscrizione.FIND_ISCRIZIONE_BY_GENITORE, Iscrizione.class)
				.setParameter("cfGenitore", cfGenitore).getResultList();
	
	} finally {
		close();
		}
	}


	@Override
	public List<Iscrizione> getAll() {
	try {
		return em.createNamedQuery(Iscrizione.FIND_ALL, Iscrizione.class).getResultList();
	} finally {
			close();
			}
	}
	
	private EntityManager em;

}
