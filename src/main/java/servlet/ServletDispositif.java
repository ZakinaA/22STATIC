/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.DaoDispositif;
import dao.DaoMembre;
import dao.Utilitaire;
import form.FormDispositif;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Dispositif;
import model.Membre;

/**
 *
 * @author sio2
 */
public class ServletDispositif extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Connection connection;
    static PreparedStatement requete = null;
    static ResultSet rs = null;

    @Override
    public void init() {

        ServletContext servletContext = getServletContext();
        connection = (Connection) servletContext.getAttribute("connection");

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletDispositif</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletDispositif at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI();

        System.out.println("servlerdispositif url=" + url);
        HttpSession session = request.getSession();

        if (url.equals("/STATIC/ServletDispositif/lister")) {
            System.out.println("servlerdispositif LESDISPOSITIFS");
            ArrayList<Dispositif> lesDispositifs = DaoDispositif.getLesDispositifs(connection);
            request.setAttribute("pLesDispositifs", lesDispositifs);
            this.getServletContext().getRequestDispatcher("/view/dispositif/lister.jsp").forward(request, response);
        }

        if (url.equals("/STATIC/ServletDispositif/consulter")) {
            int idDispositif = Integer.parseInt(request.getParameter("idDispositif"));
            Dispositif leDispositif = DaoDispositif.getLeDispositif(connection, idDispositif);
            request.setAttribute("pDispositif", leDispositif);
            this.getServletContext().getRequestDispatcher("/view/dispositif/consulter.jsp").forward(request, response);
        }

        if (url.equals("/STATIC/ServletDispositif/ajouter")) {
            if (session.getAttribute("nomPartenaire") != null && session.getAttribute("nomPartenaire").equals("admin")) {
                System.out.println("servlerdispositif LESDISPOSITIFS");
                ArrayList<Dispositif> lesDispositifs = DaoDispositif.getLesDispositifs(connection);
                request.setAttribute("pLesDispositifs", lesDispositifs);
                this.getServletContext().getRequestDispatcher("/view/dispositif/ajouter.jsp").forward(request, response);
            }else{
                response.sendRedirect("http://172.20.177.250:8080/STATIC/index.jsp");
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        FormDispositif form = new FormDispositif();

        /* Appel au traitement et à la validation de la requête, et récupération de l'objet en résultant */
        Dispositif leDispositifSaisi = form.ajouterDispositif(request);

        /* Stockage du formulaire et de l'objet dans l'objet request */
        request.setAttribute("form", form);
        request.setAttribute("pDispositif", leDispositifSaisi);

        if (form.getErreurs().isEmpty()) {
            // Il n'y a pas eu d'erreurs de saisie, donc on renvoie la vue affichant les infos du groupe
            Dispositif dispositifAjoute = DaoDispositif.ajouterDispositif(connection, leDispositifSaisi);

            if (dispositifAjoute != null) {
                Dispositif leDispositif = DaoDispositif.getLeDispositif(connection, leDispositifSaisi.getId());
                request.setAttribute("pDispositif", leDispositif);
                this.getServletContext().getRequestDispatcher("/view/dispositif/consulter.jsp").forward(request, response);
            } else {
                // Cas où l'insertion en bdd a échoué
                //On renvoie vers le formulaire
                this.getServletContext().getRequestDispatcher("/view/dispositif/ajouter.jsp").forward(request, response);
            }
        } else {
            this.getServletContext().getRequestDispatcher("/view/dispositif/ajouter.jsp").forward(request, response);
        }
    }

    //fermeture des ressources
    public void destroy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //fermeture
            System.out.println("Connexion fermée");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur lors de l’établissement de la connexion");
        } finally {
            //Utilitaire.fermerConnexion(rs);
            //Utilitaire.fermerConnexion(requete);
            Utilitaire.fermerConnexion(connection);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
