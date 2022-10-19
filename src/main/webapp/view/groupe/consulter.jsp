<%@page import="model.Titre"%>
<%@page import="model.Membre"%>
<%@page import="model.Groupe"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 100%">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Normanzik: consulter les groupes</title>
</head>

<body>
    <%@ include file="/view/header.jsp" %>
<%
    Groupe unGroupe = (Groupe)request.getAttribute("pGroupe");
%>

<h1 style="text-align: center; margin: 2%; color: black">Groupe : <%out.println(unGroupe.getNom());%></h1>
<br/>
<div style="margin: 0 10%; background-color:rgba(255, 255, 255, 0.5); border: 10px solid rgba(255, 255, 255, 0.5); border-radius: 10px;">
    
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
                if(nomMembre == unGroupe.getMembre().getNom()){
                    out.println("<td>");
                    out.println("<a href ='../ServletGroupe/ajouterMembre?idGroupe=" + unGroupe.getId() + "'>");
                    out.println("<button type='button' class='btn btn-danger'>Supprimer</button>");
                    out.println("</a></td>");

                    out.println("<td>");
                    out.println("<a href ='../ServletGroupe/ajouterMembre?idGroupe=" + unGroupe.getId() + "'>");
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
    <table  class="table table-bordered table-striped table-condensed rounded" style="background-color:rgba(255, 255, 255, 0.5); border: 10px solid rgba(255, 255, 255, 0.5); border-radius: 10px; ">
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