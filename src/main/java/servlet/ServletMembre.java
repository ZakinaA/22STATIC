/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.DaoAdmin;
import dao.DaoDispositif;
import dao.DaoGroupe;
import dao.DaoMembre;
import dao.DaoPartenaire;
import dao.DaoUtilisateur;
import dao.Utilitaire;
import form.FormGroupe;
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
import javax.servlet.http.HttpSession;
import static jdk.vm.ci.meta.JavaKind.Int;
import model.Dispositif;
import model.Genre;
import model.Groupe;
import model.Instrument;
import model.Membre;
import model.Partenaire;
import model.Statut;
import model.Utilisateur;

/**
 *
 * @author sio2
 */
public class ServletMembre extends HttpServlet {

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
            out.println("<title>Servlet ServletMembre</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletMembre at " + request.getContextPath() + "</h1>");
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
        
        HttpSession session = request.getSession();
       if(url.equals("/normanzik/ServletMembre/consulter"))
        {   
            if(request.getParameter("idMembre")!=null){
                int idMembre = Integer.parseInt(request.getParameter("idMembre"));
                Membre leMembre = DaoMembre.getLeMembre(connection, idMembre);
                request.setAttribute("pMembre", leMembre);
                this.getServletContext().getRequestDispatcher("/view/membre/consulter.jsp" ).forward( request, response );
            }else{
                int idMembre = (int)session.getAttribute("idMembre");
                Membre leMembre = DaoMembre.getLeMembre(connection, idMembre);
                request.setAttribute("pMembre", leMembre);
                this.getServletContext().getRequestDispatcher("/view/membre/consulter.jsp" ).forward( request, response );
            }
        }
       
        if(url.equals("/normanzik/ServletMembre/ajouter"))
        {
            ArrayList<Statut> lesStatuts = DaoAdmin.getLesStatuts(connection);
            request.setAttribute("pLesStatuts", lesStatuts);
            ArrayList<Instrument> lesInstruments = DaoAdmin.getLesInstruments(connection);
            request.setAttribute("pLesInstruments", lesInstruments);
            this.getServletContext().getRequestDispatcher("/view/membre/ajouter.jsp" ).forward( request, response );
        }
        
        if(url.equals("/normanzik/ServletMembre/groupe")){
            int idMembre = (int)session.getAttribute("idMembre");
            Groupe leGroupe = DaoGroupe.getLeGroupeduMembre(connection, idMembre);
            request.setAttribute("pGroupe", leGroupe);
            ArrayList<Groupe> lesGroupes = DaoGroupe.getLesGroupesByMembre(connection, idMembre);
            request.setAttribute("pLesGroupes", lesGroupes);
            this.getServletContext().getRequestDispatcher("/view/membre/groupe.jsp" ).forward( request, response );
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
        
        FormMembre form = new FormMembre();

        /* Appel au traitement et ?? la validation de la requ??te, et r??cup??ration de l'objet en r??sultant */
        Utilisateur unUtilisateur = form.ajouterMembre(request);

        /* Stockage du formulaire et de l'objet dans l'objet request */
        request.setAttribute( "form", form );
        request.setAttribute( "pMembre", unUtilisateur );

        if (form.getErreurs().isEmpty()){
            // Il n'y a pas eu d'erreurs de saisie, donc on renvoie la vue affichant les infos du membre
            Utilisateur membreAjoute = DaoMembre.ajouterMembre(connection, unUtilisateur);
            Utilisateur utilisateurAjoute = DaoUtilisateur.ajouterUtilisateur(connection, unUtilisateur);
            
            if (membreAjoute != null ){
                Membre leMembre = DaoMembre.getLeMembre(connection, unUtilisateur.getMembre().getId());
                request.setAttribute("pMembre", leMembre);
                this.getServletContext().getRequestDispatcher("/view/membre/consulter.jsp" ).forward( request, response );
            }
            else
            {
                // Cas o?? l'insertion en bdd a ??chou??
                //On renvoie vers le formulaire
                ArrayList<Statut> lesStatuts = DaoAdmin.getLesStatuts(connection);
                request.setAttribute("pLesStatuts", lesStatuts);
                ArrayList<Instrument> lesInstruments = DaoAdmin.getLesInstruments(connection);
                request.setAttribute("pLesInstruments", lesInstruments);
                System.out.println("le membre est null en bdd- echec en bdd");
                this.getServletContext().getRequestDispatcher("/view/membre/ajouter.jsp" ).forward( request, response );
            }
        }
        else
        {

            // il y a des erreurs de saisie. On r??affiche le formulaire avec des messages d'erreurs
            ArrayList<Statut> lesStatuts = DaoAdmin.getLesStatuts(connection);
                request.setAttribute("pLesStatuts", lesStatuts);
                ArrayList<Instrument> lesInstruments = DaoAdmin.getLesInstruments(connection);
                request.setAttribute("pLesInstruments", lesInstruments);
            this.getServletContext().getRequestDispatcher("/view/membre/ajouter.jsp" ).forward( request, response );
        }
    }

    //fermeture des ressources
    public void destroy(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        try
        {
            //fermeture
            System.out.println("Connexion ferm??e");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Erreur lors de l?????tablissement de la connexion");
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
