<%@page import="model.Album"%>
<%@page import="model.Titre"%>
<%@page import="model.Membre"%>
<%@page import="model.Groupe"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <%@ include file="/view/header.jsp" %> <%@ include file="/view/body.jsp" %> <%@ include file="/view/nav.jsp" %>
<%
    Groupe unGroupe = (Groupe)request.getAttribute("pGroupe");
%>

<h1 style="text-align: center; margin: 2%; color: black">Groupe : <%out.println(unGroupe.getNom());%></h1>
<br/>
<div class="center" style="padding: 10px; background-color:rgba(255, 255, 255, 0.5); border: 10px solid rgba(255, 255, 255, 0.5); border-radius: 10px;">
    
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
                if(nomMembre!=null && nomMembre.equals(unGroupe.getMembre().getNom())){
                    out.println("<td>");
                    out.println("<a style='text-decoration: none;' href ='../ServletGroupe/supprimerMembre?idGroupe=" + unGroupe.getId() + "?idMembre="+mem.getId()+"'>");
                    out.println("<button type='button' class='btn btn-danger'>Supprimer</button>");
                    out.println("</a></td>");

                    out.println("<td>");
                    out.println("<a style='text-decoration: none;' href ='../ServletGroupe/ajouterMembre?idGroupe=" + unGroupe.getId() + "'>");
                    out.println("<button type='button' class='btn btn-primary'>Ajouter</button>");
                    out.println("</a></td>");
                }
            }
        }
        else{
            out.println("Pas de membre");
        };%></p>
    <p>Téléphone : <%out.println(unGroupe.getTelephone());%></p>
    <p>Mail : <%out.println(unGroupe.getMelSiteWeb());%></p>
    <p>Lieu de récéption : <%out.println(unGroupe.getLieuRepetition());%></p>
    <p>Date de création : <%out.println(unGroupe.getDateCreation());%></p>
    <% if(unGroupe.getLesAlbums() != null && unGroupe.getLesAlbums().size()!=0){%>
        <% for (Album lAlbum : unGroupe.getLesAlbums()) { %>
        <table  class='table table-striped table-condensed rounded' style='background-color:rgba(255, 255, 255, 0.5); border: 10px solid rgba(255, 255, 255, 0.5); border-radius: 10px; '>
            <thead>
                <tr>
                    <th>

                        <%out.println("ALBUM : <a href ='../ServletAlbum/consulter?idAlbum=" + lAlbum.getId() + "'>");
                        out.println(lAlbum.getNom());
                        out.println("</a>"); %>
                    </th>
                </tr>
            </thead>
        </table>
    <%}}else{
            out.println("Le Groupe n'a pas d'album");
        }
    %>
    </div>
</body>
</html>