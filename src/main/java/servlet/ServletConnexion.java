/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.DaoConnexion;
import dao.DaoGroupe;
import dao.DaoMembre;
import form.FormConnexion;
import form.FormMembre;
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
import model.Groupe;
import model.Membre;
import model.Utilisateur;
import static test.ConnexionBdd.connection;

/**
 *
 * @author arnaud.le_cozannet
 */
@WebServlet(name = "ServletConnexion", urlPatterns = {"/ServletConnexion"})
public class ServletConnexion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    Connection connection ;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
     @Override
    public void init()
    {
        
        ServletContext servletContext=getServletContext();
        connection=(Connection)servletContext.getAttribute("connection");
        
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletConnexion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletConnexion at " + request.getContextPath() + "</h1>");
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
        
        System.out.println("servlermembre url="+url);
        
        if(url.equals("/STATIC/ServletConnexion/connexion"))
        {
            this.getServletContext().getRequestDispatcher("/view/connexion/connexion.jsp" ).forward( request, response );
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
        
        FormConnexion form = new FormConnexion();
        
        
        Utilisateur lUtilisateur = form.connexion(request);  
        
        
        request.setAttribute( "form", form );
        request.setAttribute( "pUtilisateur", lUtilisateur );
        
        if (form.getErreurs().isEmpty()){
            Utilisateur connecter = DaoConnexion.getLeUtilisateur(connection, lUtilisateur);
            if(connecter.getLogin() == null){
                this.getServletContext().getRequestDispatcher("/view/connexion/connexion.jsp" ).forward( request, response );
            }
            else if (connecter.getMembre() != null ){
                int idMembre = connecter.getMembre().getId();
                Groupe leGroupe = DaoGroupe.getLeGroupeduMembre(connection, idMembre);
                request.setAttribute("pGroupe", leGroupe);
                ArrayList<Groupe> lesGroupes = DaoGroupe.getLesGroupesByMembre(connection, idMembre);
                request.setAttribute("pLesGroupes", lesGroupes);
                this.getServletContext().getRequestDispatcher("/view/membre/groupe.jsp" ).forward( request, response );
            }
            else if (connecter.getPartenaire() != null ){
                ArrayList<Groupe> lesGroupes = DaoGroupe.getLesGroupes(connection);
                request.setAttribute("pLesGroupes", lesGroupes);
                this.getServletContext().getRequestDispatcher("/view/jury/lister.jsp" ).forward( request, response );
            }
        }
        else{
            this.getServletContext().getRequestDispatcher("/view/connexion/connexion.jsp" ).forward( request, response );
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
