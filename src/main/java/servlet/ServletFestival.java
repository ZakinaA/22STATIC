/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.DaoFestival;
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
import model.Festival;
import model.Groupe;

/**
 *
 * @author Guillaume martin
 */


@WebServlet(name = "ServletFestival", urlPatterns = {"/ServletFestival"})
public class ServletFestival extends HttpServlet {

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
            out.println("<title>Servlet ServletFestival</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletFestival at " + request.getContextPath() + "</h1>");
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
        
        System.out.println("servlerfestival url="+url);
        
        if(url.equals("/STATIC/ServletFestival/lister")){
            System.out.println("servlerfestival LESFESTIVALS");
            ArrayList<Festival> lesFestivals = DaoFestival.getLesFestivals(connection);
            request.setAttribute("pLesFestivals", lesFestivals);
            this.getServletContext().getRequestDispatcher("/view/festival/lister.jsp" ).forward( request, response );
        }
        
        if(url.equals("/STATIC/ServletFestival/consulter"))
        {
            int idFestival = Integer.parseInt(request.getParameter("idFestival"));
            ArrayList<Groupe> lesGroupes = DaoFestival.getLesGroupesFestival(connection, idFestival);
            request.setAttribute("pLesGroupesDuFestival", lesGroupes);
            this.getServletContext().getRequestDispatcher("/view/festival/consulter.jsp" ).forward( request, response );
        }
        if(url.equals("/STATIC/ServletFestival/ajouter"))
        {
            System.out.println("servlerfestival LESFESTIVALS");
            ArrayList<Festival> lesFestivals = DaoFestival.getLesFestivals(connection);
            request.setAttribute("pLesFestivals", lesFestivals);
            this.getServletContext().getRequestDispatcher("/view/festival/ajouter.jsp" ).forward( request, response );
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
