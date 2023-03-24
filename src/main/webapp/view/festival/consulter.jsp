<%-- 
    Document   : consulter
    Created on : 10 oct. 2022, 11:19:49
    Author     : guillaume martin
--%>

<%@page import="model.Programmer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Festival"%>
<%@page import="model.Groupe"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/view/header.jsp" %>
<%
    Festival leFestival = (Festival) request.getAttribute("pFestival");
%>
<body style="background-image: url('<%= leFestival.getLogo()%>'); background-size:14%; min-height: 100vh; height: 100%;">
<%@ include file="/view/nav.jsp" %>
<h1 class="custom-title" style="text-align: center; margin: 2%; color: #FFFFFF;"><% out.println(leFestival.getNom()); %></h1>
    <br/>

    <div class="center container px-4 px-lg-5">
        <table class="center table table-bordered table-striped table-condensed rounded" style="background-color:rgba(255, 255, 255, 0.7); border: 10px solid rgba(255, 255, 255, 0.5); border-radius: 10px; ">
            <thead>
                <tr>
                    <th>Nom</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                        if (leFestival.getLesProgrammer().size() > 0) {
                            for (Programmer unProgrammer : leFestival.getLesProgrammer()) {
                                out.println("<tr><td>");
                                out.println("<a href ='../ServletGroupe/consulter?idGroupe=" + unProgrammer.getLeGroupe().getId() + "'>");
                                out.println(unProgrammer.getLeGroupe().getNom());
                                out.println("</a></td>");
                            }
                        } else {
                            out.println("vide");
                        }
                    %>
                </tr>
            </tbody>
        </table>
    </div>
</body>
</html>
