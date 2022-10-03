<%@page import="model.Statut"%>
<%@page import="model.Instrument"%>
<%@page import="form.FormMembre"%>
<%@page import="form.FormMembre"%>
<%@page import="model.Membre"%>
<%@page import="model.Dispositif"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="model.Groupe"%>
<%@ page import="form.FormMembre" %>
<%@ page import="model.Genre" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <title>WebZik</title>
</head>
<body>
<h1>Connexion</h1>
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
    </br>
    <input type="submit" name="valider" id="valider" value="Valider"/>
</form>
</body>
</html>