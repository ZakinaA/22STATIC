<%-- 
    Document   : index
    Created on : 12 oct. 2022, 10:59:01
    Author     : sio2
--%>

<%@page import="model.Groupe"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <%@ include file="/view/header.jsp" %> <%@ include file="/view/body.jsp" %>   <%@ include file="/view/nav.jsp" %>
       
        <h1 style="text-align: left; margin: 8% 2% 5% 10%; color: white; font-size: 50px">Découvrez la musique de votre région</h1>
    <%
        ArrayList<Groupe> lesGroupes = (ArrayList)request.getAttribute("pLesGroupes");
    %>
    <img class="img-thumbnail" style="display: flex; position: absolute; top: 30%; right: 10%; width: 30%;" src="https://www.adobe.com/fr/express/create/cover/media_18d167bb3f9bbb450af1f75b3e98a29856b16e5b3.jpeg?width=400&format=jpeg&optimize=medium">
    <div>
        
        <table class="table-index" style="margin: 5% 5% 5% 10%">
            <tr>
                <th style="border:10px">
                    <a  href="http://localhost:8080/STATIC/ServletGroupe/lister">
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
                    <a href="http://localhost:8080/STATIC/ServletAlbum/lister">
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
                    <%--<a href="../ServletFestival/lister">--%>
                        <a href="http://localhost:8080/STATIC/ServletFestival/lister">
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
                <th style="border:100px">
                    <a href="http://localhost:8080/STATIC/ServletConnexion/connexion">
                        <a href="http://localhost:8080/STATIC/ServletConnexion/connexion">
                    <div style="width: 175px; height: 250px; background-color: black">
                        <div style="font-size:120px; width: 100%; height: 70%"> 
                            <i style="margin:8% 12%; color: white" class="fa-solid fa-arrow-right-to-bracket"></i>
                        </div>
                        <div>
                            <p style="text-align: center; margin-top: 15px; color: white">Connexion</p>
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
    </div>
                            
</html>
