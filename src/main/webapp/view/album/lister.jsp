<%-- 
    Document   : lister
    Created on : 17 oct. 2022, 11:38:45
    Author     : sio2
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Album"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <%@ include file="/view/header.jsp" %> <%@ include file="/view/body.jsp" %>   <%@ include file="/view/nav.jsp" %>
<%
    ArrayList<Album> lesAlbums = (ArrayList)request.getAttribute("pLesAlbums");
%>
<h1 style="text-align: center; margin: 2%; color: black">Les albums</h1>
    <body>
        <div class="center container px-4 px-lg-5">
            <table class="center table table-bordered table-striped table-condensed rounded" style="background-color:rgba(255, 255, 255, 0.5); border: 10px solid rgba(255, 255, 255, 0.5); border-radius: 10px; ">
                <thead>
                <tr>
                    <th>Libelle</th>
                    <th>Année</th>
                </tr>
                </thead> 
                <tbody>
                <tr>
                    <%
                        for (Album unAlbum : lesAlbums) {

                            out.println("<tr><td>");
                            out.println("<a href ='../ServletAlbum/consulter?idAlbum=" + unAlbum.getId() + "'>");
                            out.println(unAlbum.getNom());
                            out.println("</td>");

                            out.println("<td>");
                            out.println(unAlbum.getDateCreation());
                            out.println("</td>");
                            
                            out.println("<td>");
                            out.println("<img class='img-thumbnail' style='width: 200px; height: 200px;' src='"+unAlbum.getCheminImg()+"'>");
                            out.println("</td>");

                        }

                    %>
                </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
