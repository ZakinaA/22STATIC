<%@page import="model.Membre"%>
<%@page import="model.Dispositif"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="model.Groupe"%>
<%@ page import="form.FormGroupe" %>
<%@ page import="model.Genre" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
    <title>WebZik</title>
</head>
<body>
<h1>Ajouter Groupe</h1>
<br/>


<%
    //Client client=(Client)request.getAttribute("client");
    FormGroupe form = (FormGroupe)request.getAttribute("form");
%>

<form class="form-inline" action="ajouter" method="POST">
    <label for="nom">Nom : </label>
    <input id="nom" type="text" name="nom"  size="70" maxlength="70">
    <span style="color: blue;">${form.erreurs['nom']}</span>
    </br>
    </br>
    <label for="dateCreation">Date de création : </label>
    <input id="dateCreation"  type="text"  name="dateCreation" size="10" maxlength="10">
    <span style="color: blue;">${form.erreurs['dateCreation']}</span>
    </br>
    <label for="telephone">Téléphone : </label>
    <input id="telephone"  type="text"  name="telephone" size="10" maxlength="10">
    <span style="color: blue;">${form.erreurs['telephone']}</span>
    </br>
    <label for="melSiteWeb">Mail site web : </label>
    <input id="melSiteWeb"  type="text"  name="melSiteWeb" size="10" maxlength="10">
    <span style="color: blue;">${form.erreurs['melSiteWeb']}</span>
    </br>
    <label for="lieuRepetition">Lieu de répétition : </label>
    <input id="lieuRepetition"  type="text"  name="lieuRepetition" size="10" maxlength="10">
    <span style="color: blue;">${form.erreurs['lieuRepetition']}</span>
    </br>
    <label for="dispositif">Dispositif : </label>
    <select name="idDispositif">
        <%
            ArrayList<Dispositif> lesDispositifs = (ArrayList)request.getAttribute("pLesDispositifs");
            for (int i=0; i<lesDispositifs.size();i++){
                Dispositif d = lesDispositifs.get(i);
                out.println("<option value='" + d.getId()+"'>" + d.getLibelle()+"</option>" );
            }
        %>
    </select>
    </br>
    </br>
    <label for="dispositif">Membre : </label>
    <select name="idMembre">
        <%
            ArrayList<Membre> lesMembres = (ArrayList)request.getAttribute("pLesMembres");
            for (int i=0; i<lesMembres.size();i++){
                Membre d = lesMembres.get(i);
                out.println("<option value='" + d.getId()+"'>" + d.getNom()+"</option>" );
            }
        %>
    </select>
    </br>
    </br>
    <%-- Champ Liste des genres --%>
    <label for="genre">Genre : </label>
    <select name="idGenre">
        <%
            ArrayList<Genre> lesGenres = (ArrayList)request.getAttribute("pLesGenres");
            for (int i=0; i<lesGenres.size();i++){
                Genre g = lesGenres.get(i);
                out.println("<option value='" + g.getId()+"'>" + g.getLibelle()+"</option>" );
            }
        %>
    </select>
    </br>
    </br>
    <input type="submit" name="valider" id="valider" value="Valider"/>
</form>
</body>
</html>