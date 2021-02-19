package model.daoTest;

import java.util.GregorianCalendar;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.After;
import org.mockito.Mockito;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import model.dao.IscrizioneManageDS;
import model.entity.Bambino;
import model.entity.Genitore;
import model.entity.Iscrizione;
import model.entity.Settimana;

public class IscrizioneManageDSTest extends TestCase{

	public void setUp() {
		entityManager = Mockito.mock(EntityManager.class);
		isc= new IscrizioneManageDS(entityManager);
		query = Mockito.mock(Query.class);
		transaction = Mockito.mock(EntityTransaction.class);
		settimana= Mockito.mock(Settimana.class);
		Mockito.mock(Genitore.class);
		Mockito.mock(Bambino.class);
		
		listaSett= new ArrayList<Settimana>();
		listaSett.add(settimana);
		
		Mockito.when(entityManager.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(query.setParameter(Mockito.anyString(), Mockito.anyString())).thenReturn(query);
		Mockito.when(entityManager.getTransaction()).thenReturn(transaction);
		
	}
	
	
	@After
	public void tearDown() {
		entityManager.close();
		isc.close();
	}
	
	public void testIscrizione1Corretto() {
		
		i.setBambino(bambino);
		i.setIdIscrizione(1);
		i.setDataIscrizione(data.getTime());
		i.setQrCode("QRcode");
		i.setPrezzo(100);
		i.setRichiestaDisdetta(false);
		i.setRimborsoDisdetta(0);
		i.setServizioSportivo(true);
		i.setTipoSoggiorno("Part-Time");
		i.setPagata(false);	
		i.setSettimane(listaSett);
		
	
		isc.save(i);
		
	}
	
	
	public void testIscrizione2TipoDiSoggiornoNonSelezionato() {
		i.setBambino(bambino);
		i.setIdIscrizione(1);
		i.setDataIscrizione(data.getTime());
		i.setQrCode("QRcode");
		i.setPrezzo(100);
		i.setRichiestaDisdetta(false);
		i.setRimborsoDisdetta(0);
		i.setServizioSportivo(true);
		i.setTipoSoggiorno("");
		i.setPagata(false);	
		i.setSettimane(listaSett);		
		
		
		try {
			isc.save(i);
			fail("Dovrebbe esserci Illegal Argument Exception");
		}catch(IllegalArgumentException e) {
			
		}
		
	}
	
	public void testIscrizione3SettimaneNonSelezionate() {
		i.setBambino(bambino);
		i.setIdIscrizione(1);
		i.setDataIscrizione(data.getTime());
		i.setQrCode("QRcode");
		i.setPrezzo(100);
		i.setRichiestaDisdetta(false);
		i.setRimborsoDisdetta(0);
		i.setServizioSportivo(true);
		i.setTipoSoggiorno("Part-Time");
		i.setPagata(false);		
		
		
		try {
			isc.save(i);
			fail("Dovrebbe esserci Illegal Argument Exception");
		}catch(IllegalArgumentException e) {
			
		}
		
	}
	
	
	public static Test suite() {
		return new TestSuite(IscrizioneManageDSTest.class);
	}
	
	
	private Bambino bambino;
	private Settimana settimana;
	private List<Settimana> listaSett;
	private Iscrizione i=new Iscrizione();
	private GregorianCalendar data= new GregorianCalendar(2020,1,20);
	private IscrizioneManageDS isc;
	private EntityManager entityManager;
	private Query query;
	private EntityTransaction transaction;
}
