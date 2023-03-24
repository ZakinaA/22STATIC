<%@page import="model.Groupe"%>
<%@page import="model.Dispositif"%>
<%@ page import="java.util.ArrayList" %>

    <%@ include file="/view/header.jsp" %> <%@ include file="/view/body.jsp" %>   <%@ include file="/view/nav.jsp" %>
<%
    Dispositif unDispositif = (Dispositif)request.getAttribute("pDispositif");
%>
<h1 style="text-align: center; margin: 2%; color: black">Consulter <%out.println(unDispositif.getLibelle());%></h1>
<br/>





<div class="center container px-4 px-lg-5">
    <table  class="center table table-bordered table-striped table-condensed rounded" style="background-color:rgba(255, 255, 255, 0.5); border: 10px solid rgba(255, 255, 255, 0.5); border-radius: 10px; ">
        <thead>
        <tr>
            <th>Nom</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <tr>
            <%
                for (int i=0; i<unDispositif.getLesGroupes().size(); i++) {
                    Groupe gro = unDispositif.getLesGroupes().get(i);
                    
                    out.println("<tr><td>");
                    out.println("<a href ='../ServletGroupe/consulter?idGroupe=" + gro.getId() + "'>");
                    out.println(gro.getNom());
                    out.println("</td>");

                }

            %>
        </tr>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>