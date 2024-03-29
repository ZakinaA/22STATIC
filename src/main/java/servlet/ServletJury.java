/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import dao.DaoAdmin;
import dao.DaoGroupe;
import dao.DaoJury;
import dao.Utilitaire;
import form.FormGroupe;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Dispositif;
import model.Genre;
import model.Groupe;
import model.Membre;
import static test.ConnexionBdd.connection;

/**
 *
 * @author sio2
 */
public class ServletJury extends HttpServlet{
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     *  Connection connection ;
    static PreparedStatement requete=null;
    static ResultSet rs=null;

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
            out.println("<title>Servlet ServletJury</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletJury at " + request.getContextPath() + "</h1>");
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
        
        System.out.println("ServletJury url="+url);

        //Affichage de tous les groupes (en indiquant le libellé du genre musical)
        if(url.equals("/STATIC/ServletJury/lister")){
             System.out.println("ServletJury LISTER");
            ArrayList<Groupe> lesGroupes = DaoGroupe.getLesGroupes(connection);
            request.setAttribute("pLesGroupes", lesGroupes);
            this.getServletContext().getRequestDispatcher("/view/jury/lister.jsp" ).forward( request, response );
        }

        // Affichage du groupe selectionné (depuis la fonctionnalité lister)
        if(url.equals("/STATIC/ServletJury/inscrire")){
            int idGroupe = Integer.parseInt(request.getParameter("idGroupe"));
            DaoJury.inscrireGroupe(connection, idGroupe);
            ArrayList<Groupe> lesGroupes = DaoGroupe.getLesGroupes(connection);
            request.setAttribute("pLesGroupes", lesGroupes);
            this.getServletContext().getRequestDispatcher("/view/jury/lister.jsp" ).forward( request, response );
        }
        
        if(url.equals("/STATIC/ServletJury/desinscrire")){
            int idGroupe = Integer.parseInt(request.getParameter("idGroupe"));
            DaoJury.desinscrireGroupe(connection, idGroupe);
            ArrayList<Groupe> lesGroupes = DaoGroupe.getLesGroupes(connection);
            request.setAttribute("pLesGroupes", lesGroupes);
            this.getServletContext().getRequestDispatcher("/view/jury/lister.jsp" ).forward( request, response );
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
       

    }

    //fermeture des ressources
    public void destroy(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        try
        {
            //fermeture
            System.out.println("Connexion fermée");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Erreur lors de l’établissement de la connexion");
        }
        finally
        {
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
