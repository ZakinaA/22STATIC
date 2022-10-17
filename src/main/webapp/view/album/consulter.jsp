<%-- 
    Document   : consulter
    Created on : 17 oct. 2022, 11:45:04
    Author     : Guillaume Martin
--%>

<%@page import="model.Titre"%>
<%@page import="model.Album"%>
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
        <%@ include file="/view/header.jsp" %>
        <%
            Album unAlbum = (Album)request.getAttribute("pLesTitresAlbum");
        %>

        <h1 style="text-align: center; margin: 2%; color: black"><%out.println(unAlbum.getNom());%></h1>
        <br/>
    
        <div class="container px-4 px-lg-5" style="background-color:rgba(255, 255, 255, 0.5); border: 10px solid rgba(255, 255, 255, 0.5); border-radius: 10px; ">
                <tbody>
                    <tr>
                        <%
                            out.println("<p>Le groupe : <a href='../ServletGroupe/consulter'>" + unAlbum.getLesTitres() +"</a></p>");
                        %>
                        <p>Date de Création : <%out.println(unAlbum.getDateCreation());%></p>
                        <p>Les titres:</p>
                        <table  class="table table-bordered table-striped table-condensed rounded" style="background-color:rgba(255, 255, 255, 0.5); border: 10px solid rgba(255, 255, 255, 0.5); border-radius: 10px; ">
                        <%  if(unAlbum.getLesTitres() != null && unAlbum.getLesTitres().size()!=0){        

                        out.println("<div class='container px-4 px-lg-5'>");
                        out.println("<table  class='table table-bordered table-striped table-condensed'>");
                        out.println("<thead>");
                        out.println("<tr>");
                        out.println("<th>Intitulé</th>");
                        out.println("<th>Durée</th>");
                        out.println("<th>Lien</th>");
                        out.println("</tr>");
                        out.println("</thead>");
                        out.println("<tbody>");
                        out.println("<tr>");


                            for (int i=0; i<unAlbum.getLesTitres().size(); i++) {
                                Titre tit = unAlbum.getLesTitres().get(i);

                                out.println("<td>");
                                out.println("<a href='"+tit.getLienURL()+"'>" + tit.getIntitule()+"</a>");
                                out.println("</td>");

                                out.println("<td>");
                                out.println(tit.getDuree()+"s");
                                out.println("</td>");

                                out.println("<td>");
                                out.println(tit.getLienURL());
                                out.println("</td>");


                            }}else{
                                out.println("L'Album n'a pas de titre");
                            }

                        %>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
