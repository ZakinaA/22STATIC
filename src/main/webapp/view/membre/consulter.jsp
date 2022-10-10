<%-- 
    Document   : consulter
    Created on : 10 oct. 2022, 11:02:46
    Author     : arnaud
--%>
<%@page import="model.Membre"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 100%">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Le membre</title>
</head>
<body>
    <%@ include file="/view/header.jsp" %>
<%
    Membre unMembre = (Membre)request.getAttribute("pMembre");
%>
<h1>Fiche : <%out.println(unMembre.getNom() +" "+ unMembre.getPrenom());%></h1>
<br/>

<p>Instrument joué : <%out.println(unMembre.getInstrument().getLibelle());%></p>
<p>Statut : <%out.println(unMembre.getStatut().getLibelleStatut());%></p>


</body>
</html>