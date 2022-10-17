<%-- 
    Document   : newjsp
    Created on : 12 oct. 2022, 08:53:19
    Author     : sio2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://kit.fontawesome.com/b8b203d9d9.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <%@ include file="/view/header.jsp" %>
        <h1 style="text-align: left; margin: 8% 2% 5% 10%; color: white; font-size: 50px">Découvrez la musique de votre région</h1>
    </body>
    <div>
        
        <table style="margin: 5% 5% 5% 10%">
            <tr>
                <th style="border:10px">
                    <a href="../ServletGroupe/lister">
                    <div style="width: 175px; height: 250px; background-color: black">
                        <div style="font-size:120px; width: 100%; height: 70%"> 
                            <i style="margin:8%; color: white" class="fa-solid fa-user-group"></i>
                        </div>
                        <div>
                            <p style="text-align: center; margin-top: 15px; color: white">Les groupes</p>
                        </div>
                    </div>
                    </a>
                </th>
                <th style="border:10px">
                    <a href="../ServletAlbum/lister">
                    <div style="width: 175px; height: 250px; background-color: black">
                        <div style="font-size:120px; width: 100%; height: 70%"> 
                            <i style="margin:8% 15%; color: white" class="fa-solid fa-record-vinyl"></i>
                        </div>
                        <div>
                            <p style="text-align: center; margin-top: 15px; color: white">Les albums</p>
                        </div>
                    </div>
                    </a>
                </th>
                <th style="border:100px">
                    <a href="../ServletFestival/lister">
                    <div style="width: 175px; height: 250px; background-color: black">
                        <div style="font-size:120px; width: 100%; height: 70%"> 
                            <i style="margin:8% 12%; color: white" class="fa-solid fa-ticket"></i>
                        </div>
                        <div>
                            <p style="text-align: center; margin-top: 15px; color: white">Les festivals</p>
                        </div>
                    </div>
                    </a>
                </th>
            </tr>
        </table>
        
        <div>
            <p style="margin-left: 10%; color: white; font-size: 30px">Retrouvez les artistes, leurs albums, les festivals <br>
                et les musiques de la région normande</p>
        </div>
        <div align=right style=" width: 100px; height: 100px; position: absolute; right: 0">
            <img style="float: right; width: 100%; height: 100%" src="https://d1csarkz8obe9u.cloudfront.net/posterpreviews/abstract-royalty-free-album-cover-design-template-2c32911349349393a5b3bf5de27e5f0b_screen.jpg?ts=1637986268" />
        </div>
    </div>
     
</html>
