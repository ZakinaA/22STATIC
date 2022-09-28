/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.DaoGroupe.requete;
import static dao.DaoGroupe.rs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Dispositif;
import model.Groupe;
import model.Membre;
import model.Titre;
import test.ConnexionBdd;

/**
 *
 * @author sio2
 */
public class DaoDispositif {
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;

    public static ArrayList<Dispositif> getLesDispositifs(Connection connection){
        ArrayList<Dispositif> lesDispositifs = new  ArrayList<Dispositif>();
        try
        {
            //preparation de la requete
            requete=connection.prepareStatement("select * from dispositif");
            System.out.println("Requete" + requete);

            //executer la requete
            rs=requete.executeQuery();

            //On hydrate l'objet métier Dispositif et sa relation Genre avec les résultats de la requête
            while ( rs.next() ) { 

                Dispositif leDispositif = new Dispositif();
                leDispositif.setId(rs.getInt("dis_id"));
                leDispositif.setAnnee(rs.getInt("annee"));
                leDispositif.setLibelle(rs.getString("libelle"));
                
                lesDispositifs.add(leDispositif);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesDispositifs ;
    }
    
    public static Dispositif getLeDispositif(Connection connection, int idDispositif){
        Dispositif leDispositif = new Dispositif();
        try
        {
            //preparation de la requete
            requete=connection.prepareStatement("select * from dispositif where dis_id=?");
            requete.setInt(1, idDispositif);
            System.out.println("Requete" + requete);

            //executer la requete
            rs=requete.executeQuery();

            //On hydrate l'objet métier Dispositif et sa relation Genre avec les résultats de la requête
            if ( rs.next() ) {
                
                leDispositif.setId(rs.getInt("dis_id"));
                leDispositif.setAnnee(rs.getInt("annee"));
                leDispositif.setLibelle(rs.getString("libelle"));

                           
                Connection con = ConnexionBdd.ouvrirConnexion();
                ArrayList<Groupe> lesGroupesByDispositif = DaoGroupe.getLesGroupesByDispositif(con, idDispositif);
                leDispositif.setLesGroupes(lesGroupesByDispositif);
                ConnexionBdd.fermerConnexion(con);
                
                ConnexionBdd.fermerConnexion(con);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return leDispositif ;
    }

    
    public static Dispositif ajouterDispositif(Connection connection, Dispositif unDispositif){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("INSERT INTO DISPOSITIF (annee, libelle)\n" +
                    "VALUES (?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setInt(1, unDispositif.getAnnee());
            requete.setString(2, unDispositif.getLibelle());

            System.out.println("requeteInsertion=" + requete);
            /* Exécution de la requête */
            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            // Récupération de id auto-généré par la bdd dans la table groupe
            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unDispositif.setId(idGenere);
            }

            // si le résultat de la requete est différent de 1, c'est que la requête a échoué.
            // Dans ce cas, on remet l'objet groupe à null
            if (resultatRequete != 1){
                unDispositif= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
            unDispositif= null;
        }
        return unDispositif ;
    }
}
