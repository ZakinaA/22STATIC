<%@page import="model.Membre"%>
<%@page import="model.Dispositif"%>
<%@page import="model.Groupe"%>
<%@ page import="form.FormGroupe" %>
<%@ page import="model.Genre" %>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Normanzik: ajouter un groupes</title>
</head>
<body>
    <%@ include file="/view/header.jsp" %>
    <h1>Ajouter Membre au Groupe</h1>
<br/>


<%
    Groupe unGroupe = (Groupe)request.getAttribute("pGroupe");
    //Client client=(Client)request.getAttribute("client");
    FormGroupe form = (FormGroupe)request.getAttribute("formAjouterMembre");
%>

<form action="ajouterMembre" method="POST">
    <label for="idGroupe">ID Groupe : </label>
    <% out.println("<input name='idGroupe' class='form-control' type='text' value='"+ unGroupe.getId() +"' readonly>");%>
    <label for="idMembre">Membre : </label>
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
    <input type="submit" name="valider" id="valider" value="Ajouter !"/>
</form>
</body>
</html>