package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import listener.LocalEntityManagerFactory;

public class UtenteDAO {
private EntityManager entityManager;
	
	public UtenteDAO() {
		try{
			entityManager = LocalEntityManagerFactory.getEntityManager();
		} catch( RuntimeException ex){
			ex.printStackTrace(System.err);
			throw ex;
		}
	}
	
	public void close(){
		entityManager.close();
	}

	public User getUser() {
		Query queryObj = entityManager.createQuery("SELECT u FROM User u WHERE id=1");
		User u = (User) queryObj.getSingleResult();
		return u;
	}

}
