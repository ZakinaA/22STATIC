<%-- 
    Document   : nav
    Created on : 20 mars 2023, 16:04:57
    Author     : arnaud.le_cozannet
--%>

<header>
    <!-- HEADER -->
    <nav class="navbar navbar-expand-sm bg-light py-5 px-5" style="opacity: 0.8; height: 13%; box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;">
    </nav>
    <div class="container-fluid" style="position: absolute; top: 22px; ">
        <a class="logo" href="http://localhost:8080/STATIC/index.jsp">
            <img src="https://i.ibb.co/tQRkg9M/logo.png" alt="Logo" width="60" height="60" class="d-inline-block mx-3" >
            Norman'Zik
        </a>
        <div style="position: absolute; top: 5px; right: 0px; width: 850px ">
            <ul>
                <% String url = request.getRequestURI();
                    String nomMembre = (String) session.getAttribute("nomMembre");
                    String nomPartenaire = (String) session.getAttribute("nomPartenaire");

                    if (nomMembre != null) {
                        out.println("<li>connecté en tant que <a href='http://localhost:8080/STATIC/ServletMembre/consulter'>" + nomMembre + "</a></li>");%>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Groupe
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="http://localhost:8080/STATIC/ServletMembre/groupe">Mes groupes</a>
                        <a class="dropdown-item" href="http://localhost:8080/STATIC/ServletGroupe/lister">Lister</a>
                        <a class="dropdown-item" href="http://localhost:8080/STATIC/ServletGroupe/ajouter">Créer</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Festival
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="http://localhost:8080/STATIC/ServletFestival/lister">Lister</a>
                    </div>
                </li>
                <li>
                    <a class="nav-link" href="http://localhost:8080/STATIC/ServletConnexion/deconnexion">Se déconnecter</a>
                </li>
                <%} else if (nomPartenaire != null) {
                    if (nomPartenaire.equals("admin")) {
                        out.println("<li>Connecté en tant qu'" + nomPartenaire + "</li>");%>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Groupe
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="http://localhost:8080/STATIC/ServletGroupe/lister">Lister</a>
                        <a class="dropdown-item" href="http://localhost:8080/STATIC/ServletGroupe/ajouter">Ajouter</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Dispositif
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="http://localhost:8080/STATIC/ServletDispositif/lister">Lister</a>
                        <a class="dropdown-item" href="http://localhost:8080/STATIC/ServletDispositif/ajouter">Ajouter</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Festival
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="http://localhost:8080/STATIC/ServletFestival/lister">Lister</a>
                        <a class="dropdown-item" href="http://localhost:8080/STATIC/ServletFestival/ajouter">Ajouter</a>
                    </div>
                </li>

                <li>
                    <a class="nav-link" href="http://localhost:8080/STATIC/ServletConnexion/deconnexion">Se déconnecter</a>
                </li>
                <% } else {%>
                out.println("<li>Vous êtes le partenaire " + nomPartenaire + "</li>");%>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Jury
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="http://localhost:8080/STATIC/ServletJury/lister">Lister</a>
                    </div>
                </li>
                <li>
                    <a class="nav-link" href="http://localhost:8080/STATIC/ServletConnexion/deconnexion">Se déconnecter</a>
                </li>


                <%}
                } else {%>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Groupe
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="http://localhost:8080/STATIC/ServletGroupe/lister">Lister</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Festival
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="http://localhost:8080/STATIC/ServletFestival/lister">Lister</a>
                    </div>
                </li>
                <li>
                    <a class="nav-link" href="http://localhost:8080/STATIC/ServletMembre/ajouter">
                        Créer un compte
                    </a>
                </li>
                <li>
                    <a class="nav-link" href="http://localhost:8080/STATIC/ServletConnexion/connexion">
                        Se connecter
                    </a>
                </li>
                <%}%>
        </div>
    </div>
</header>
