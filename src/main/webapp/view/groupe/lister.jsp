<%-- 
    Document   : lister
    Created on : 10 oct. 2022, 11:16:26
    Author     : 
--%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Groupe"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <%@ include file="/view/header.jsp" %> <%@ include file="/view/body.jsp" %>   <%@ include file="/view/nav.jsp" %>
    <h1 style="text-align: center; margin: 2%; color: black">Consulter Groupe</h1>
<br/>


<%
    ArrayList<Groupe> lesGroupes = (ArrayList)request.getAttribute("pLesGroupes");
%>


<div style="margin: 0 10%;  ">
    <table  class="center table table-bordered table-striped table-condensed rounded" style="background-color:rgba(255, 255, 255, 0.5); border: 10px solid rgba(255, 255, 255, 0.5); border-radius: 10px; ">
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
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat sdfMonth = new SimpleDateFormat("MMM", Locale.FRENCH);
                SimpleDateFormat sdfDayOfWeek = new SimpleDateFormat("EEE", Locale.FRENCH);
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
                    out.println("<div class=\"w-32 flex-none rounded-t lg:rounded-t-none lg:rounded-l text-center shadow-lg \">");
                    out.println("<div class=\"block rounded-t overflow-hidden  text-center \">");

                    Date dateCreation = sdf.parse(unGroupe.getDateCreation());
                    
                    out.println("<div class=\"bg-blue-500 text-white py-1\">");
                    out.println(sdfMonth.format(dateCreation) + "  " + sdf.format(dateCreation).split("-")[0]);
                    out.println("</div>");

                    out.println("<div class=\"pt-1 border-l border-r border-white bg-white\">");
                    out.println("<span class=\"text-5xl font-bold leading-tight\">");
                    out.println(sdf.format(dateCreation).split("-")[2]);
                    out.println("</span>");
                    out.println("</div>");

                    out.println("<div class=\"border-l border-r border-b rounded-b-lg text-center border-white bg-white -pt-2 -mb-1\">");
                    out.println("<span class=\"text-sm\">");
                    out.println(sdfDayOfWeek.format(dateCreation));
                    out.println("</span>");
                    out.println("</div>");

                    out.println("<div class=\"pb-2 border-l border-r border-b rounded-b-lg text-center border-white bg-white\">");
                    out.println("<span class=\"text-xs leading-normal\">");
                    out.println(" ");
                    out.println("</span>");
                    out.println("</div>");

                    out.println("</div>");
                    out.println("</div>");
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