<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="./assets/includes/header.jsp" %>
<%
if(utente != null) {
	response.sendRedirect(request.getContextPath()+"/dashboard.jsp");
}
%>
	<div class="container" style="position: relative">
	
	<%
	String error = (String) request.getAttribute("errorMessage");
	if(error!=null) { 
	%>
		<div class="alert alert-danger alert-dismissible fade show" role="alert">
		  <strong><%=error%></strong>
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
	<% } %>
	    	<form id="form_login" class="form-signin" action="login" method="post" data-toggle="validator" role="form">
	
	   	  <div class="text-center mb-4">
	   	    <img class="mb-4" src="assets/images/Logo_SummerCamp.png" alt="Summer Center" width="250" height="200">
	   	    <h1 class="h3 mb-3 font-weight-normal">Login</h1>
	   	  </div>
	
	     <div class="form-label-group">
	       <input type="text" name="email" id="email" class="form-control" placeholder="Email" required>
	       <label for="username">Email</label>
	     </div>
	
	     <div class="form-label-group">
	       <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
	       <label for="password">Password</label>
	     </div>
	
	
	     <button id="bottone" class="btn btn-lg btn-primary btn-block" type="submit">Accedi</button>
	     <p class="mt-5 mb-3 text-muted text-center">&copy; 2020-2021</p>
	   </form>
	</div>
<%@include file="./assets/includes/footer.jsp" %>