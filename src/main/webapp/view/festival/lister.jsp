<%-- 
    Document   : lister
    Created on : 10 oct. 2022, 11:16:26
    Author     : martin guillaume
--%>

<%@page import="model.Festival"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style="text-align: center; margin: 2%; color: black">Consulter Festival</h1>
<br/>


<%
    ArrayList<Festival> lesFestivals = (ArrayList)request.getAttribute("pLesFestivals");
%>


<div style="margin: 0 10%;  ">
    <table  class="table table-bordered table-striped table-condensed rounded" style="background-color:rgba(255, 255, 255, 0.5); border: 10px solid rgba(255, 255, 255, 0.5); border-radius: 10px; ">
        <thead>
        <tr>
            <th>Nom</th>
            <th>Année</th>
            <th>Date de début</th>
            <th>Date de fin</th>
            <th>Logo</th>

        </tr>
        </thead >
        <tbody>
        <tr>
            <%
                for (Festival unFestival : lesFestivals) {

                    out.println("<tr><td>");
                    out.println("<a href ='../ServletFestival/consulter?idFestival=" + unFestival.getId() + "'>");
                    out.println(unFestival.getNom());
                    out.println("</td>");
                    
                    /*out.println("<td>");
                    out.println(unFestival.getGroupe().getNom());
                    out.println(unFestival.getGroupe().getPrenom());
                    out.println("</td>");*/
                    
                    out.println("<td>");
                    out.println(unFestival.getAnnee());
                    out.println("</td>");
                    
                    out.println("<td>");
                    out.println(unFestival.getDateDebut());
                    out.println("</td>");
                    
                    out.println("<td>");
                    out.println(unFestival.getDateFin());
                    out.println("</td>");
                    
                    out.println("<td>");
                    out.println("<img src='" + unFestival.getLogo()+"'>");
                    out.println("</td>");


                }

            %>
        </tr>
        </tbody>
    </table>
    </body>
</html>
