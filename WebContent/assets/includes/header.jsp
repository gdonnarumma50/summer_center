<%@ page language="java" import="java.util.*,model.entity.Utente" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
// Check user credentials
Utente utente = (Utente) request.getSession(false).getAttribute("utente");

boolean auth;

if (utente == null)
{	
    auth = false;
}
else {
	auth = true;
}

%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>Summer Center</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

    <!-- Our Custom CSS -->
    <link rel="stylesheet" href="assets/css/style.css">
    <!-- Scrollbar Custom CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css">

    <!-- Font Awesome JS -->
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>

</head>

<body>

    <div class="wrapper">
        <!-- Sidebar  -->
        <nav id="sidebar">
            <div id="dismiss">
                <i class="fas fa-arrow-left"></i>
            </div>

            <div class="sidebar-header">
                <img class="mb-4" src="assets/images/Logo_SummerCamp.png" alt=">Summer Center" width="200" height="150">
            </div>

            <ul class="list-unstyled components">
             <% if(!auth) { %>
            
                <li class="active">
                    <a href="${pageContext.request.contextPath}/index.jsp" data-toggle="collapse" aria-expanded="false">Login</a>
                </li>
                
            <%}%>
            <% if(auth) { %>
            
                <p>
                <%= utente.getNome()+" "+utente.getCognome() %>
                </p>
                
                 <li class="active">
                    <a href="${pageContext.request.contextPath}/dashboard.jsp">Dashboard</a>
                </li>
                <li>
                <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false">Iscrizione</a>
                    <ul class="collapse list-unstyled" id="pageSubmenu">
                        <li>
                            <a href="${pageContext.request.contextPath}/iscrizione">Effettua iscrizione</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/list_iscrizioni">Visualizza iscrizioni</a>
                        </li>
                    </ul>
                </li>
                <%}%>
                </li>
            </ul>
        </nav>

        <!-- Navbar  -->
        <div id="content">

          <nav class="navbar navbar-expand-lg navbar-light bg-light">
              <div class="container-fluid">

                  <button type="button" id="sidebarCollapse" class="btn btn">
                      <i class="fas fa-align-left"></i>
                      <span>Menù</span>
                  </button>
                  <button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                      <i class="fas fa-align-justify"></i>
                  </button>

                  <div class="collapse navbar-collapse" id="navbarSupportedContent">
                      <ul class="nav navbar-nav ml-auto">
                      <% if(auth) { %>
                          <li class="nav-item">
                              <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
                          </li>
                      <%}%>
                      <% if(auth!=true) { %>
                          <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/index.jsp">
                              <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                                <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                                <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                              </svg>
                            </a>
                          </li>
                      <%}%>
                          <li class="nav-item">
                            <a class="nav-link" href="#">
                              <svg xmlns="http://www.w3.org/2000/svg" width=25 height="25" fill="currentColor" class="bi bi-cart-plus" viewBox="0 0 16 16">
                                <path d="M9 5.5a.5.5 0 0 0-1 0V7H6.5a.5.5 0 0 0 0 1H8v1.5a.5.5 0 0 0 1 0V8h1.5a.5.5 0 0 0 0-1H9V5.5z"></path>
                                <path d="M.5 1a.5.5 0 0 0 0 1h1.11l.401 1.607 1.498 7.985A.5.5 0 0 0 4 12h1a2 2 0 1 0 0 4 2 2 0 0 0 0-4h7a2 2 0 1 0 0 4 2 2 0 0 0 0-4h1a.5.5 0 0 0 .491-.408l1.5-8A.5.5 0 0 0 14.5 3H2.89l-.405-1.621A.5.5 0 0 0 2 1H.5zm3.915 10L3.102 4h10.796l-1.313 7h-8.17zM6 14a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm7 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0z"></path>
                              </svg>
                            </a>
                          </li>
                      </ul>
                  </div>
              </div>
          </nav>