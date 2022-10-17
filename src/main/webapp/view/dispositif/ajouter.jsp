<%-- 
    Document   : ajouter
    Created on : 17 oct. 2022, 11:28:12
    Author     : sio2
--%>
<%@page import="form.FormDispositif"%>
<%@ include file="/view/header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h1>Ajouter dispostif</h1>
    
    <%
    //Client client=(Client)request.getAttribute("client");
    FormDispositif form = (FormDispositif)request.getAttribute("form");
    %>
    <form action="ajouter" method="POST">
        <label for="libelle">Nom : </label>
        <input id="libelle" type="text" name="libelle"  size="70" maxlength="70">
        <span style="color: blue;">${form.erreurs['libelle']}</span>
        </br>
        </br>
        <label for="dateCreation">Année (YYYY): </label>
        <input id="dateCreation"  type="text"  name="dateCreation" size="4" maxlength="4">
        <span style="color: blue;">${form.erreurs['dateCreation']}</span>
        </br>
        <input type="submit" name="valider" id="valider" value="Valider"/>
    </form>
</body>
</html>
