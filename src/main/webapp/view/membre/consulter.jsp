<%-- 
    Document   : consulter
    Created on : 10 oct. 2022, 11:02:46
    Author     : arnaud
--%>
<%@page import="model.Membre"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <%@ include file="/view/header.jsp" %> <%@ include file="/view/body.jsp" %>   <%@ include file="/view/nav.jsp" %>

<%
    Membre unMembre = (Membre)request.getAttribute("pMembre");
%>
<h1 style="text-align: center; margin: 2%; color: black">Fiche : <%out.println(unMembre.getNom() +" "+ unMembre.getPrenom());%></h1>
<br/>
<div class="center" style="margin: 0 10%; background-color:rgba(255, 255, 255, 0.5); border: 10px solid rgba(255, 255, 255, 0.5); border-radius: 10px;">
<p>Instrument joué : <%out.println(unMembre.getInstrument().getLibelle());%></p>
<p>Statut : <%out.println(unMembre.getStatut().getLibelleStatut());%></p>
</div>

</body>
</html>