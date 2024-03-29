<%-- 
    Document   : groupe
    Created on : 10 oct. 2022, 11:02:46
    Author     : arnaud
--%>

<%@page import="model.Membre"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="model.Groupe"%>
<%@ page import="java.util.ArrayList" %>

    <%@ include file="/view/header.jsp" %> <%@ include file="/view/body.jsp" %>   <%@ include file="/view/nav.jsp" %>
<%if (nomMembre!=null){%>
    
<%
    ArrayList<Groupe> lesGroupes = (ArrayList)request.getAttribute("pLesGroupes");
    Groupe unGroupe = (Groupe)request.getAttribute("pGroupe");
%>
<% if (unGroupe.getNom() != null) {%>


<div class="center container px-4 px-lg-5">
<h1 style="text-align: center; margin: 2%; color: black">Mon groupe</h1>
    <table  class="table table-bordered table-striped table-condensed rounded" style="background-color:rgba(255, 255, 255, 0.5); border: 10px solid rgba(255, 255, 255, 0.5); border-radius: 10px; ">
        <thead>
        <tr>
            <th>Nom</th>
            <th>dateCreation</th>
            <th>Telephone</th>
            <th>MelSiteWeb</th>
            <th>LieuRepetition</th>
            <th>Genre</th>
            <th>Ajouter un membre</th>
            <th>Supprimer le groupe</th>

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
                    
                    out.println("<td>");
                    out.println("<a href ='../ServletGroupe/ajouterMembre?idGroupe=" + unGroupe.getId() + "'>");
                    out.println("<button type='button' class='btn btn-primary'>Ajouter</button>");
                    out.println("</a></td>");
                    
                    out.println("<td>");
                    out.println("<a href ='../ServletGroupe/ajouterMembre?idGroupe=" + unGroupe.getId() + "'>");
                    out.println("<button type='button' class='btn btn-danger'>Supprimer</button>");
                    out.println("</a></td>");
                }%>
        </tr>
        </tbody>
    </table>
    <% if (lesGroupes.size()<1){%>
       <%}else{%>
<h1 style="text-align: center; margin: 2%; color: black">Les groupes dans lesquels je joue</h1>
<div class="container px-4 px-lg-5">
    <table  class="table table-bordered table-striped table-condensed" style="background-color:rgba(255, 255, 255, 0.5); border: 10px solid rgba(255, 255, 255, 0.5); border-radius: 10px; ">
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
                }%>
        </tr>
        </tbody>
    </table>
</div>
<%}else{}%>
</body>
</html>