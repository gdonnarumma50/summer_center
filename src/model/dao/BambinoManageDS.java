package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import listener.LocalEntityManagerFactory;
import model.entity.Bambino;

public class BambinoManageDS implements BambinoManage {

	public BambinoManageDS() {
		try{
			em = LocalEntityManagerFactory.getEntityManager();
		} catch( RuntimeException ex){
			ex.printStackTrace(System.err);
			throw ex;
		}
	}
	public BambinoManageDS(EntityManager entityManager) {
		this.em = entityManager;
	}	
	public void close(){
		em.close();
	}

	@Override
	public void save(Bambino b) throws PersistenceException {
	if(b!=null) {
		if(Bambino.matches(b)) {
			
				em.getTransaction().begin();
				em.persist(b);
				em.getTransaction().commit();
			} else throw new IllegalArgumentException("I campi inseriti non rispettano i controlli");
		}
	}

	@Override
	public void update(Bambino b) throws PersistenceException {
	if(b!=null) {
		if(Bambino.matches(b)) {
			
				em.getTransaction().begin();
				em.persist(b);
				em.getTransaction().commit();
			} else throw new IllegalArgumentException("I campi inseriti non rispettano i controlli");
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
