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
		a.setCertificatoMedico("cert.pdf");
		a.setCodiceFiscale("RSSGLC10R10H703N");
		a.setCognome("Rossi");
		a.setDataNascita(data.getTime());
		a.setDisabilita(false);
		a.setDocumentoIdentita("doc.pdf");
		a.setEsigenzeAlimentari(false);
		a.setFarmaci(null);
		a.setGenere('M');
		a.setGenitore(genitore);
		a.setInfoAllergie(null);
		a.setInfoEsigenzeAlimentari(null);
		a.setLuogoNascita("Salerno");
		a.setNome("Gianluca");
		a.setTagliaIndumenti("s");
		
		bam.save(a);
		
	}
	
	
	public void testBambino2ConOpzionali() {
		a.setAusilioMaterialeGalleggiante(true);
		a.setCertificatoMedico("cert.pdf");
		a.setCodiceFiscale("RSSGLC10R10H703N");
		a.setCognome("Rossi");
		a.setDataNascita(data.getTime());
		a.setDisabilita(false);
		a.setDocumentoIdentita("ci sta.pdf");
		a.setEsigenzeAlimentari(true);
		a.setFarmaci("si");
		a.setGenere('M');
		a.setGenitore(genitore);
		a.setInfoAllergie("si");
		a.setInfoEsigenzeAlimentari("Pane e acqua");
		a.setLuogoNascita("Salerno");
		a.setNome("Gianluca");
		a.setTagliaIndumenti("s");
		
		bam.save(a);
		
	}
	
	public void testBambino3FormatoFileErrato() {
		a.setAusilioMaterialeGalleggiante(false);
		a.setCertificatoMedico("cert.ppt");
		a.setCodiceFiscale("RSSGLC10R10H703N");
		a.setCognome("Rossi");
		a.setDataNascita(data.getTime());
		a.setDisabilita(false);
		a.setDocumentoIdentita("doc.xml");
		a.setEsigenzeAlimentari(false);
		a.setFarmaci(null);
		a.setGenere('M');
		a.setGenitore(genitore);
		a.setInfoAllergie(null);
		a.setInfoEsigenzeAlimentari(null);
		a.setLuogoNascita("Salerno");
		a.setNome("Gianluca");
		a.setTagliaIndumenti("s");
		
		
		
		try {
			bam.save(a);
			fail("Dovrebbe esserci Illegal Argument Exception");
		}catch(IllegalArgumentException e) {
			
		}
		
	}
	
	public void testBambino4FormatoCFErrato() {
		a.setAusilioMaterialeGalleggiante(false);
		a.setCertificatoMedico("cert.pdf");
		a.setCodiceFiscale("RSSGLC10R10H703");
		a.setCognome("Rossi");
		a.setDataNascita(data.getTime());
		a.setDisabilita(false);
		a.setDocumentoIdentita("doc.pdf");
		a.setEsigenzeAlimentari(false);
		a.setFarmaci(null);
		a.setGenere('M');
		a.setGenitore(genitore);
		a.setInfoAllergie(null);
		a.setInfoEsigenzeAlimentari(null);
		a.setLuogoNascita("Salerno");
		a.setNome("Gianluca");
		a.setTagliaIndumenti("s");
		
		
		
	  try {
			
			bam.save(a);
			fail("Dovrebbe esserci Illegal Argument Exception");
		}catch(IllegalArgumentException e) {
			
		}
		
	}
	
	public void testBambino5FormatoNomeErrato() {
		a.setAusilioMaterialeGalleggiante(false);
		a.setCertificatoMedico("cert.pdf");
		a.setCodiceFiscale("RSSGLC10R10H703N");
		a.setCognome("Rossi");
		a.setDataNascita(data.getTime());
		a.setDisabilita(false);
		a.setDocumentoIdentita("doc.pdf");
		a.setEsigenzeAlimentari(false);
		a.setFarmaci(null);
		a.setGenere('M');
		a.setGenitore(genitore);
		a.setInfoAllergie(null);
		a.setInfoEsigenzeAlimentari(null);
		a.setLuogoNascita("Salerno");
		a.setNome("Gianluca2");
		a.setTagliaIndumenti("s");
		
		
		try {
		
			bam.save(a);
			fail("Dovrebbe esserci Illegal Argument Exception");
		}catch(IllegalArgumentException e) {
			
		}
		
	}
	
	public void testBambino6FormatoCognomeErrato() {
		a.setAusilioMaterialeGalleggiante(false);
		a.setCertificatoMedico("cert.pdf");
		a.setCodiceFiscale("RSSGLC10R10H703N");
		a.setCognome("Rossi4");
		a.setDataNascita(data.getTime());
		a.setDisabilita(false);
		a.setDocumentoIdentita("doc.pdf");
		a.setEsigenzeAlimentari(false);
		a.setFarmaci(null);
		a.setGenere('M');
		a.setGenitore(genitore);
		a.setInfoAllergie(null);
		a.setInfoEsigenzeAlimentari(null);
		a.setLuogoNascita("Salerno");
		a.setNome("Gianluca");
		a.setTagliaIndumenti("s");
		
		
		
		try {
		
			bam.save(a);
			fail("Dovrebbe esserci Illegal Argument Exception");
		}catch(IllegalArgumentException e) {
			
		}
		
	}
	public void testBambino7FormatoLNErrato() {
		a.setAusilioMaterialeGalleggiante(false);
		a.setCertificatoMedico("cert.pdf");
		a.setCodiceFiscale("RSSGLC10R10H703N");
		a.setCognome("Rossi");
		a.setDataNascita(data.getTime());
		a.setDisabilita(false);
		a.setDocumentoIdentita("doc.pdf");
		a.setEsigenzeAlimentari(false);
		a.setFarmaci(null);
		a.setGenere('M');
		a.setGenitore(genitore);
		a.setInfoAllergie(null);
		a.setInfoEsigenzeAlimentari(null);
		a.setLuogoNascita("Salerno111");
		a.setNome("Gianluca");
		a.setTagliaIndumenti("s");
		
		
		
			try {
				bam.save(a);
				fail("Dovrebbe esserci Illegal Argument Exception");
		}catch(IllegalArgumentException e) {
				
	  }
	
	}
	
	
	public void testBambino8DNNonInserita() {
		a.setAusilioMaterialeGalleggiante(false);
		a.setCertificatoMedico("cert.pdf");
		a.setCodiceFiscale("RSSGLC10R10H703N");
		a.setCognome("Rossi");
		a.setDisabilita(false);
		a.setDocumentoIdentita("doc.pdf");
		a.setEsigenzeAlimentari(false);
		a.setFarmaci(null);
		a.setGenere('M');
		a.setGenitore(genitore);
		a.setInfoAllergie(null);
		a.setInfoEsigenzeAlimentari(null);
		a.setLuogoNascita("Salerno");
		a.setNome("Gianluca");
		a.setTagliaIndumenti("s");
		
		
		
			try {
				bam.save(a);
				fail("Dovrebbe esserci Illegal Argument Exception");
			}catch(IllegalArgumentException e) {
				
		}
		
	}
	
	public void testBambino9TagliaNonIndicata() {
		a.setAusilioMaterialeGalleggiante(false);
		a.setCertificatoMedico("cert.pdf");
		a.setCodiceFiscale("RSSGLC10R10H703N");
		a.setCognome("Rossi");
		a.setDataNascita(data.getTime());
		a.setDisabilita(false);
		a.setDocumentoIdentita("doc.pdf");
		a.setEsigenzeAlimentari(false);
		a.setFarmaci(null);
		a.setGenere('M');
		a.setGenitore(genitore);
		a.setInfoAllergie(null);
		a.setInfoEsigenzeAlimentari(null);
		a.setLuogoNascita("Salerno");
		a.setNome("Gianluca");
		a.setTagliaIndumenti("");
		
		
		try {
		
			bam.save(a);
			fail("Dovrebbe esserci Illegal Argument Exception");
		}catch(IllegalArgumentException e) {
			
		}
		
	}
	
	public void testBambinoUpdate1Precompilati() {
		a.setAusilioMaterialeGalleggiante(false);
		a.setCertificatoMedico("cert.pdf");
		a.setCodiceFiscale("RSSGLC10R10H703N");
		a.setCognome("Rossi");
		a.setDataNascita(data.getTime());
		a.setDisabilita(false);
		a.setDocumentoIdentita("doc.pdf");
		a.setEsigenzeAlimentari(false);
		a.setFarmaci(null);
		a.setGenere('M');
		a.setGenitore(genitore);
		a.setInfoAllergie(null);
		a.setInfoEsigenzeAlimentari(null);
		a.setLuogoNascita("Salerno");
		a.setNome("Gianluca");
		a.setTagliaIndumenti("s");
		
		
		try {
			
			bam.save(a);
		}catch(IllegalArgumentException e) {
			
		}
		
	}
	
	public void testBambinoUpdate2ModificaParametriObbligatori() {
		a.setAusilioMaterialeGalleggiante(false);
		a.setCertificatoMedico("cert.pdf");
		a.setCodiceFiscale("RSSGLC10R10H703N");
		a.setCognome("Rossi");
		a.setDataNascita(data.getTime());
		a.setDisabilita(false);
		a.setDocumentoIdentita("doc.pdf");
		a.setEsigenzeAlimentari(false);
		a.setFarmaci(null);
		a.setGenere('M');
		a.setGenitore(genitore);
		a.setInfoAllergie(null);
		a.setInfoEsigenzeAlimentari(null);
		a.setLuogoNascita("Salerno");
		a.setNome("Gianluca");
		a.setTagliaIndumenti("s");
		
		bam.save(a);
		
		a.setCertificatoMedico("cert1.pdf");
		a.setDocumentoIdentita("doc1.pdf");
		a.setTagliaIndumenti("m");
		
		
		try {
			
			bam.update(a);
		}catch(IllegalArgumentException e) {
			
		}
		
	}
	
	public void testBambinoUpdate3ModificaParametriNonObbligatori() {
		a.setAusilioMaterialeGalleggiante(false);
		a.setCertificatoMedico("cert.pdf");
		a.setCodiceFiscale("RSSGLC10R10H703N");
		a.setCognome("Rossi");
		a.setDataNascita(data.getTime());
		a.setDisabilita(false);
		a.setDocumentoIdentita("doc.pdf");
		a.setEsigenzeAlimentari(false);
		a.setFarmaci(null);
		a.setGenere('M');
		a.setGenitore(genitore);
		a.setInfoAllergie(null);
		a.setInfoEsigenzeAlimentari(null);
		a.setLuogoNascita("Salerno");
		a.setNome("Gianluca");
		a.setTagliaIndumenti("s");
		
		bam.save(a);
		
		a.setInfoEsigenzeAlimentari("Pane e acqua");
		a.setAusilioMaterialeGalleggiante(true);
		a.setEsigenzeAlimentari(true);
		a.setTagliaIndumenti("m");
		
		try {
			
			bam.update(a);
		}catch(IllegalArgumentException e) {
			
		}
		
	}
	
	public void testBambinoUpdate4ModificaParametriTagliaNonIndicata() {
		a.setAusilioMaterialeGalleggiante(false);
		a.setCertificatoMedico("cert.pdf");
		a.setCodiceFiscale("RSSGLC10R10H703N");
		a.setCognome("Rossi");
		a.setDataNascita(data.getTime());
		a.setDisabilita(false);
		a.setDocumentoIdentita("doc.pdf");
		a.setEsigenzeAlimentari(false);
		a.setFarmaci(null);
		a.setGenere('M');
		a.setGenitore(genitore);
		a.setInfoAllergie(null);
		a.setInfoEsigenzeAlimentari(null);
		a.setLuogoNascita("Salerno");
		a.setNome("Gianluca");
		a.setTagliaIndumenti("s");
		
		bam.save(a);
		
		a.setTagliaIndumenti(null);
		
		
		try {
			
			bam.update(a);
		}catch(IllegalArgumentException e) {
			
		}
		
	}
	
	public void testBambinoUpdate5FormatoFileErrato() {
		a.setAusilioMaterialeGalleggiante(false);
		a.setCertificatoMedico("cert.pdf");
		a.setCodiceFiscale("RSSGLC10R10H703N");
		a.setCognome("Rossi");
		a.setDataNascita(data.getTime());
		a.setDisabilita(false);
		a.setDocumentoIdentita("doc.pdf");
		a.setEsigenzeAlimentari(false);
		a.setFarmaci(null);
		a.setGenere('M');
		a.setGenitore(genitore);
		a.setInfoAllergie(null);
		a.setInfoEsigenzeAlimentari(null);
		a.setLuogoNascita("Salerno");
		a.setNome("Gianluca");
		a.setTagliaIndumenti("s");
		
		bam.save(a);
		
		a.setCertificatoMedico("doc.xml");
		a.setDocumentoIdentita("cert.ppt");
		
		
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
