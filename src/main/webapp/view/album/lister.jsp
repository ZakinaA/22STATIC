<%-- 
    Document   : lister
    Created on : 17 oct. 2022, 11:38:45
    Author     : sio2
--%>

<%@page import="model.Groupe"%>
<%@page import="form.FormAlbum"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Album"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="/view/header.jsp" %> <%@ include file="/view/body.jsp" %>   <%@ include file="/view/nav.jsp" %>
<%
    ArrayList<Album> lesAlbums = (ArrayList) request.getAttribute("pLesAlbums");
    ArrayList<Groupe> lesGroupes = (ArrayList) request.getAttribute("pLesGroupes");
    FormAlbum form = (FormAlbum) request.getAttribute("form");
%>
<h1 style="text-align: center; margin: 2%; color: black">Les albums</h1>
<body>
    <div class="center container px-4 px-lg-5">
        <table class="center table table-bordered table-striped table-condensed rounded" style="background-color:rgba(255, 255, 255, 0.5); border: 10px solid rgba(255, 255, 255, 0.5); border-radius: 10px; "> 
            <tbody>
                <%
                    int i = 0;
                    for (Album unAlbum : lesAlbums) {
                        String dateStr = unAlbum.getDateCreation();
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                        Date date = format.parse(dateStr);
                        format.applyPattern("dd/MM/yyyy");
                        String dateFormatted = format.format(date);

                        if (unAlbum.getArchiver() == 0) {
                            i++;
                            // Affiche tout les albums
                            if (i == 0) {
                                out.println("<tr>");
                            }
                            out.println("<td>");

                            out.println("<div class='card' style='width: 18rem; height: 31.574rem;'>");
                            out.println("<img src='" + unAlbum.getCheminImg() + "' class='card-img-top'>");
                            out.println("<div class='card-body'>");
                            out.println("<h5 class='card-title font-weight-bold'>" + unAlbum.getNom() + "</h5>");
                            out.println("<p class='card-text'>" + unAlbum.getDescription() + "</p>");
                            out.println("<p class='card-text card-title'><small class='text-muted'>" + dateFormatted + "</small></p>");
                            out.println("<div class='d-flex'>");
                            out.println("<a href='../ServletAlbum/consulter?idAlbum=" + unAlbum.getId() + "' class='btn btn-primary'>Consulter l'album</a>");
                            if (nomPartenaire != null && nomPartenaire.equals("admin")) {
                                out.println("<a href='../ServletAlbum/archiver?idAlbum=" + unAlbum.getId() + "' class='btn btn-danger'>Supprimer</a>");
                            }
                            out.println("</div>");
                            out.println("</div>");
                            out.println("</div>");
                            out.println("</td>");
                            if (i == 4) {
                                out.println("</tr>");
                                i = 0;
                            }
                        }
                    } // Boucle for unAlbum : lesAlbums

                    // Card ajouter un album
                    if (nomPartenaire != null && nomPartenaire.equals("admin")) {
                        i++;
                        if (i == 0) {
                            out.println("<tr>");
                        }
                        out.println("<td>");

                        //DEV - Formulaire d'ajout
                        out.println("<div class='card border-success' style='width: 18rem; height: 31.574rem;'>");
                        out.println("<img src='https://cdn-icons-png.flaticon.com/512/49/49750.png' class='card-img-top'>");
                        out.println("<div class='card-body border-top'>");
                        out.println("<h5 class='card-title font-weight-bold'>Ajouter un album !</h5>");
                        out.println("<p class='card-text'>Some quick example text to build on the card title and make up the bulk of the card's content.</p>");
                        out.println("<p class='card-text card-title'><small class='text-muted'>ADMIN</small></p>");
                        out.println("<div class='d-flex'>");
                        out.println("<button type='button' class='btn btn-success' data-toggle='modal' data-target='#ajouterAlbumModal'>Ajouter un album</button>");
                        out.println("</div>");
                        out.println("</div>");
                        out.println("</div>");

                        out.println("<div class='modal fade' id='ajouterAlbumModal' tabindex='-1' role='dialog' aria-labelledby='ajouterAlbumModalLabel' aria-hidden='true'>");
                        out.println("<div class='modal-dialog modal-dialog-centered'>");
                        out.println("<div class='modal-content'>");
                        out.println("<div class='modal-header'>");
                        out.println("<h5 class='modal-title' id='ajouterAlbumModalLabel'>Ajouter un album</h5>");
                        out.println("<button type='button' class='close' data-dismiss='modal' aria-label='Close'>");
                        out.println("<span aria-hidden='true'>&times;</span>");
                        out.println("</button>");
                        out.println("</div>");
                        out.println("<div class='modal-body' style='max-height: 500px; overflow-y: auto;'>");
                        out.println("<form action='ajouter' method='post'>");
                        out.println("<div class='form-group'>");
                        out.println("<label for='nom'>Nom :</label>");
                        out.println("<input type='text' placeholder='Nom de l&apos;album' class='form-control' id='nom' name='nom' required>");
                        out.println("</div>");
                        out.println("<div class='form-group'>");
                        out.println("<label for='lienPlaylist'>Lien playlist :</label>");
                        out.println("<input type='text' placeholder='Lien spotify' class='form-control' id='lienPlaylist' name='lienPlaylist' required>");
                        out.println("</div>");
                        out.println("<div class='form-group'>");
                        out.println("<label for='groupeId'>Groupe :</label>");
                        out.println("<select class='form-control' id='groupeId' name='groupeId'>");
                        out.println("<option value=''>Sélectionnez un groupe</option>");
                        for (Groupe groupe : lesGroupes) {
                            out.println("<option value='" + groupe.getId() + "'>" + groupe.getNom() + "</option>");
                        }
                        out.println("</select>");
                        out.println("</div>");
                        out.println("<div class='form-group'>");
                        out.println("<label for='description'>Description :</label>");
                        out.println("<textarea class='form-control' id='description' name='description' rows='3' required></textarea>");
                        out.println("</div>");
                        out.println("<div class='form-group'>");
                        out.println("<label for='date'>Date :</label>");
                        out.println("<input type='date' class='form-control' id='date' name='date' required>");
                        out.println("</div>");
                        out.println("<div class='form-group'>");
                        out.println("<label for='imageUpload'>Image :</label>");
                        out.println("<input type='text' placeholder='https://nom_image.jpg' class='form-control' id='image' name='image' required>");
                        out.println("</div>");
                        out.println("</div>");
                        out.println("<div class='modal-footer'>");
                        out.println("<button type='button' class='btn btn-secondary' data-dismiss='modal'>Fermer</button>");
                        out.println("<button type='submit' class='btn btn-success'>Ajouter un album</button>");
                        out.println("</div>");
                        out.println("</form>");
                        out.println("</div>");
                        out.println("</div>");
                        out.println("</div>");

                        out.println("</td>");
                        if (i == 4) {
                            out.println("</tr>");
                            i = 0;
                        }

                        for (Album unAlbum : lesAlbums) {
                            String dateStr = unAlbum.getDateCreation();
                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            Date date = format.parse(dateStr);
                            format.applyPattern("dd/MM/yyyy");
                            String dateFormatted = format.format(date);

                            if (unAlbum.getArchiver() == 1) {
                                i++;
                                // Affiche tout les albums
                                if (i == 0) {
                                    out.println("<tr>");
                                }
                                out.println("<td>");

                                out.println("<div class='card text-white bg-danger' style='width: 18rem; height: 31.574rem;'>");
                                out.println("<img src='" + unAlbum.getCheminImg() + "' class='card-img-top'>");
                                out.println("<div class='card-body'>");
                                out.println("<h5 class='card-title font-weight-bold'>" + unAlbum.getNom() + "</h5>");
                                out.println("<p class='card-text'>" + unAlbum.getDescription() + "</p>");
                                out.println("<p class='card-text card-title'><small class='text-muted'>" + dateFormatted + "</small></p>");
                                out.println("<div class='d-flex'>");
                                out.println("<a href='../ServletAlbum/consulter?idAlbum=" + unAlbum.getId() + "' class='btn btn-primary'>Consulter l'album</a>");
                                out.println("<a href='../ServletAlbum/dearchiver?idAlbum=" + unAlbum.getId() + "' class='btn btn-success'>Ajouter</a>");
                                out.println("</div>");
                                out.println("</div>");
                                out.println("</div>");
                                out.println("</td>");
                                if (i == 4) {
                                    out.println("</tr>");
                                    i = 0;
                                }
                            }
                        } // Boucle for unAlbum : lesAlbums
                    }

                %>
            </tbody>
        </table>
    </div>
</body>
</html>