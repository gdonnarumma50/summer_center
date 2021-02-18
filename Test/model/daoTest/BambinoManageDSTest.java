package model.daoTest;

import java.util.GregorianCalendar;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.EntityManager;


import org.junit.After;
import org.junit.Before;
import org.mockito.Mockito;

import junit.framework.*;
import model.dao.BambinoManageDS;
import model.entity.Bambino;
import model.entity.Genitore;


public class BambinoManageDSTest extends TestCase{
	
	@Before 
	public void setUp() {
		entityManager = Mockito.mock(EntityManager.class);
		bam= new BambinoManageDS(entityManager);
		query = Mockito.mock(Query.class);
		transaction = Mockito.mock(EntityTransaction.class);
		
		Mockito.when(entityManager.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(query.setParameter(Mockito.anyString(), Mockito.anyString())).thenReturn(query);
		Mockito.when(entityManager.getTransaction()).thenReturn(transaction);
		
		
	}
	@After
	public void tearDown() {
		entityManager.close();
		bam.close();
	}
	
	public void testBambino1corretto() {
		a.setAusilioMaterialeGalleggiante(false);
		a.setCertificatoMedico("wau");
		a.setCodiceFiscale("DLANTN98A13H703Y");
		a.setCognome("Dalia");
		a.setDataNascita(data.getTime());
		a.setDisabilita(false);
		a.setDocumentoIdentita("ci sta");
		a.setEsigenzeAlimentari(false);
		a.setFarmaci(null);
		a.setGenere('M');
		a.setGenitore(genitore);
		a.setInfoAllergie(null);
		a.setInfoEsigenzeAlimentari(null);
		a.setLuogoNascita("Salerno");
		a.setNome("Antonio");
		a.setTagliaIndumenti("xl");
		
		bam.save(a);
		
	}
	
	
	public void testBambino2ConOpzionali() {
		a.setAusilioMaterialeGalleggiante(false);
		a.setCertificatoMedico("wau");
		a.setCodiceFiscale("DLANTN98A13H703Y");
		a.setCognome("Dalia");
		a.setDataNascita(data.getTime());
		a.setDisabilita(false);
		a.setDocumentoIdentita("ci sta");
		a.setEsigenzeAlimentari(false);
		a.setFarmaci("si");
		a.setGenere('M');
		a.setGenitore(genitore);
		a.setInfoAllergie("si");
		a.setInfoEsigenzeAlimentari("si");
		a.setLuogoNascita("Salerno");
		a.setNome("Antonio");
		a.setTagliaIndumenti("xl");
		
		bam.save(a);
		
	}
	
	public void testBambino3FormatoFileErrato() {
		a.setAusilioMaterialeGalleggiante(false);
		a.setCertificatoMedico("");
		a.setCodiceFiscale("DLANTN98A13H703Y");
		a.setCognome("Dalia");
		a.setDataNascita(data.getTime());
		a.setDisabilita(false);
		a.setDocumentoIdentita("");
		a.setEsigenzeAlimentari(false);
		a.setFarmaci(null);
		a.setGenere('M');
		a.setGenitore(genitore);
		a.setInfoAllergie(null);
		a.setInfoEsigenzeAlimentari(null);
		a.setLuogoNascita("Salerno");
		a.setNome("Antonio");
		a.setTagliaIndumenti("xl");
		
		
		
		try {
			bam.save(a);
			fail("Dovrebbe esserci Illegal Argument Exception");
		}catch(IllegalArgumentException e) {
			
		}
		
	}
	
	public void testBambino4FormatoCFErrato() {
		a.setAusilioMaterialeGalleggiante(false);
		a.setCertificatoMedico("wau");
		a.setCodiceFiscale("DLANTN98A13H703");
		a.setCognome("Dalia");
		a.setDataNascita(data.getTime());
		a.setDisabilita(false);
		a.setDocumentoIdentita("ci sta");
		a.setEsigenzeAlimentari(false);
		a.setFarmaci(null);
		a.setGenere('M');
		a.setGenitore(genitore);
		a.setInfoAllergie(null);
		a.setInfoEsigenzeAlimentari(null);
		a.setLuogoNascita("Salerno");
		a.setNome("Antonio");
		a.setTagliaIndumenti("xl");
		
		
		
	  try {
			
			bam.save(a);
			fail("Dovrebbe esserci Illegal Argument Exception");
		}catch(IllegalArgumentException e) {
			
		}
		
	}
	
	public void testBambino5FormatoNomeErrato() {
		a.setAusilioMaterialeGalleggiante(false);
		a.setCertificatoMedico("wau");
		a.setCodiceFiscale("DLANTN98A13H703Y");
		a.setCognome("Dalia");
		a.setDataNascita(data.getTime());
		a.setDisabilita(false);
		a.setDocumentoIdentita("ci sta");
		a.setEsigenzeAlimentari(false);
		a.setFarmaci(null);
		a.setGenere('M');
		a.setGenitore(genitore);
		a.setInfoAllergie(null);
		a.setInfoEsigenzeAlimentari(null);
		a.setLuogoNascita("Salerno");
		a.setNome("1234");
		a.setTagliaIndumenti("xl");
		
		
		try {
		
			bam.save(a);
			fail("Dovrebbe esserci Illegal Argument Exception");
		}catch(IllegalArgumentException e) {
			
		}
		
	}
	
	public void testBambino6FormatoCognomeErrato() {
		a.setAusilioMaterialeGalleggiante(false);
		a.setCertificatoMedico("wau");
		a.setCodiceFiscale("DLANTN98A13H703Y");
		a.setCognome("1234");
		a.setDataNascita(data.getTime());
		a.setDisabilita(false);
		a.setDocumentoIdentita("ci sta");
		a.setEsigenzeAlimentari(false);
		a.setFarmaci(null);
		a.setGenere('M');
		a.setGenitore(genitore);
		a.setInfoAllergie(null);
		a.setInfoEsigenzeAlimentari(null);
		a.setLuogoNascita("Salerno");
		a.setNome("Antonio");
		a.setTagliaIndumenti("xl");
		
		
		
		try {
		
			bam.save(a);
			fail("Dovrebbe esserci Illegal Argument Exception");
		}catch(IllegalArgumentException e) {
			
		}
		
	}
	public void testBambino7FormatoLNErrato() {
		a.setAusilioMaterialeGalleggiante(false);
		a.setCertificatoMedico("wau");
		a.setCodiceFiscale("DLANTN98A13H703Y");
		a.setCognome("Dalia");
		a.setDataNascita(data.getTime());
		a.setDisabilita(false);
		a.setDocumentoIdentita("ci sta");
		a.setEsigenzeAlimentari(false);
		a.setFarmaci(null);
		a.setGenere('M');
		a.setGenitore(genitore);
		a.setInfoAllergie(null);
		a.setInfoEsigenzeAlimentari(null);
		a.setLuogoNascita("1234");
		a.setNome("Antonio");
		a.setTagliaIndumenti("xl");
		
		
		
			try {
				bam.save(a);
				fail("Dovrebbe esserci Illegal Argument Exception");
		}catch(IllegalArgumentException e) {
				
	  }
	
	}
	
	
	public void testBambino8FormatoDNErrato() {
		a.setAusilioMaterialeGalleggiante(false);
		a.setCertificatoMedico("wau");
		a.setCodiceFiscale("DLANTN98A13H703Y");
		a.setCognome("Dalia");
		a.setDisabilita(false);
		a.setDocumentoIdentita("ci sta");
		a.setEsigenzeAlimentari(false);
		a.setFarmaci(null);
		a.setGenere('M');
		a.setGenitore(genitore);
		a.setInfoAllergie(null);
		a.setInfoEsigenzeAlimentari(null);
		a.setLuogoNascita("Salerno");
		a.setNome("Antonio");
		a.setTagliaIndumenti("xl");
		
		
		
			try {
				bam.save(a);
				fail("Dovrebbe esserci Illegal Argument Exception");
			}catch(IllegalArgumentException e) {
				
		}
		
	}
	
	public void testBambino9FormatoTagliaErrato() {
		a.setAusilioMaterialeGalleggiante(false);
		a.setCertificatoMedico("wau");
		a.setCodiceFiscale("DLANTN98A13H703Y");
		a.setCognome("Dalia");
		a.setDataNascita(data.getTime());
		a.setDisabilita(false);
		a.setDocumentoIdentita("ci sta");
		a.setEsigenzeAlimentari(false);
		a.setFarmaci(null);
		a.setGenere('M');
		a.setGenitore(genitore);
		a.setInfoAllergie(null);
		a.setInfoEsigenzeAlimentari(null);
		a.setLuogoNascita("Salerno");
		a.setNome("Antonio");
		a.setTagliaIndumenti("bcbcbcbcbcbcb");
		
		
		
		try {
		
			bam.save(a);
			fail("Dovrebbe esserci Illegal Argument Exception");
		}catch(IllegalArgumentException e) {
			
		}
		
	}
	
	public void testBambinoUpdate1ModificaParametriObbligatori() {
		a.setAusilioMaterialeGalleggiante(false);
		a.setCertificatoMedico("wau");
		a.setCodiceFiscale("DLANTN98A13H703Y");
		a.setCognome("Dalia");
		a.setDataNascita(data.getTime());
		a.setDisabilita(false);
		a.setDocumentoIdentita("ci sta");
		a.setEsigenzeAlimentari(false);
		a.setFarmaci(null);
		a.setGenere('M');
		a.setGenitore(genitore);
		a.setInfoAllergie(null);
		a.setInfoEsigenzeAlimentari(null);
		a.setLuogoNascita("Salerno");
		a.setNome("Antonio");
		a.setTagliaIndumenti("xl");
		
		bam.save(a);
		
		a.setCertificatoMedico("ci sta 1");
		a.setDocumentoIdentita("ci sta 1");
		a.setTagliaIndumenti("m");
		
		
		try {
			
			bam.update(a);
		}catch(IllegalArgumentException e) {
			
		}
		
	}
	
	public void testBambinoUpdate2ModificaParametriNonObbligatori() {
		a.setAusilioMaterialeGalleggiante(false);
		a.setCertificatoMedico("ci sta");
		a.setCodiceFiscale("DLANTN98A13H703Y");
		a.setCognome("Dalia");
		a.setDataNascita(data.getTime());
		a.setDisabilita(false);
		a.setDocumentoIdentita("ci sta");
		a.setEsigenzeAlimentari(false);
		a.setFarmaci(null);
		a.setGenere('M');
		a.setGenitore(genitore);
		a.setInfoAllergie(null);
		a.setInfoEsigenzeAlimentari(null);
		a.setLuogoNascita("Salerno");
		a.setNome("Antonio");
		a.setTagliaIndumenti("xl");
		
		bam.save(a);
		
		a.setAusilioMaterialeGalleggiante(true);
		a.setDisabilita(true);
		a.setEsigenzeAlimentari(true);
		a.setFarmaci("aspirina");
		a.setInfoAllergie("polvere");
		a.setInfoEsigenzeAlimentari("pane e acqua");
		
		
		try {
			
			bam.update(a);
		}catch(IllegalArgumentException e) {
			
		}
		
	}
	
	
	public void testBambinoUpdate3FormatoTagliaErrato() {
		a.setAusilioMaterialeGalleggiante(false);
		a.setCertificatoMedico("wau");
		a.setCodiceFiscale("DLANTN98A13H703Y");
		a.setCognome("Dalia");
		a.setDataNascita(data.getTime());
		a.setDisabilita(false);
		a.setDocumentoIdentita("ci sta");
		a.setEsigenzeAlimentari(false);
		a.setFarmaci(null);
		a.setGenere('M');
		a.setGenitore(genitore);
		a.setInfoAllergie(null);
		a.setInfoEsigenzeAlimentari(null);
		a.setLuogoNascita("Salerno");
		a.setNome("Antonio");
		a.setTagliaIndumenti("xl");
		
		bam.save(a);
		
		a.setTagliaIndumenti("vvvvsvvsvvsvsvsvvsv");
		
		try {
			
			bam.update(a);
			fail("Dovrebbe esserci Illegal Argument Exception");
		}catch(IllegalArgumentException e) {
			
		}
	}
	
	public void testBambinoUpdate4FormatoFileErrato() {
		a.setAusilioMaterialeGalleggiante(false);
		a.setCertificatoMedico("wau");
		a.setCodiceFiscale("DLANTN98A13H703Y");
		a.setCognome("Dalia");
		a.setDataNascita(data.getTime());
		a.setDisabilita(false);
		a.setDocumentoIdentita("ci sta");
		a.setEsigenzeAlimentari(false);
		a.setFarmaci(null);
		a.setGenere('M');
		a.setGenitore(genitore);
		a.setInfoAllergie(null);
		a.setInfoEsigenzeAlimentari(null);
		a.setLuogoNascita("Salerno");
		a.setNome("Antonio");
		a.setTagliaIndumenti("xl");
		
		bam.save(a);
		
		a.setCertificatoMedico("");
		a.setDocumentoIdentita("");
		
		
		try {
			
			bam.update(a);
			fail("Dovrebbe esserci Illegal Argument Exception");
		}catch(IllegalArgumentException e) {
			
		}
		
	}
	
	
	
	
	public static Test suite() {
		return new TestSuite(BambinoManageDSTest.class);
	}

	
	private GregorianCalendar data= new GregorianCalendar(2010,0,13);
	private Genitore genitore= new Genitore();
	private Bambino a= new Bambino();
	private BambinoManageDS bam;
	private EntityManager entityManager;
	private Query query;
	private EntityTransaction transaction;
	
}
