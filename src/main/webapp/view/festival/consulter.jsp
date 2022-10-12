<%-- 
    Document   : consulter
    Created on : 10 oct. 2022, 11:19:49
    Author     : guillaume martin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Festival"%>
<%@page import="model.Groupe"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ include file="/view/header.jsp" %>
       <%
        ArrayList<Groupe> lesGroupes = (ArrayList)request.getAttribute("pLesGroupesDuFestival");
%>

<h1 style="text-align: center; margin: 2%; color: black">Les groupes du festival</h1>
<br/>

<div class="container px-4 px-lg-5">
    <table  class="table table-bordered table-striped table-condensed rounded" style="background-color:rgba(255, 255, 255, 0.5); border: 10px solid rgba(255, 255, 255, 0.5); border-radius: 10px; ">
        <thead>
        <tr>
            <th>Nom</th>
        </tr>
        </thead>
        <tbody>
            <tr>
            <%
               for (Groupe unGroupe : lesGroupes) {
                    out.println("<tr><td>");
                    out.println("<a href ='../ServletGroupe/consulter?idGroupe=" + unGroupe.getId() + "'>");
                    out.println(unGroupe.getNom());
                    out.println("</a></td>");
                }
            %>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
