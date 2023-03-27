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
    ArrayList<Album> lesAlbums = (ArrayList) request.getAttribute("pLesAlbums");
%>
<h1 style="text-align: center; margin: 2%; color: black">Les albums</h1>
<body>
    <div class="center container px-4 px-lg-5">
        <table class="center table table-bordered table-striped table-condensed rounded" style="background-color:rgba(255, 255, 255, 0.5); border: 10px solid rgba(255, 255, 255, 0.5); border-radius: 10px; "> 
            <tbody>
                <%
                    int i = 0;
                    for (Album unAlbum : lesAlbums) {
                        i++;
                        if (i == 0) {
                            out.println("<tr>");
                        }
                        out.println("<td>");

                        out.println("<div class='card' style='width: 18rem;'>");
                        out.println("<img src='" + unAlbum.getCheminImg() + "' class='card-img-top'>");
                        out.println("<div class='card-body'>");
                        out.println("<h5 class='card-title'>" + unAlbum.getNom() + "</h5>");
                        out.println("<p class='card-text'>Some quick example text to build on the card title and make up the bulk of the card's content.</p>");
                        out.println("<p class='card-text card-title'><small class='text-muted'>" + unAlbum.getDateCreation() + "</small></p>");
                        out.println("<a href='../ServletAlbum/consulter?idAlbum=" + unAlbum.getId() + "' class='btn btn-primary'>Consulter l'album</a>");
                        out.println("</div>");
                        out.println("</div>");
                        out.println("</td>");
                        if (i == 4) {
                            out.println("</tr>");
                            i = 0;
                        }

                    }

                %>
            </tbody>
        </table>
    </div>
</body>
</html>

<%-- Card a implementer pour chaque albume

out.println("<div class='card' style='width: 18rem;'>");
  out.println("<img src='"+unAlbum.getCheminImg()+"' class='card-img-top'>");
  out.println("<div class='card-body'>");
    out.println("<h5 class='card-title'>unAlbum.getNom()</h5>");
    out.println("<p class='card-text'>Some quick example text to build on the card title and make up the bulk of the card's content.</p>");
    out.println("<a href='../ServletAlbum/consulter?idAlbum=" + unAlbum.getId() + "' class='btn btn-primary'>Consulter l'album</a>");
  out.println("</div>");
out.println("</div>"); --%>