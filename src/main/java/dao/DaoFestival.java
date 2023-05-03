/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.DaoFestival.requete;
import static dao.DaoFestival.rs;
import static dao.DaoFestival.requete;
import static dao.DaoFestival.rs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.Festival;
import model.Genre;
import model.Festival;
import model.Festival;
import model.Groupe;
import model.Programmer;
import test.ConnexionBdd;

/**
 *
 * @author sio2
 */
public class DaoFestival {
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;

    public static ArrayList<Festival> getLesFestivals(Connection connection){
        ArrayList<Festival> lesFestivals = new  ArrayList<Festival>();
        try
        {
            //preparation de la requete
            requete=connection.prepareStatement("select * from festival");
            System.out.println("Requete" + requete);

            //executer la requete
            rs=requete.executeQuery();

            //On hydrate l'objet métier Festival
            while ( rs.next() ) {


                Festival leFestival = new Festival();
                leFestival.setId(rs.getInt("fes_id"));
                leFestival.setNom(rs.getString("nom"));
                leFestival.setAnnee(rs.getString("annee"));
                leFestival.setDateDebut(rs.getString("dateDebut"));
                leFestival.setDateFin(rs.getString("dateFin"));
                leFestival.setLogo(rs.getString("logo"));
                
                lesFestivals.add(leFestival);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesFestivals ;
    }
    
    public static ArrayList<Groupe> getLesGroupesFestival(Connection connection, int idGroupe){
        ArrayList<Groupe> lesGroupes = new  ArrayList<Groupe>();
        try
        {
            //preparation de la requete
                requete=connection.prepareStatement("SELECT gro_id, groupe.nom FROM groupe, programmer, festival WHERE groupe.gro_id = programmer.idGroupe AND programmer.IdFestival = festival.fes_id AND festival.fes_id = ?");
                requete.setInt(1, idGroupe);
                System.out.println("Requete" + requete);

                //executer la requete
                rs=requete.executeQuery();

            //On hydrate l'objet métier Groupe et sa relation Genre avec les résultats de la requête
            while ( rs.next() ) {


                Groupe leGroupe = new Groupe();
                leGroupe.setId(rs.getInt("gro_id"));
                leGroupe.setNom(rs.getString("groupe.nom"));
                lesGroupes.add(leGroupe);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesGroupes ;
    }
    
     public static Festival getLeFestival(Connection connection, int idFestival){
        Festival leFestival = new Festival();
        try
        {
            //preparation de la requete
            requete=connection.prepareStatement("select * from festival where fes_id=?");
            requete.setInt(1, idFestival);
            System.out.println("Requete" + requete);

            //executer la requete
            rs=requete.executeQuery();

            //On hydrate l'objet métier Festival et sa relation Genre avec les résultats de la requête
            if ( rs.next() ) {
                
                leFestival.setId(rs.getInt("fes_id"));
                leFestival.setNom(rs.getString("nom"));
                leFestival.setAnnee(rs.getString("annee"));
                leFestival.setDateDebut(rs.getString("dateDebut"));
                leFestival.setDateFin(rs.getString("dateFin"));
                leFestival.setLogo(rs.getString("logo"));
                
                ArrayList<Programmer> lesProgrammer = DaoProgrammer.getLesProgrammersByFestival(connection, idFestival);
                leFestival.setLesProgrammer(lesProgrammer);
                
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return leFestival ;
    }

    
    public static Festival ajouterFestival(Connection connection, Festival unFestival){
        int idGenere = -1;
        try
        {
            //DEV faire fonctionner
            requete=connection.prepareStatement("INSERT INTO FESTIVAL (nom, annee, dateDebut, dateFin, logo)\n" +
                    "VALUES (?,?,?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setString(1, unFestival.getNom());
            requete.setString(2, unFestival.getAnnee());
            requete.setDate(3, java.sql.Date.valueOf(unFestival.getDateDebut()));
            requete.setDate(4, java.sql.Date.valueOf(unFestival.getDateFin()));
            requete.setString(5, unFestival.getLogo());

            System.out.println("requeteInsertion=" + requete);
            /* Exécution de la requête */
            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            // Récupération de id auto-généré par la bdd dans la table groupe
            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unFestival.setId(idGenere);
            }

            // si le résultat de la requete est différent de 1, c'est que la requête a échoué.
            // Dans ce cas, on remet l'objet groupe à null
            if (resultatRequete != 1){
                unFestival= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
            unFestival= null;
        }
        return unFestival ;
    }
}
