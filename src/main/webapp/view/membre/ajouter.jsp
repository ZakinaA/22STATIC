<%-- 
    Document   : ajouter
    Created on : 10 oct. 2022, 11:02:46
    Author     : arnaud
--%>
<%@page import="model.Statut"%>
<%@page import="model.Instrument"%>
<%@page import="form.FormMembre"%>
<%@page import="form.FormMembre"%>
<%@page import="model.Membre"%>
<%@page import="model.Dispositif"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="model.Groupe"%>
<%@ page import="form.FormMembre" %>
<%@ page import="model.Genre" %>
<%@ page import="java.util.ArrayList" %>
<%@page import="model.Groupe"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html style="height: 100%">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Ajouter un membre</title>
</head>
<body>
    <%@ include file="/view/header.jsp" %>
<h1>Ajouter Membre</h1>
<br/>


<%
    FormMembre form = (FormMembre)request.getAttribute("form");
%>

<form class="form-inline" action="ajouter" method="POST">
    <label for="nom">Nom : </label>
    <input id="nom" type="text" name="nom"  size="70" maxlength="70">
    <span style="color: blue;">${form.erreurs['nom']}</span>
    </br>
    <label for="prenom">Prénom : </label>
    <input id="prenom"  type="text"  name="prenom" size="70" maxlength="70">
    <span style="color: blue;">${form.erreurs['prenom']}</span>
    </br>
    <label for="instrument">Instrument : </label>
    <select name="idInstrument">
        <%
            ArrayList<Instrument> lesInstruments = (ArrayList)request.getAttribute("pLesInstruments");
            for (int i=0; i<lesInstruments.size();i++){
                Instrument d = lesInstruments.get(i);
                out.println("<option value='" + d.getId()+"'>" + d.getLibelle()+"</option>" );
            }
        %>
    </select>
    </br>
    </br>
    <label for="Statut">Statut : </label>
    <select name="idStatut">
        <%
            ArrayList<Statut> lesStatuts = (ArrayList)request.getAttribute("pLesStatuts");
            for (int i=0; i<lesStatuts.size();i++){
                Statut d = lesStatuts.get(i);
                out.println("<option value='" + d.getId()+"'>" + d.getLibelleStatut()+"</option>" );
            }
        %>
    </select>
    </br>
    </br>
    <input type="submit" name="valider" id="valider" value="Valider"/>
</form>
</body>
</html>