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
                <a class="logo" href="../index.jsp">
                <img src="https://i.ibb.co/tQRkg9M/logo.png" alt="Logo" width="60" height="60" class="d-inline-block mx-3" >
                    Norman'Zik
                </a>
            <div style="position: absolute; top: 5px; right: 0px; width: 400px ">
            <ul>
                <li>
                    <a class="nav-link" aria-current="page" href="../view/decouvrir.jsp" style="">Découvrir</a>
                </li>
                <li>
                    <a class="nav-link" href="../ServletConnexion/connexion">Se connecter</a>
                </li>
        </div>
            </div>
        
        <!-- HEADER -->
    </body>
</header>

