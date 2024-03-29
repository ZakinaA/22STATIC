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

<%@ include file="/view/header.jsp" %> <%@ include file="/view/body.jsp" %>   <%@ include file="/view/nav.jsp" %>

<%if (nomMembre != null) {
        response.sendRedirect("172.20.177.250:8080/STATIC/ServletMembre/groupe");
    } else {

%>
<h1 style="text-align: center; margin: 2%; color: black">Créer un compte membre</h1>
<br/>


<%    FormMembre form = (FormMembre) request.getAttribute("form");
%>

<form action="ajouter" method="POST" class="form">
    <label for="nom">Nom : </label>
    <input class="form-control" id="nom" type="text" name="nom"  size="70" maxlength="70" placeholder="Entrer nom">
    <span style="color: blue;">${form.erreurs['nom']}</span>
    </br>
    <label for="prenom">Prénom : </label>
    <input id="prenom"  type="text"  name="prenom" size="70" maxlength="70" class="form-control" placeholder="Entrer prénom">
    <span style="color: blue;">${form.erreurs['prenom']}</span>
    </br>
    <label for="instrument">Instrument : </label>
    <select name="idInstrument" class="form-control">
        <%
            ArrayList<Instrument> lesInstruments = (ArrayList) request.getAttribute("pLesInstruments");
            for (int i = 0; i < lesInstruments.size(); i++) {
                Instrument d = lesInstruments.get(i);
                out.println("<option value='" + d.getId() + "'>" + d.getLibelle() + "</option>");
            }
        %>
    </select>
    </br>
    </br>
    <label for="Statut">Statut : </label>
    <select name="idStatut" class="form-control">
        <%
            ArrayList<Statut> lesStatuts = (ArrayList) request.getAttribute("pLesStatuts");
            for (int i = 0; i < lesStatuts.size(); i++) {
                Statut d = lesStatuts.get(i);
                out.println("<option value='" + d.getId() + "'>" + d.getLibelleStatut() + "</option>");
            }
        %>
    </select>
    </br>
    </br>
    <label for="login">Login : </label>
    <input id="login"  type="text"  name="login" size="70" maxlength="70" class="form-control" placeholder="Entrer login">
    <span style="color: blue;">${form.erreurs['login']}</span>
    </br>
    <label for="mdp">Mot de passe : </label>
    <input type="password" class="form-control" id="mdp" size="70" maxlength="70" placeholder="Password" name="mdp">
    <span style="color: blue;">${form.erreurs['mdp']}</span>
    </br>
    <input class="btn btn-success" style="width: 100%;" type="submit" name="valider" id="valider" value="Valider"/>
</form>
<%}%>
</body>
</html>