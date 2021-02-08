package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.sql.DataSource;

import listener.LocalEntityManagerFactory;
import model.entity.Genitore;
import model.entity.Utente;

public class UtenteManageDS implements UtenteManage {

	
	public UtenteManageDS() {
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

	/*public void addUtente(Utente u) {
		/*Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + UtenteManageDS.TABLE_NAME
				+ " (codiceFiscaleUtente, nome, cognome, email, dataNascita, genere, ruolo, password, luogoNascita, "
				+ "indirizzo, citta, cap, professione, numTelefono, numTelefonoSecondario, documentoIdentita, consensoInfo"
				+ "consensoImgEVideo, delega, infoFamiliari)"
				+ " VALUES (?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, u.getCodiceFiscale());
			preparedStatement.setString(2, u.getNome());
			preparedStatement.setString(3, u.getCognome());
			preparedStatement.setString(4, u.getEmail());

			preparedStatement.executeUpdate();

			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		
	}*/
	
	@Override
	public Utente getUserIfExists(String email, String password) throws NoResultException {
		try {
			return (Utente) em.createQuery("SELECT u FROM Utente u WHERE email=:email AND password=:password")
					.setParameter("email", email).setParameter("password", password).getSingleResult();
		} catch(NoResultException e) {
			return null;
		} finally {
			close();
		} 
	}
	
	public void save(Utente u) throws PersistenceException {
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
	}
	
	private static final String TABLE_NAME = "utente";
	
	private EntityManager em;

}
