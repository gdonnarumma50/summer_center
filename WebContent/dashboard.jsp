<%@ page language="java" import="java.util.*,model.entity.Utente" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Utente u = (Utente) request.getSession(false).getAttribute("utente");
%>
<%@include file="./assets/includes/header.jsp" %>

	<div class="dashboard">
	
	<h1 class="h2 mb-4 font-weight-normal text-center">Bentornato <%=u.getNome()%></h1>

	<div class="card-deck">
	  <div class="card">
	    <img src="./assets/images/user.png" class="card-img-top" alt="...">
	    <div class="card-body">
	      <h5 class="card-title">I miei dati</h5>
	      <p class="card-text">
	      Nominativo: <%=u.getNome()+" "+u.getCognome()%> <br>
	      Codice Fiscale: <%=u.getCodiceFiscale()%><br>
	      Data di nascita: <%=u.getDataNascita()%><br>
	      Genere: <%=u.getGenere()%>
	      </p>
	    </div>
	  </div>
	  <div class="card">
	    <img src="./assets/images/mappa.png" class="card-img-top" alt="...">
	    <div class="card-body">
	      <h5 class="card-title">Dati del centro</h5>
	      <p class="card-text">
	      IBAN: IT12235786162274628489718S<br>
	      P.Iva: 0412341
	      </p>
	    </div>
	  </div>
	  <div class="card">
	    <img src="./assets/images/iscrizione.png" class="card-img-top" alt="...">
	    <div class="card-body">
	      <h5 class="card-title">Iscrizioni</h5>
	      <p class="card-text">
	      <a href="${pageContext.request.contextPath}/iscrizione">Effettua iscrizione</a> <br>
	      <a href="${pageContext.request.contextPath}/list_iscrizioni">Visualizza iscrizioni</a>
	      </p>
	    </div>
	  </div>
	</div>
	
	</div>
	
<%@include file="./assets/includes/footer.jsp" %>