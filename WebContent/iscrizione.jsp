<%@ page language="java" import="java.util.*,model.entity.Utente, model.entity.Bambino, model.entity.Settimana" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
List<Bambino> bambini = (List<Bambino>) request.getAttribute("bambini"); 

List<Settimana> maggio = (List<Settimana>) request.getAttribute("maggio");
List<Settimana> giugno = (List<Settimana>) request.getAttribute("giugno"); 
List<Settimana> luglio = (List<Settimana>) request.getAttribute("luglio"); 
List<Settimana> agosto = (List<Settimana>) request.getAttribute("agosto"); 
List<Settimana> settembre = (List<Settimana>) request.getAttribute("settembre"); 

String error = (String) request.getAttribute("errorMessage");

%>
<%@include file="./assets/includes/header.jsp" %>


<div class="container" style="position: relative">

		<%if(error != null) { %>
			<div class="alert alert-danger alert-dismissible fade show" role="alert">
			  <strong><%=error %></strong>
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
		<%} %> 

    	<form id="form_iscrizione" class="form-register" action="iscrizione" method="post" data-toggle="validator" role="form" enctype="multipart/form-data" novalidate>

    	  <div class="text-center mb-4">
    	    <img class="mb-4" src="assets/images/Logo_SummerCamp.png" alt="American Delights" width="250" height="200">
    	    <h1 class="h3 mb-3 font-weight-normal">Iscrizione bambino</h1>
    	  
    	  <label for="nome">Seleziona un bambino pre-esistente</label>
    	 <%
		   	if(bambini!=null) {
		   		%>
          <div class="form-label">
            <select id="bambini" class="form-control" aria-label="Default select example">
              <option value="" selected></option>
              <%for(Bambino b: bambini) {
	   				
	   				%>
              <option
              data-nome="<%=b.getNome() %>" 
              data-cogn="<%=b.getCognome() %>" 
              data-nascita="<%=b.getDataNascita() %>" 
              data-luogoNascita="<%=b.getLuogoNascita() %>" 
              data-CF="<%=b.getCodiceFiscale() %>" 
              data-genere="<%=b.getGenere() %>" 
              data-disabilita="<%=b.isDisabilita() %>"
              data-esigenze="<%=b.isEsigenzeAlimentari() %>"
              data-infoEsigenze="<%=b.getInfoEsigenzeAlimentari() %>"
              data-farmaci="<%=b.getFarmaci() %>"
              data-allergie="<%=b.getInfoAllergie() %>"
              data-taglia="<%=b.getTagliaIndumenti() %>"
              data-materialeGal="<%=b.isAusilioMaterialeGalleggiante() %>"><%=b.getNome()+" "+b.getCognome()%></option>
               <%}%>
            </select>
      	  </div>
    	  
    	  <%}%>
    	  </div>

      <div class="dati anagrafici">
        <h1 class="h5 mb-3 font-weight-normal text-center">Dati anagrafici</h1>

    	  <div class="form-label">
    	  	<label for="nome">Nome</label>
    	    <input type="text" id="nome" name="nome" class="form-control" placeholder="Nome" required autofocus>
    	    <div id="invalidNome" class="invalid-tooltip"></div>
    	  </div>

    	  <div class="form-label">
    	  	<label for="cognome">Cognome</label>
    	    <input type="text" id="cognome" name="cognome" class="form-control" placeholder="Cognome" required autofocus>
    	    <div id="invalidCognome" class="invalid-tooltip"></div>
    	  </div>

    	  <div class="form-label">
    	  	<label for="dataNascita">Data di nascita</label>
    	    <input type="date" id="dataNascita" name="dataNascita" onkeyup="controlForm(this)" class="form-control" min="2004-01-01" max="2021-01-01" required autofocus>
    	    <div id="invalidDataNascita" class="invalid-tooltip"></div>
    	  </div>

        <div class="form-label">
        	<label for="luogoNascita">Luogo di nascita</label>
    	    <input type="text" id="luogoNascita" name="luogoNascita" class="form-control" placeholder="Luogo di nascita" required autofocus>
    	    <div id="invalidLuogoNascita" class="invalid-tooltip"></div>
    	  </div>

        <div class="form-label">
        	<label for="codiceFiscale">Codice Fiscale</label>
    	    <input type="text" id="codiceFiscale" name="codiceFiscale" class="form-control" placeholder="Codice Fiscale" required autofocus>
    	    <div id="invalidCodiceFiscale" class="invalid-tooltip"></div>
    	  </div>

        <div class="form-label">
          <label for="genere">Genere</label>
          <select id="genere" name="genere" class="form-control" aria-label="Default select example" required autofocus>
            <option value="" selected>Genere</option>
            <option value="M">Maschio</option>
            <option value="F">Femmina</option>
          </select>
    	  </div>

      </div>

      <div class="esigenze">
        <h1 class="h5 mb-3 font-weight-normal text-center">Esigenze</h1>

          <div class="form-check form-switch">
            <input id="esigenze" name="esigenzeAlimentari" value="true" class="form-check-input" type="checkbox" id="esigenzeAlimentari">
            <label class="form-check-label" for="esigenzeAlimentari">Esigenze alimentari</label>
          </div>

          <div class="form-check form-switch">
            <input id="disabilita" name="disabilita" value="true" class="form-check-input" type="checkbox" id="disabilita">
            <label class="form-check-label" for="disabilita">Disabilità</label>
          </div>

          <div class="form-check form-switch">
            <input id="materialeGal" name="ausilioMaterialeGalleggiante" value="true" class="form-check-input" type="checkbox" id="ausilioMaterialeGalleggiante">
            <label class="form-check-label" for="ausilioMaterialeGalleggiante">Ausilio materiale galleggiante</label>
          </div>


          <div class="form-label">
            <div class="form-floating">
              <label for="infoEsigenzeAlimentari">Descrizione esigenze alimentari</label>
              <textarea id="infoEsigenze" name="infoEsigenzeAlimentari" class="form-control"  id="infoEsigenzeAlimentari" style="height: 100px"></textarea>
              <div id="invalidInfoEsigenzeAlimentari" class="invalid-tooltip"></div>
      	  </div>
          </div>

        <div class="form-label">
          <div class="form-floating">
            <label for="farmaci">Farmaci</label>
            <textarea id="farmaci" name="farmaci" class="form-control"  id="farmaci" style="height: 100px"></textarea>
    	  </div>
        </div>

        <div class="form-label">
          <div class="form-floating">
          <label for="allergie">Allergie</label>
          <textarea id="allergie" name="infoAllergie" class="form-control"  id="allergie" style="height: 100px"></textarea>
    	  </div>
        </div>

      </div>

      <div class="documenti">
        <h1 class="h5 mb-3 font-weight-normal text-center">Documenti</h1>

        <div class="form-label">
          <label for="documentoIdentita">Documento di identità</label>
          <input name="documentoIdentita" type="file" class="form-control-file" id="documentoIdentita" required autofocus>
        </div>

        <div class="form-label">
          <label for="certificatoMedico">Certificato medico</label>
          <input name="certificatoMedico" type="file" class="form-control-file" id="certificatoMedico" required autofocus>
        </div>

      </div>

      <div class="infoIscrizione">
        <h1 class="h5 mb-3 font-weight-normal text-center">Informazioni ai fini dell'iscrizione</h1>

        <div class="form-check form-switch">
          <input name="servizioSportivo" value="true" class="form-check-input" type="checkbox" id="servizioSportivo">
          <label class="form-check-label" for="servizioSportivo">Servizio sportivo</label>
        </div>

        <div class="form-label">
          <label for="tagliaIndumenti">Taglia indumenti</label>
          <select id="taglia" name="tagliaIndumenti" class="form-control" aria-label="Default select example" required autofocus>
            <option value="" selected>Taglia indumenti</option>
            <option value="XS">XS</option>
            <option value="S">S</option>
            <option value="M">M</option>
            <option value="L">L</option>
            <option value="XL">XL</option>
          </select>
    	  </div>

        <div class="form-label">
       	  <label for="tipoSoggiorno">Tipo soggiorno</label>
          <select name="tipoSoggiorno" class="form-control" aria-label="Default select example" required autofocus>
            <option value="" selected>Tipo soggiorno</option>
            <option value="Part-Time">Part-Time</option>
            <option value="Full-Time">Full-Time</option>
          </select>
    	  </div>

        <h1 class="h5 mb-3 font-weight-normal text-center">Seleziona periodo di soggiorno</h1>
        
      
        <div class="card-body">
          <div class="accordion" id="accordionExample">
          
          <!-- Maggio -->
          <%if(maggio.size()!=0) {	%>
          <div class="card-header" id="HeadingMaggio">
                <h2 class="mb-0">
                  <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#Maggio" aria-controls="Maggio">
                    Maggio
                  </button>
                </h2>
          </div>
          
          <div id="Maggio" class="collapse" aria-labelledby="HeadingMaggio" data-parent="#accordionExample">
                <div class="card-body">
                	<%
                	for(Settimana s: maggio) {
                		
                	%>
                	
                	<div class="form-check">
                		<input name="settimane" value="<%=s.getIdSettimana()%>" class="form-check-input" type="checkbox" id="<%=s.getIdSettimana()%>">
                		<label class="form-check-label" for="<%=s.getIdSettimana()%>">
                  			Data inizio: <%=s.getDataInizio()%> 
                  			<br>
                  			Data fine: <%=s.getDataFine()%>
                  			<br>
                  			Posti disponibili: <%=s.getDisponibilita()%>
                		</label>
             		</div>
             		 <%}%>
             		</div>
             		
             	</div>
             	<%}%>
             	
          <!-- Giugno -->
          <%if(giugno.size()!=0) {	%>
          <div class="card-header" id="HeadingGiugno">
                <h2 class="mb-0">
                  <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#Giugno" aria-controls="Giugno">
                    Giugno
                  </button>
                </h2>
          </div>
          
          <div id="Giugno" class="collapse" aria-labelledby="HeadingGiugno" data-parent="#accordionExample">
                <div class="card-body">
                	<%
                	for(Settimana s: giugno) {
                		
                	%>
                	
                	<div class="form-check">
                		<input name="settimane" value="<%=s.getIdSettimana()%>" class="form-check-input" type="checkbox" value="" id="<%=s.getIdSettimana()%>">
                		<label class="form-check-label" for="<%=s.getIdSettimana()%>">
                  			Data inizio: <%=s.getDataInizio()%> 
                  			<br>
                  			Data fine: <%=s.getDataFine()%>
                  			<br>
                  			Posti disponibili: <%=s.getDisponibilita()%>
                		</label>
             		</div>
             		 <%}%>
             		</div>
             		
             	</div>
             	<%}%>
             	
          <!-- Luglio -->
          <%if(luglio.size()!=0) {	%>
          <div class="card-header" id="HeadingLuglio">
                <h2 class="mb-0">
                  <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#Luglio" aria-controls="Luglio">
                    Luglio
                  </button>
                </h2>
          </div>
          
          <div id="Luglio" class="collapse" aria-labelledby="HeadingLuglio" data-parent="#accordionExample">
                <div class="card-body">
                	<%
                	for(Settimana s: luglio) {
                		
                	%>
                	
                	<div class="form-check">
                		<input name="settimane" value="<%=s.getIdSettimana()%>" class="form-check-input" type="checkbox" value="" id="<%=s.getIdSettimana()%>">
                		<label class="form-check-label" for="<%=s.getIdSettimana()%>">
                  			Data inizio: <%=s.getDataInizio()%> 
                  			<br>
                  			Data fine: <%=s.getDataFine()%>
                  			<br>
                  			Posti disponibili: <%=s.getDisponibilita()%>
                		</label>
             		</div>
             		 <%}%>
             		</div>
             		
             	</div>
             	<%}%>
             	
          <!-- Agosto -->
          <%if(agosto.size()!=0) {	%>
          <div class="card-header" id="HeadingAgosto">
                <h2 class="mb-0">
                  <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#Agosto" aria-controls="Agosto">
                    Agosto
                  </button>
                </h2>
          </div>
          
          <div id="Agosto" class="collapse" aria-labelledby="HeadingAgosto" data-parent="#accordionExample">
                <div class="card-body">
                	<%
                	for(Settimana s: agosto) {
                		
                	%>
                	
                	<div class="form-check">
                		<input name="settimane" value="<%=s.getIdSettimana()%>" class="form-check-input" type="checkbox" value="" id="<%=s.getIdSettimana()%>">
                		<label class="form-check-label" for="<%=s.getIdSettimana()%>">
                  			Data inizio: <%=s.getDataInizio()%> 
                  			<br>
                  			Data fine: <%=s.getDataFine()%>
                  			<br>
                  			Posti disponibili: <%=s.getDisponibilita()%>
                		</label>
             		</div>
             		 <%}%>
             		</div>
             		
             	</div>
             	<%}%>
             	
          <!-- Settembre -->
          <%if(settembre.size()!=0) {	%>
          <div class="card-header" id="HeadingSettembre">
                <h2 class="mb-0">
                  <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#Settembre" aria-controls="Settembre">
                    Settembre
                  </button>
                </h2>
          </div>
          
          <div id="Settembre" class="collapse" aria-labelledby="HeadingSettembre" data-parent="#accordionExample">
                <div class="card-body">
                	<%
                	for(Settimana s: settembre) {
                		
                	%>
                	
                	<div class="form-check">
                		<input name="settimane" value="<%=s.getIdSettimana()%>" class="form-check-input" type="checkbox" value="" id="<%=s.getIdSettimana()%>">
                		<label class="form-check-label" for="<%=s.getIdSettimana()%>">
                  			Data inizio: <%=s.getDataInizio()%> 
                  			<br>
                  			Data fine: <%=s.getDataFine()%>
                  			<br>
                  			Posti disponibili: <%=s.getDisponibilita()%>
                		</label>
             		</div>
             		 <%}%>
             		</div>
             		
             	</div>
             	<%}%>
             	
             </div>
            </div>
</div>     	
                   
          
          	

      <div class="BUTTON">
    	  <button class="btn btn-lg btn-primary btn-block center" type="submit">Iscrivi bambino</button>
        <p class="mt-5 mb-3 text-muted text-center">&copy; 2020-2021</p>

      </div>
    </form>

  </div>
  
	<%@include file="./assets/includes/footer.jsp" %>
	<script src="./assets/js/iscrizione.js"></script>
	</body>
</html>