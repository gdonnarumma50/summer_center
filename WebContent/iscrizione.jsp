<%@ page language="java" import="java.util.*,model.entity.Utente, model.entity.Bambino, model.entity.Settimana" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
List<Bambino> bambini = (List<Bambino>) request.getAttribute("bambini"); 
List<Settimana> settimane = (List<Settimana>) request.getAttribute("settimane"); 

%>
<%@include file="./assets/includes/header.jsp" %>


<div class="container" style="position: relative">

    	<form id="form_register" class="form-register" action="registrazione" method="post" data-toggle="validator" role="form">

    	  <div class="text-center mb-4">
    	    <img class="mb-4" src="assets/images/Logo_SummerCamp.png" alt="American Delights" width="250" height="200">
    	    <h1 class="h3 mb-3 font-weight-normal">Iscrizione bambino</h1>
    	  
    	 <%
		   	if(bambini!=null) {
		   		%>
          <div class="form-label-group">
            <select class="form-control" aria-label="Default select example" required autofocus>
              <option selected>Seleziona bambino pre-esistente</option>
              <%for(Bambino b: bambini) {
	   				
	   				%>
              <option value="b.getCodiceFiscale()"><%=b.getNome()+" "+b.getCognome()%></option>
               <%}%>
            </select>
      	  </div>
    	  
    	  <%}%>
    	  </div>

      <div class="dati anagrafici">
        <h1 class="h5 mb-3 font-weight-normal">Dati anagrafici</h1>

    	  <div class="form-label-group">
    	    <input type="text" id="nome" name="nome" onkeyup="controlForm(this)" class="form-control" placeholder="Nome" required autofocus>
    	    <label for="nome">Nome</label>
    	    <div id="invalidNome" class="invalid-tooltip"></div>
    	  </div>

    	  <div class="form-label-group">
    	    <input type="text" id="cognome" name="cognome" onkeyup="controlForm(this)" class="form-control" placeholder="Cognome" required autofocus>
    	    <label for="cognome">Cognome</label>
    	    <div id="invalidCognome" class="invalid-tooltip"></div>
    	  </div>

    	  <div class="form-label-group">
    	    <input type="date" id="dataNascita" name="dataNascita" onkeyup="controlForm(this)" class="form-control" max="2003-01-01" required autofocus>
    	    <label for="dataNascita">Data di nascita</label>
    	  </div>

        <div class="form-label-group">
    	    <input type="text" id="luogoNascita" name="luogoNascita" onkeyup="controlForm(this)" class="form-control" placeholder="Luogo di nascita" required autofocus>
    	    <label for="luogoNascita">Luogo di nascita</label>
    	    <div id="invalidLuogoNascita" class="invalid-tooltip"></div>
    	  </div>

        <div class="form-label-group">
    	    <input type="text" id="codiceFiscale" name="codiceFiscale" onkeyup="controlForm(this)" class="form-control" placeholder="Codice Fiscale" required autofocus>
    	    <label for="codiceFiscale">Codice Fiscale</label>
    	    <div id="invalidCodiceFiscale" class="invalid-tooltip"></div>
    	  </div>

        <div class="form-label-group">
          <select class="form-control" aria-label="Default select example" required autofocus>
            <option selected>Genere</option>
            <option value="M">Maschio</option>
            <option value="F">Femmina</option>
          </select>
    	  </div>

      </div>

      <div class="esigenze">
        <h1 class="h5 mb-3 font-weight-normal">Esigenze</h1>

          <div class="form-check form-switch">
            <input class="form-check-input" type="checkbox" id="esigenzeAlimentari">
            <label class="form-check-label" for="esigenzeAlimentari">Esigenze alimentari</label>
          </div>

          <div class="form-check form-switch">
            <input class="form-check-input" type="checkbox" id="disabilita">
            <label class="form-check-label" for="disabilita">Disabilità</label>
          </div>

          <div class="form-check form-switch">
            <input class="form-check-input" type="checkbox" id="ausilioMaterialeGalleggiante">
            <label class="form-check-label" for="ausilioMaterialeGalleggiante">Ausilio materiale galleggiante</label>
          </div>


          <div class="form-label-group">
            <div class="form-floating">
              <label for="infoEsigenzeAlimentari">Descrizione esigenze alimentari</label>
              <textarea class="form-control"  id="infoEsigenzeAlimentari" style="height: 100px"></textarea>
      	  </div>
          </div>

        <div class="form-label-group">
          <div class="form-floating">
            <label for="farmaci">Farmaci</label>
            <textarea class="form-control"  id="farmaci" style="height: 100px"></textarea>
    	  </div>
        </div>

        <div class="form-label-group">
          <div class="form-floating">
          <label for="allergie">Allergie</label>
          <textarea class="form-control"  id="allergie" style="height: 100px"></textarea>
    	  </div>
        </div>

      </div>

      <div class="documenti">
        <h1 class="h5 mb-3 font-weight-normal">Documenti</h1>

        <div class="form-label">
          <label for="documentoIdentita">Documento di identità</label>
          <input type="file" class="form-control-file" id="documentoIdentita" required autofocus>
        </div>

        <div class="form-label">
          <label for="certificatoMedico">Certificato medico</label>
          <input type="file" class="form-control-file" id="certificatoMedico" required autofocus>
        </div>

      </div>

      <div class="infoIscrizione">
        <h1 class="h5 mb-3 font-weight-normal">Informazioni ai fini dell'iscrizione</h1>

        <div class="form-check form-switch">
          <input class="form-check-input" type="checkbox" id="servizioSportivo" required autofocus>
          <label class="form-check-label" for="servizioSportivo">Servizio sportivo</label>
        </div>

        <div class="form-label-group">
          <select class="form-control" aria-label="Default select example" required autofocus>
            <option selected>Taglia indumenti</option>
            <option value="1">XS</option>
            <option value="2">S</option>
            <option value="3">M</option>
            <option value="4">L</option>
            <option value="5">XL</option>
          </select>
    	  </div>

        <div class="form-label-group">
          <select title="prova" class="form-control" aria-label="Default select example" required autofocus>
            <option not selected>Tipo soggiorno</option>
            <option value="1">Part-time</option>
            <option value="2">Full-time</option>
          </select>
    	  </div>

        <h1 class="h5 mb-3 font-weight-normal">Seleziona periodo di soggiorno</h1>
        <!--  Maggio -->
        <div class="accordion" id="accordionExample">
        <div class="card">
          <div class="card-header" id="headingOne">
            <h2 class="mb-0">
              <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseOne"  aria-controls="collapseOne">
                Maggio
              </button>
            </h2>
          </div>

          <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
            <div class="card-body">
              <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                <label class="form-check-label" for="defaultCheck1">
                  01/05/2021 - 06/05/2021 Posti disponibili: 70
                </label>
              </div>
            </div>
          </div>
        </div>

        <div class="card">
          <div class="card-header" id="headingTwo">
            <h2 class="mb-0">
              <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-controls="collapseTwo">
                Giugno
              </button>
            </h2>
          </div>
          <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
            <div class="card-body">
              <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                <label class="form-check-label" for="defaultCheck1">
                  01/05/2021 - 06/05/2021 Posti disponibili: 70
                </label>
              </div>
            </div>
          </div>
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