package model.daoTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.*;
import org.junit.Test;
import org.mockito.Mockito;

import model.dao.UtenteManageDS;
import model.entity.Utente;
import junit.framework.*;



public class UtenteManageDSTest extends TestCase{
	
	@Before
	public void setup(){
		
	}
	@After
	public void teardown() {
		entityManager.close();
		userManage.close();
	}
	
	
	@Test
	public void testGetUserIfExists1Corretto(){
		entityManager =  Mockito.mock(EntityManager.class);
		userManage = Mockito.mock(UtenteManageDS.class);
		query = Mockito.mock(Query.class);
		utente = Mockito.mock(Utente.class);
		
		Mockito.when(entityManager.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(query.setParameter(Mockito.anyString(), Mockito.anyString())).thenReturn(query);
		Mockito.when(query.getSingleResult()).thenReturn(utente);
		Mockito.when(userManage.getUserIfExists("mariorossi@gmail.com","Mario2020@")).thenReturn(utente);
		
		utente = userManage.getUserIfExists("mariorossi@gmail.com", "Mario2020@");
		
		assertNotNull(utente);
	}
	
	
	public static TestSuite suite() {
		return new TestSuite(UtenteManageDSTest.class);
	}
	
	String email;
	String password;
	private EntityManager entityManager;
	private UtenteManageDS userManage;
	private Utente utente;
	private Query query;

}
