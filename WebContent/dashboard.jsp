<%@ page language="java" import="java.util.*,model.entity.Utente" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
Utente utente = (Utente) request.getSession(false).getAttribute("utente");
if(utente==null) {
	response.sendRedirect("./");
}
%>
<%@include file="./assets/includes/header.jsp" %>
<%@include file="./assets/includes/footer.jsp" %>