<%@page import="model.Membre"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="model.Groupe"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <title>WebZik</title>
</head>
<body>

<%
    ArrayList<Groupe> lesGroupes = (ArrayList)request.getAttribute("pLesGroupes");
    Groupe unGroupe = (Groupe)request.getAttribute("pGroupe");
%>
<% if (unGroupe != null) {%>

<h1>Mon groupe</h1>
<br/>
<div class="container px-4 px-lg-5">
    <table  class="table table-bordered table-striped table-condensed">
        <thead>
        <tr>
            <th>Nom</th>
            <th>dateCreation</th>
            <th>Telephone</th>
            <th>MelSiteWeb</th>
            <th>LieuRepetition</th>
            <th>Genre</th>

        </tr>
        </thead>
        <tbody>
        <tr>
            <%
                out.println("<tr><td>");
                    out.println("<a href ='../ServletGroupe/consulter?idGroupe=" + unGroupe.getId() + "'>");
                    out.println(unGroupe.getNom());
                    out.println("</td>");
                    
                    out.println("<td>");
                    out.println(unGroupe.getDateCreation());
                    out.println("</td>");
                    
                    out.println("<td>");
                    out.println(unGroupe.getTelephone());
                    out.println("</td>");
                    
                    out.println("<td>");
                    out.println(unGroupe.getMelSiteWeb());
                    out.println("</td>");
                    
                    out.println("<td>");
                    out.println(unGroupe.getLieuRepetition());
                    out.println("</td>");

                    out.println("<td>");
                    out.println(unGroupe.getGenre().getLibelle());
                    out.println("</td>");
                }%>

<% if (lesGroupes != null) {%>
<div class="container px-4 px-lg-5">
    <table  class="table table-bordered table-striped table-condensed">
        <thead>
        <tr>
            <th>Nom</th>
            <th>Membre contact</th>
            <th>dateCreation</th>
            <th>Telephone</th>
            <th>MelSiteWeb</th>
            <th>LieuRepetition</th>
            <th>Genre</th>

        </tr>
        </thead>
        <tbody>
        <tr>
            <%
                for (Groupe Groupe : lesGroupes) {

                    out.println("<tr><td>");
                    out.println("<a href ='../ServletGroupe/consulter?idGroupe=" + Groupe.getId() + "'>");
                    out.println(Groupe.getNom());
                    out.println("</td>");
                    
                    out.println("<td>");
                    Membre mem = Groupe.getMembre();
                    out.println("<a href='../ServletMembre/consulter?idMembre=" + mem.getId() + "'>" + mem.getNom() +" "+mem.getPrenom()+"</a>");
                    out.println("</td>");
                    
                    out.println("<td>");
                    out.println(Groupe.getDateCreation());
                    out.println("</td>");
                    
                    out.println("<td>");
                    out.println(Groupe.getTelephone());
                    out.println("</td>");
                    
                    out.println("<td>");
                    out.println(Groupe.getMelSiteWeb());
                    out.println("</td>");
                    
                    out.println("<td>");
                    out.println(Groupe.getLieuRepetition());
                    out.println("</td>");

                    out.println("<td>");
                    out.println(Groupe.getGenre().getLibelle());
                    out.println("</td>");


                }
            }
            %>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>