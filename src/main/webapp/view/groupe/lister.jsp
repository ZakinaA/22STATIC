<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="model.Groupe"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html style="height: 100%">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
    <title>Normanzik: lister les groupes</title>
</head>
<style>
    th {
        border-radius: 10px;
    }
    li{
        width: 140px;
        float: left;
    }
</style>
<body style="background-image: url('https://i.ibb.co/Bj2dHPm/t-l-chargement.png'); background-repeat: no-repeat; background-size: cover; backdrop-filter: blur(7.5px); height: 100%">
        <!-- HEADER -->
        <nav class="navbar navbar-expand-sm bg-light py-5 px-5" style="opacity: 0.5; height: 13%">
        </nav>
        <div class="container-fluid" style="position: absolute; top: 22px; ">
                <a class="navbar-brand" href="# ">
                <img src="https://i.ibb.co/tQRkg9M/logo.png" alt="Logo" width="60" height="60" class="d-inline-block mx-4" >
                    Norman'Zik
                </a>
            <div class="container-fluid" style="position: absolute; top: 22px; right: 0px; width: 300px ">
            <ul class="navbar-nav" >
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#" style="">Découvrir</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../ServletConnexion/connexion">Se connecter</a>
                </li>
        </div>
        </div>
        
        <!-- HEADER -->
<h1 style="text-align: center; margin: 2%; color: black">Consulter Groupe</h1>
<br/>


<%
    ArrayList<Groupe> lesGroupes = (ArrayList)request.getAttribute("pLesGroupes");
%>


<div style="margin: 0 10%;  ">
    <table  class="table table-bordered table-striped table-condensed rounded" style="background-color:rgba(255, 255, 255, 0.5); border: 10px solid rgba(255, 255, 255, 0.5); border-radius: 10px; ">
        <thead>
        <tr>
            <th>Nom</th>
            <th>Membre contact</th>
            <th>dateCreation</th>
            <th>Telephone</th>
            <th>MelSiteWeb</th>
            <th>LieuRepetition</th>
            <th>Genre</th>

        </tr>
        </thead >
        <tbody>
        <tr>
            <%
                for (Groupe unGroupe : lesGroupes) {

                    out.println("<tr><td>");
                    out.println("<a href ='../ServletGroupe/consulter?idGroupe=" + unGroupe.getId() + "'>");
                    out.println(unGroupe.getNom());
                    out.println("</td>");
                    
                    out.println("<td>");
                    out.println(unGroupe.getMembre().getNom());
                    out.println(unGroupe.getMembre().getPrenom());
                    out.println("</td>");
                    
                    out.println("<td>");
                    out.println(unGroupe.getDateCreation());
                    out.println("</td>");
                    
                    out.println("<td>");
                    out.println(unGroupe.getTelephone());
                    out.println("</td>");
                    
                    out.println("<td>");
                    out.println(unGroupe.getMelSiteWeb());
                    out.println("</td>");
                    
                    out.println("<td>");
                    out.println(unGroupe.getLieuRepetition());
                    out.println("</td>");

                    out.println("<td>");
                    out.println(unGroupe.getGenre().getLibelle());
                    out.println("</td>");


                }

            %>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>