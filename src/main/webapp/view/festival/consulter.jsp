<%-- 
    Document   : consulter
    Created on : 10 oct. 2022, 11:19:49
    Author     : sio2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%
    Groupe unGroupe = (Groupe)request.getAttribute("pGroupe");
%>

<h1>Groupe : <%out.println(unGroupe.getNom());%></h1>
<br/>

<%
    out.println("<p>Contact du groupe : <a href='../ServletMembre/consulter?idMembre=" + unGroupe.getMembre().getId() + "'>" +unGroupe.getMembre().getNom() +" "+ unGroupe.getMembre().getPrenom()+"</a></p>");
%>
<p>Membres : <%
    if(unGroupe.getLesMembres()!= null && unGroupe.getLesMembres().size()!=0){
        for(int i=0; i<unGroupe.getLesMembres().size(); i++){
            if(i==0 || i==unGroupe.getLesMembres().size()){
            }
            else{
            out.println(", ");
            }
            Membre mem = unGroupe.getLesMembres().get(i);
            out.println("<a href='../ServletMembre/consulter?idMembre=" + mem.getId() + "'>" + mem.getNom() +" "+mem.getPrenom()+"</a>");
    }}
    else{
        out.println("Pas de membre");
    };%></p>
<p>Téléphone : <%out.println(unGroupe.getTelephone());%></p>
<p>Mail : <%out.println(unGroupe.getMelSiteWeb());%></p>
<p>Lieu de récéption : <%out.println(unGroupe.getLieuRepetition());%></p>
<p>Date de création : <%out.println(unGroupe.getDateCreation());%></p>

<%  if(unGroupe.getLesTitres() != null && unGroupe.getLesTitres().size()!=0){        
    
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
    
            
                for (int i=0; i<unGroupe.getLesTitres().size(); i++) {
                    Titre tit = unGroupe.getLesTitres().get(i);
                    
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
                    out.println("Le Groupe n'a pas de titre");
                }

            %>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
