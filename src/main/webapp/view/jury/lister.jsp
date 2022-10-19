<%-- 
    Document   : lister
    Created on : 5 oct. 2022, 11:16:26
    Author     : ouael
--%>

<%@page import="model.Groupe"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 100%">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Jury</title>
</head>
<body>
    <%@ include file="/view/header.jsp" %>
<%if (nomPartenaire!=null){%>
    <h1>Les Groupes</h1>
<br/>


<%
    ArrayList<Groupe> lesGroupes = (ArrayList)request.getAttribute("pLesGroupes");
%>


<div class="container px-4 px-lg-5">
    <table  class="table table-bordered table-striped table-condensed rounded" style="background-color:rgba(255, 255, 255, 0.5); border: 10px solid rgba(255, 255, 255, 0.5); border-radius: 10px; " >
        <thead>
        <tr>
            <th>Nom</th>
            <th>Membre contact</th>
            <th>dateCreation</th>
            <th>Telephone</th>
            <th>MelSiteWeb</th>
            <th>LieuRepetition</th>
            <th>Genre</th>
            <th>Participation</th> 
        </tr>
        </thead >
        <tbody>
        <tr>
            <%
                for (Groupe unGroupe : lesGroupes) {

                    out.println("<tr><td>");
                    out.println("<a href ='../ServletGroupe/consulter?idGroupe=" + unGroupe.getId() + "'>");
                    out.println(unGroupe.getNom());
                    out.println("</td>");
                    
                    out.println("<td>");
                    out.println(unGroupe.getMembre().getNom());
                    out.println(unGroupe.getMembre().getPrenom());
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
                    if (unGroupe.getEstSelectionne() == 1){
                        out.println("<a href ='../ServletJury/desinscrire?idGroupe=" + unGroupe.getId() + "'>");
                        out.println("<button type='button' class='btn btn-danger'>Desinscrire</button>");
                    } else {
                        out.println("<a href ='../ServletJury/inscrire?idGroupe=" + unGroupe.getId() + "'>");
                        out.println("<button type='button' class='btn btn-success'>Inscrire</button>");
                    }
                    out.println("</td>");
                }

            %>
        </tr>
        </tbody>
    </table>
</div>
        <%}else{}%>
</body>
</html>