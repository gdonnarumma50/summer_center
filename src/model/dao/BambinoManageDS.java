package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import listener.LocalEntityManagerFactory;
import model.entity.Bambino;
import model.entity.Utente;

public class BambinoManageDS implements BambinoManage {

	public BambinoManageDS() {
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
	public void save(Bambino b) throws PersistenceException {
		if(b!=null) {
			em.getTransaction().begin();
			em.persist(b);
			em.getTransaction().commit();
		}
	}

	@Override
	public void update(Bambino b) throws PersistenceException {
		if(b!=null) {
			em.getTransaction().begin();
			em.persist(b);
			em.getTransaction().commit();
		}
		
	}

	@Override
	public List<Bambino> getBambini(String cfGenitore) {
		try {
			return em.createNamedQuery(Bambino.FIND_BY_GENITORE, Bambino.class)
					.setParameter("cfGenitore", cfGenitore).getResultList();
		} finally {
			close();
		} 
	}
	
	@Override
	public Bambino getBambino(String codiceFiscale) {
		return em.find(Bambino.class, codiceFiscale);
	}
	
	private EntityManager em;

}
