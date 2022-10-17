<%-- 
    Document   : header
    Created on : 10 oct. 2022, 13:53:10
    Author     : sio2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <title>WebZik</title>
    </head>
    <style>
        li{
            display: inline-block;
            font-size: 20px;
        }
        
        .logo{
            position: relative;
            top: -5px;
            font-size: 30px;
        }
    </style>
<header>
    <body style="background-image: url('https://i.ibb.co/Bj2dHPm/t-l-chargement.png'); min-height: 100vh; background-repeat: no-repeat; background-size: cover; backdrop-filter: blur(7.5px); height: 100%">
        <!-- HEADER -->
        <nav class="navbar navbar-expand-sm bg-light py-5 px-5" style="opacity: 0.8; height: 13%; box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;">
        </nav>
        <div class="container-fluid" style="position: absolute; top: 22px; ">
                <a class="logo" href="http://localhost:8080/normanzik/index.jsp">
                <img src="https://i.ibb.co/tQRkg9M/logo.png" alt="Logo" width="60" height="60" class="d-inline-block mx-3" >
                    Norman'Zik
                </a>
            <div style="position: absolute; top: 5px; right: 0px; width: 850px ">
            <ul>
                <li>
                    <a class="nav-link" aria-current="page" href="http://localhost:8080/normanzik/view/decouvrir.jsp" style="">Découvrir</a>
                </li>
                <li>
                    <a class="nav-link" href="http://localhost:8080/normanzik/ServletConnexion/connexion">Se connecter</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Groupe
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="http://localhost:8080/normanzik/ServletGroupe/lister">Lister</a>
                        <a class="dropdown-item" href="http://localhost:8080/normanzik/ServletGroupe/ajouter">Ajouter</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Jury
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="http://localhost:8080/normanzik/ServletJury/lister">Lister</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Dispositif
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="http://localhost:8080/normanzik/ServletDispositif/lister">Lister</a>
                        <a class="dropdown-item" href="http://localhost:8080/normanzik/ServletDispositif/ajouter">Ajouter</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Festival
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="http://localhost:8080/normanzik/ServletFestival/lister">Lister</a>
                        <a class="dropdown-item" href="http://localhost:8080/normanzik/ServletFestival/ajouter">Ajouter</a>
                    </div>
                </li>
        </div>
            </div>
        
        <!-- HEADER -->
    </body>
</header>

