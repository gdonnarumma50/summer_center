package model.daoTest;

import junit.framework.*;
import junit.textui.TestRunner;


public class AllTests extends TestSuite{

	/*
	 * Ho modificato l'aspetto di questa classe allTests rispetto a quella indicata poichè 
	 * non era possibile seguire il pattern iniziale(errori di vario tipo, non eseguibilità della suite)
	 */
	
	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
		suite.addTest(BambinoManageDSTest.suite());
		suite.addTest(IscrizioneManageDSTest.suite());
		suite.addTest(UtenteManageDSTest.suite());
		return suite;
	}
	
	public static TestSuite suite;
	
	
	public static void main(String args[]) {
		
		TestRunner.run(suite);
	}
}
