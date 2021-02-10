<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*,model.entity.Iscrizione, model.entity.Bambino, control.gestioneIscrizione.VisualizzaIscrizioniControl"
	pageEncoding="UTF-8"%>

<%
	Collection<Iscrizione> list = (Collection<Iscrizione>) request.getAttribute("iscrizioni");
%>

<%@include file="./assets/includes/header.jsp" %>
<link rel="stylesheet" href="assets/css/order_list.css">

  </head>

  <body>

    <div class="container">

      <p class="text-left font-weight-bold">Le mie iscrizioni</p>

	<% if(list != null) { %>
      <div class="row">
        <div class="col-lg-12">
          <div class="table-responsive-sm">
          <table class="table table-hover">
            <thead class="thead-dark">
              <tr>
                <th scope="col">#</th>
                <th scope="col">Codice iscrizione</th>
                <th scope="col">Data iscrizione</th>
                <th scope="col">Bambino</th>
                <th scope="col">Settimana/e</th>
                <th scope="col">Prezzo</th>
                <th scope="col">Pagata</th>
                <th scope="col">Disdetta</th>
                <th scope="col">Mostra Ordine</th>
              </tr>
            </thead>
            <tbody>
            <%
            int i=1;
            for(Iscrizione isc: list) { %>
              <tr>
                <th scope="row">Ordine numero <%= i %></th>
                <td><%=isc.getIdIscrizione()%></td>
                <td><%=isc.getDataIscrizione()%></td>
                <td><%=isc.getBambino()%></td>
                <td><%=isc.getSettimane()%></td>
                <td><%=isc.getPrezzo()%></td>
                <td><%=isc.isPagata()%></td>
                <td><%=isc.isRichiestaDisdetta()%></td>
                <td>
                  <svg width="2em" height="3em" viewBox="0 0 16 16" class="bi bi-file-earmark-text" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                    <path d="M4 1h5v1H4a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V6h1v7a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2z"/>
                    <path d="M9 4.5V1l5 5h-3.5A1.5 1.5 0 0 1 9 4.5z"/>
                    <path fill-rule="evenodd" d="M5 11.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 0 1h-2a.5.5 0 0 1-.5-.5zm0-2a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm0-2a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5z"/>
                  </svg>
                </td>
              </tr>
              <% i=i+1; } %>
            </tbody>
          </table>
        </div>
        </div>
    </div>
    <% } %>
   </div>

<%@include file="./assets/includes/footer.jsp" %>

  </body>
</html>
