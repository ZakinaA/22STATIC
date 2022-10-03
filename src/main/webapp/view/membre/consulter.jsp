<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="model.Membre"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
    <title>WebZik</title>
</head>
<body>
<%
    Membre unMembre = (Membre)request.getAttribute("pMembre");
%>
<h1>Fiche : <%out.println(unMembre.getNom() +" "+ unMembre.getPrenom());%></h1>
<br/>

<p>Instrument joué : <%out.println(unMembre.getInstrument().getLibelle());%></p>
<p>Statut : <%out.println(unMembre.getStatut().getLibelleStatut());%></p>


</body>
</html>