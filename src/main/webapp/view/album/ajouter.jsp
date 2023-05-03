<%-- 
    Document   : ajouter
    Created on : 19 oct. 2022, 09:00:16
    Author     : sio2
--%>

<%@page import="form.FormAlbum"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/view/header.jsp" %> <%@ include file="/view/body.jsp" %>   <%@ include file="/view/nav.jsp" %>
<h1 style="text-align: center; margin: 2%; color: black">Ajouter un album</h1>

<%
    //Client client=(Client)request.getAttribute("client");
    FormAlbum form = (FormAlbum) request.getAttribute("form");
%>
<form action="ajouter" method="POST" class="form">
    <label for="libelle">Nom : </label>
    <input id="libelle" type="text" name="libelle"  size="70" maxlength="70" class="form-control" placeholder="Entrer nom">
    <span style="color: blue;">${form.erreurs['libelle']}</span>
    </br>
    </br>
    <label for="dateCreation">Date de création: </label>
    <input id="dateCreation"  type="date"  name="dateCreation" class="form-control">
    <span style="color: blue;">${form.erreurs['dateCreation']}</span>
    </br>
    </br>
    <label for="cheminImg">Image: </label>
    <input id="cheminImg" accept="image/png, image/jpeg" type="file"  name="cheminImg" class="form-control">
    <span style="color: blue;">${form.erreurs['cheminImg']}</span>
    </br>
    <input class="btn btn-success" style="width: 100%;" type="submit" name="valider" id="valider" value="Valider"/>
</form>
</body>
</html>
