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
<%@ include file="/view/header.jsp" %> <%@ include file="/view/body.jsp" %>   <%@ include file="/view/nav.jsp" %>
<h1 style="text-align: center; margin: 2%; color: black">Connexion</h1>
<br/>


<%
    FormConnexion form = (FormConnexion) request.getAttribute("form");
%>

<form action="connexion" method="POST" class="form">
    <label for="login">Login : </label>
    <input id="login" type="text" name="login"  size="70" maxlength="70" class="form-control" placeholder="Entrer login">
    <span style="color: blue;">${form.erreurs['login']}</span>
    </br>
    <label for="mdp">Mot de passe : </label>
    <input id="mdp"  type="password"  name="mdp" size="70" maxlength="70" class="form-control" placeholder="Entrer mot de passe">
    <span style="color: blue;">${form.erreurs['mdp']}</span>
    </br>
    </br>
    <input class="btn btn-success" style="width: 100%;" type="submit" name="valider" id="valider" value="Valider"/>
    </br>
    </br>
    <a href="../ServletMembre/ajouter"><input class="btn btn-outline-primary" style="width: 100%;" value="S'inscrire"/></a>
</form>
</body>
</html>