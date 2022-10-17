<%@page import="form.FormConnexion"%>
<%@page import="model.Statut"%>
<%@page import="model.Instrument"%>
<%@page import="form.FormMembre"%>
<%@page import="form.FormMembre"%>
<%@page import="model.Membre"%>
<%@page import="model.Dispositif"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Groupe"%>
<%@ page import="form.FormMembre" %>
<%@ page import="model.Genre" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>WebZik</title>
</head>
<body >
    <%@ include file="/view/header.jsp" %>
<h1>Connexion</h1>
<br/>


<%
    FormConnexion form = (FormConnexion)request.getAttribute("form");
%>

<form action="connexion" method="POST">
    <label for="login">Login : </label>
    <input id="login" type="text" name="login"  size="70" maxlength="70">
    <span style="color: blue;">${form.erreurs['login']}</span>
    </br>
    <label for="mdp">Mot de passe : </label>
    <input id="mdp"  type="password"  name="mdp" size="70" maxlength="70">
    <span style="color: blue;">${form.erreurs['mdp']}</span>
    </br>
    </br>
    <input type="submit" name="valider" id="valider" value="Valider"/>
</form>
</body>
</html>