<%-- 
    Document   : ajouter
    Created on : 17 oct. 2022, 11:28:12
    Author     : sio2
--%>
<%@page import="form.FormDispositif"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/view/header.jsp" %> <%@ include file="/view/body.jsp" %>   <%@ include file="/view/nav.jsp" %>
<h1 style="text-align: center; margin: 2%; color: black">Ajouter dispostif</h1>
<br/>
<%
    //Client client=(Client)request.getAttribute("client");
    FormDispositif form = (FormDispositif) request.getAttribute("form");
%>
<form action="ajouter" method="POST" class="form">
    <label for="libelle">Nom : </label>
    <input id="libelle" type="text" name="libelle"  size="70" maxlength="70" class="form-control" placeholder="Entrer nom">
    <span style="color: blue;">${form.erreurs['libelle']}</span>
    </br>
    </br>
    <label for="dateCreation">Année (YYYY): </label>
    <input id="dateCreation"  type="text"  name="dateCreation" size="7" maxlength="4" class="form-control" placeholder="Entrer année">
    <span style="color: blue;">${form.erreurs['dateCreation']}</span>
    </br>
    <input class="btn btn-success" style="width: 100%;" type="submit" name="valider" id="valider" value="Valider"/>
</form>
</body>
</html>
