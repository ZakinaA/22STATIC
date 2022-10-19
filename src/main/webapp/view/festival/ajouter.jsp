<%-- 
    Document   : ajouter
    Created on : 19 oct. 2022, 10:07:42
    Author     : sio2
--%>

<%@page import="form.FormFestival"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajouter un festival</title>
    </head>
    <body>
        <%@ include file="/view/header.jsp" %>
        <h1 style="text-align: center; margin: 2%; color: black">Ajouter un festival</h1>
        
        <%
       //Client client=(Client)request.getAttribute("client");
        FormFestival form = (FormFestival)request.getAttribute("form");
        %>
        <form action="ajouter" method="POST" style="text-align: center; margin: 0 10%; background-color:rgba(255, 255, 255, 0.5); border: 10px solid rgba(255, 255, 255, 0.5); border-radius: 10px; ">
           <label for="libelle">Nom : </label>
           <input id="libelle" type="text" name="libelle"  size="70" maxlength="70">
           <span style="color: blue;">${form.erreurs['libelle']}</span>
           </br>
           </br>
           <label for="annee">Année: </label>
           <input id="annee"  type="text"  name="annee" size="4" maxlength="4">
           <span style="color: blue;">${form.erreurs['annee']}</span>
           </br>
           </br>
           <label for="dateDebut">Date de début: </label>
           <input id="dateDebut"  type="text"  name="dateDebut" size="10" maxlength="10">
           <span style="color: blue;">${form.erreurs['dateDebut']}</span>
           </br>
           </br>
           <label for="dateFin">Date de fin: </label>
           <input id="dateFin"  type="text"  name="dateFin" size="10" maxlength="10">
           <span style="color: blue;">${form.erreurs['dateFin']}</span>
           </br>
           </br>
           <label for="logo">Logo: </label>
           <input id="logo"  type="text"  name="logo" size="70" maxlength="255">
           <span style="color: blue;">${form.erreurs['logo']}</span>
           </br>
           <input type="submit" name="valider" id="valider" value="Valider"/>
        </form>
    </body>
    </body>
</html>
