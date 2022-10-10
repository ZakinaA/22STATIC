<%-- 
    Document   : consulter
    Created on : 10 oct. 2022, 11:19:49
    Author     : guillaume martin
--%>

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
    Festival unFestival = (Festival)request.getAttribute("pFestival");
%>

<h1>Festival : <%out.println(unFestival.getNom());%></h1>
<br/>

<%
    out.println("<p>Contact du groupe : <a href='../ServletMembre/consulter?idMembre=" + unFestival.getMembre().getId() + "'>" +unFestival.getMembre().getNom() +" "+ unFestival.getMembre().getPrenom()+"</a></p>");
%>
<p>Membres : <%
    if(unFestival.getLesMembres()!= null && unFestival.getLesMembres().size()!=0){
        for(int i=0; i<unFestival.getLesMembres().size(); i++){
            if(i==0 || i==unFestival.getLesMembres().size()){
            }
            else{
            out.println(", ");
            }
            Membre mem = unFestival.getLesMembres().get(i);
            out.println("<a href='../ServletMembre/consulter?idMembre=" + mem.getId() + "'>" + mem.getNom() +" "+mem.getPrenom()+"</a>");
    }}
    else{
        out.println("Pas de membre");
    };%></p>
<p>Téléphone : <%out.println(unFestival.getTelephone());%></p>
<p>Mail : <%out.println(unFestival.getMelSiteWeb());%></p>
<p>Lieu de récéption : <%out.println(unFestival.getLieuRepetition());%></p>
<p>Date de création : <%out.println(unFestival.getDateCreation());%></p>

<%  if(unFestival.getLesTitres() != null && unFestival.getLesTitres().size()!=0){        
    
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
    
            
                for (int i=0; i<unFestival.getLesTitres().size(); i++) {
                    Titre tit = unFestival.getLesTitres().get(i);
                    
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
                    out.println("Le Festival n'a pas de titre");
                }

            %>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
