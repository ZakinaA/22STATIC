<%-- 
    Document   : consulter
    Created on : 17 oct. 2022, 11:45:04
    Author     : Guillaume Martin
--%>

<%@page import="model.Titre"%>
<%@page import="model.Album"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.lang.String"%>
<%@ include file="/view/header.jsp" %>
<%
    Album unAlbum = (Album) request.getAttribute("pLesTitresAlbum");
%>
<body style="backdrop-filter: blur(7.5px); background-image: url('<%= unAlbum.getCheminImg()%>'); background-size:14%; min-height: 100vh; height: 100%;">
    <%@ include file="/view/nav.jsp" %>
    <h1 style="text-align: center; margin: 2%; mix-blend-mode: difference; color: #FFFFFF;"><%out.println(unAlbum.getNom());%></h1>
    <br/>
    <div class="center">
        <div class="center" style="vertical-align: top;display: inline-block; padding: 10px; background-color:rgba(255, 255, 255, 0.7); border: 10px solid rgba(255, 255, 255, 0.5); border-radius: 10px;">
            <%
                out.println("<p>Le groupe : <a href='../ServletGroupe/consulter?idGroupe=" + unAlbum.getGroupe().getId() + "'>" + unAlbum.getGroupe().getNom() + "</a></p>");
            %>
            <p>Date de Création : <%out.println(unAlbum.getDateCreation());%></p>

            <%  if (unAlbum.getLesTitres() != null && unAlbum.getLesTitres().size() != 0) {
                    if (unAlbum.getLesTitres().size() > 1) {
                        out.println("<p><b>Titres:</b></p>");
                    } else {
                        out.println("<p><b>Titre:</b></p>");
                    }
                    out.println("<table class='center table table-striped table-condensed rounded' style='background-color:rgba(255, 255, 255, 0.5); border: 10px solid rgba(255, 255, 255, 0.5);'>");
                    out.println("<thead>");
                    out.println("<tr>");
                    out.println("<th>Intitulé</th>");
                    out.println("<th>Durée</th>");
                    out.println("<th>Lien</th>");
                    out.println("</tr>");
                    out.println("</thead>");
                    out.println("<tbody>");

                    for (int i = 0; i < unAlbum.getLesTitres().size(); i++) {
                        Titre tit = unAlbum.getLesTitres().get(i);
                        
                        out.println("<tr>");
                        out.println("<td>");
                        out.println("<a href='" + tit.getLienURL() + "'>" + tit.getIntitule() + "</a>");
                        out.println("</td>");

                        out.println("<td>");
                        out.println(tit.getDuree() + "s");
                        out.println("</td>");

                        out.println("<td>");
                        out.println("<iframe width='384' height='216' src='" + tit.getLienURL() + "' title='YouTube video player' frameborder='0' allow='accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share' allowfullscreen></iframe>");
                        //out.println("<a href='" + tit.getLienURL() + "'>" + tit.getLienURL() + "</a>");
                        out.println("</td>");
                        out.println("</tr>");
                    }
                } else {
                    out.println("L'Album n'a pas de titre");
                }

            %>
            
            </tbody>
            </table>
        </div>
        <div class="center" style="display: inline-block; left: 0; width: 300px; height: 500px; position: relative;">
            <%out.println("<iframe src='"+unAlbum.getLienAlbum()+"?utm_source=oembed' style='top: 0; left: 0; width: 100%; height: 100%; position: absolute; border: 0;' allowfullscreen allow='clipboard-write; encrypted-media; fullscreen; picture-in-picture;'></iframe>");%>
        </div>
    </div>
</body>

