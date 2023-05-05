<%@page import="model.Membre"%>
<%@page import="model.Dispositif"%>
<%@page import="model.Groupe"%>
<%@ page import="form.FormGroupe" %>
<%@ page import="model.Genre" %>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="/view/header.jsp" %> <%@ include file="/view/body.jsp" %>   <%@ include file="/view/nav.jsp" %>
<h1 style="text-align: center; margin: 2%; color: black">Créer un groupe</h1>
<br/>


<%
    //Client client=(Client)request.getAttribute("client");
    FormGroupe form = (FormGroupe) request.getAttribute("form");
%>

<form action="ajouter" method="POST" class="form">
    <label for="nom">Nom : </label>
    <input id="nom" type="text" name="nom"  size="70" maxlength="70" class="form-control" placeholder="Entrer nom">
    <span style="color: blue;">${form.erreurs['nom']}</span>
    </br>
    </br>
    <label for="dateCreation">Date de création : </label>
    <input id="dateCreation"  type="date" size="70" maxlength="10" name="dateCreation" class="form-control" placeholder="Entrer date de création">
    <span style="color: blue;">${form.erreurs['dateCreation']}</span>
    </br>
    <label for="telephone">Téléphone : </label>
    <input id="telephone"  type="text"  name="telephone" size="70" maxlength="10" class="form-control" placeholder="Entrer téléphone">
    <span style="color: blue;">${form.erreurs['telephone']}</span>
    </br>
    <label for="melSiteWeb">Mail : </label>
    <input id="melSiteWeb"  type="text"  name="melSiteWeb" size="70" maxlength="70" class="form-control" placeholder="Entrer mail">
    <span style="color: blue;">${form.erreurs['melSiteWeb']}</span>
    </br>
    <label for="lieuRepetition">Lieu de répétition : </label>
    <input id="lieuRepetition"  type="text"  name="lieuRepetition" size="70" maxlength="70" class="form-control" placeholder="Entrer lieu répétition">
    <span style="color: blue;">${form.erreurs['lieuRepetition']}</span>
    </br>
    <label for="dispositif">Dispositif : </label>
    <select name="idDispositif" class="form-control">
        <%
            ArrayList<Dispositif> lesDispositifs = (ArrayList) request.getAttribute("pLesDispositifs");
            for (Dispositif d : lesDispositifs) {
                out.println("<option value='" + d.getId() + "'>" + d.getLibelle() + "</option>");
            }
        %>
    </select>
    </br>
    <label for="dispositif">Membre : </label>
    <select name="idMembre" class="form-control">
        <%
            ArrayList<Membre> lesMembres = (ArrayList) request.getAttribute("pLesMembres");
            for (Membre m : lesMembres) {
                if (nomMembre == null) {
                    out.println("<option value='" + m.getId() + "'>" + m.getNom() + "</option>");
                } else if (nomMembre != null && nomMembre.equals(m.getNom())) {
                    out.println("<option value='" + m.getId() + "'>" + m.getNom() + "</option>");
                }
            }
        %>
    </select>
    </br>
    <%-- Champ Liste des genres --%>
    <label for="genre">Genre : </label>
    <select name="idGenre" class="form-control">
        <%
            //DEV
            ArrayList<Genre> lesGenres = (ArrayList) request.getAttribute("pLesGenres");
            for (Genre g : lesGenres) {
                out.println("<option value='" + g.getId() + "'>" + g.getLibelle() + "</option>");
            }
        %>
    </select>
    </br>
    <input class="btn btn-success" style="width: 100%;" type="submit" name="valider" id="valider" value="Valider"/>
</form>
</body>
</html>