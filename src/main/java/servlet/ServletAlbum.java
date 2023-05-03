/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.DaoAdmin;
import dao.DaoAlbum;
import form.FormAlbum;
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
import model.Album;
import model.Groupe;
import model.Titre;

/**
 *
 * @author sio2
 */
@WebServlet(name = "ServletAlbum", urlPatterns = {"/ServletAlbum"})
public class ServletAlbum extends HttpServlet {
    Connection connection ;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
     @Override
    public void init()
    {
        
        ServletContext servletContext=getServletContext();
        connection=(Connection)servletContext.getAttribute("connection");
        
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletAlbum</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletAlbum at " + request.getContextPath() + "</h1>");
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
        // récupération de l url saisie dans le navigateur
        String url = request.getRequestURI();
        
        System.out.println("servleralbum url="+url);
        
        if(url.equals("/STATIC/ServletAlbum/lister")){
            ArrayList<Groupe> lesGroupes = DaoAdmin.getLesGroupes(connection);
            request.setAttribute("pLesGroupes", lesGroupes);
            ArrayList<Album> lesAlbums = DaoAlbum.getLesAlbums(connection);
            request.setAttribute("pLesAlbums", lesAlbums);
            this.getServletContext().getRequestDispatcher("/view/album/lister.jsp" ).forward( request, response );
        }
        
        if(url.equals("/STATIC/ServletAlbum/consulter"))
        {
            int idAlbum = Integer.parseInt(request.getParameter("idAlbum"));
            Album lesTitresAlbum = DaoAlbum.getLeAlbum(connection, idAlbum);
            request.setAttribute("pLesTitresAlbum", lesTitresAlbum);
            this.getServletContext().getRequestDispatcher("/view/album/consulter.jsp" ).forward( request, response );
        }
        
        //DEV - Supprimer la page ajouter et l'enlever du web.xml vu qu'elle est déja dans la page lister
        if(url.equals("/STATIC/ServletAlbum/ajouter"))
        {
            ArrayList<Groupe> lesGroupes = DaoAdmin.getLesGroupes(connection);
            request.setAttribute("pLesGroupes", lesGroupes);
            System.out.println("servlerfestival LESFESTIVALS");
            ArrayList<Album> lesAlbums = DaoAlbum.getLesAlbums(connection);
            request.setAttribute("pLesAlbums", lesAlbums);
            this.getServletContext().getRequestDispatcher("/view/album/ajouter.jsp" ).forward( request, response );
        }
        
        if(url.equals("/STATIC/ServletAlbum/archiver")){
            ArrayList<Groupe> lesGroupes = DaoAdmin.getLesGroupes(connection);
            request.setAttribute("pLesGroupes", lesGroupes);
            int idAlbum = Integer.parseInt(request.getParameter("idAlbum"));
            DaoAlbum.desinscrireAlbum(connection, idAlbum);
            ArrayList<Album> lesAlbums = DaoAlbum.getLesAlbums(connection);
            request.setAttribute("pLesAlbums", lesAlbums);
            this.getServletContext().getRequestDispatcher("/view/album/lister.jsp" ).forward( request, response );
        }
        
        if(url.equals("/STATIC/ServletAlbum/dearchiver")){
            ArrayList<Groupe> lesGroupes = DaoAdmin.getLesGroupes(connection);
            request.setAttribute("pLesGroupes", lesGroupes);
            int idAlbum = Integer.parseInt(request.getParameter("idAlbum"));
            DaoAlbum.inscrireAlbum(connection, idAlbum);
            ArrayList<Album> lesAlbums = DaoAlbum.getLesAlbums(connection);
            request.setAttribute("pLesAlbums", lesAlbums);
            this.getServletContext().getRequestDispatcher("/view/album/lister.jsp" ).forward( request, response );
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
        processRequest(request, response);
        
        FormAlbum form = new FormAlbum();
        
        Album leAlbumSaisi = form.ajouterAlbum(request);
        
        request.setAttribute("form", form);
        request.setAttribute("pAlbum", leAlbumSaisi);
        
        if (form.getErreurs().isEmpty()){
            // Il n'y a pas eu d'erreurs de saisie, donc on renvoie la vue affichant les infos du groupe
            Album albumAjoute = DaoAlbum.ajouterAlbum(connection, leAlbumSaisi);

            if (albumAjoute != null ){
                ArrayList<Groupe> lesGroupes = DaoAdmin.getLesGroupes(connection);
                request.setAttribute("pLesGroupes", lesGroupes);
                ArrayList<Album> lesAlbums = DaoAlbum.getLesAlbums(connection);
                request.setAttribute("pLesAlbums", lesAlbums);
                this.getServletContext().getRequestDispatcher("/view/album/lister.jsp" ).forward( request, response );
            } else {
                // Cas où l'insertion en bdd a échoué
                //On renvoie vers le formulaire
                ArrayList<Groupe> lesGroupes = DaoAdmin.getLesGroupes(connection);
                request.setAttribute("pLesGroupes", lesGroupes);
                ArrayList<Album> lesAlbums = DaoAlbum.getLesAlbums(connection);
                request.setAttribute("pLesAlbums", lesAlbums);
                this.getServletContext().getRequestDispatcher("/view/album/lister.jsp" ).forward( request, response );
            }
        } else
        {
            ArrayList<Groupe> lesGroupes = DaoAdmin.getLesGroupes(connection);
            request.setAttribute("pLesGroupes", lesGroupes);
            ArrayList<Album> lesAlbums = DaoAlbum.getLesAlbums(connection);
            request.setAttribute("pLesAlbums", lesAlbums);
            this.getServletContext().getRequestDispatcher("/view/album/lister.jsp" ).forward( request, response );
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
