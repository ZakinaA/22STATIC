<%-- 
    Document   : ajouter
    Created on : 19 oct. 2022, 10:07:42
    Author     : sio2
--%>

<%@page import="form.FormFestival"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ include file="/view/header.jsp" %> <%@ include file="/view/body.jsp" %>   <%@ include file="/view/nav.jsp" %>
<h1 style="text-align: center; margin: 2%; color: black">Ajouter un festival</h1>

<%
    //Client client=(Client)request.getAttribute("client");
    FormFestival form = (FormFestival) request.getAttribute("form");
%>
<form action="ajouter" method="POST" class="form">
    <label for="nom">Nom : </label>
    <input id="nom" type="text" name="nom"  size="70" maxlength="70" class="form-control" placeholder="Entrer nom">
    <span style="color: blue;">${form.erreurs['libelle']}</span>
    </br>
    </br>
    <label for="annee">Année: </label>
    <input id="annee"  type="text"  name="annee" size="10" maxlength="4" class="form-control" placeholder="Entrer année">
    <span style="color: blue;">${form.erreurs['annee']}</span>
    </br>
    </br>
    <label for="dateDebut">Date de début: </label>
    <input id="dateDebut"  type="date"  name="dateDebut" size="10" maxlength="10" class="form-control">
    <span style="color: blue;">${form.erreurs['dateDebut']}</span>
    </br>
    </br>
    <label for="dateFin">Date de fin: </label>
    <input id="dateFin"  type="date"  name="dateFin" size="10" maxlength="10" class="form-control">
    <span style="color: blue;">${form.erreurs['dateFin']}</span>
    </br>
    </br>
    <label for="logo">Logo: </label>
    <input id="logo" type="text"  name="logo" class="form-control" placeholder="Entrer URL">
    <span style="color: blue;">${form.erreurs['logo']}</span>
    </br>
    <input class="btn btn-success" style="width: 100%;" type="submit" name="valider" id="valider" value="Valider"/>
</form>
</body>
</body>
</html>
