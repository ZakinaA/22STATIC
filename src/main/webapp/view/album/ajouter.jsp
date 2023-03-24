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
        FormAlbum form = (FormAlbum)request.getAttribute("form");
        %>
        <form action="ajouter" method="POST" style="text-align: center; margin: 0 10%; background-color:rgba(255, 255, 255, 0.5); border: 10px solid rgba(255, 255, 255, 0.5); border-radius: 10px; ">
           <label for="libelle">Nom : </label>
           <input id="libelle" type="text" name="libelle"  size="70" maxlength="70">
           <span style="color: blue;">${form.erreurs['libelle']}</span>
           </br>
           </br>
           <label for="dateCreation">Date de création: </label>
           <input id="dateCreation"  type="text"  name="dateCreation" size="4" maxlength="4">
           <span style="color: blue;">${form.erreurs['dateCreation']}</span>
           </br>
           </br>
           <label for="cheminImg">Image: </label>
           <input id="cheminImg"  type="text"  name="cheminImg" size="4" maxlength="4">
           <span style="color: blue;">${form.erreurs['cheminImg']}</span>
           </br>
           <input type="submit" name="valider" id="valider" value="Valider"/>
        </form>
    </body>
</html>
