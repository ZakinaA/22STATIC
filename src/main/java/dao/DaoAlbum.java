/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.DaoAlbum.requete;
import static dao.DaoAlbum.rs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Album;
import model.Groupe;
import model.Titre;
import test.ConnexionBdd;

/**
 *
 * @author sio2
 */
public class DaoAlbum {

    Connection connection = null;
    static PreparedStatement requete = null;
    static ResultSet rs = null;

    public static ArrayList<Album> getLesAlbums(Connection connection) {
        ArrayList<Album> lesAlbums = new ArrayList<Album>();
        try {
            //preparation de la requete
            requete = connection.prepareStatement("select * from album");
            System.out.println("Requete" + requete);

            //executer la requete
            rs = requete.executeQuery();

            //On hydrate l'objet métier Album et sa relation Genre avec les résultats de la requête
            while (rs.next()) {

                Album leAlbum = new Album();
                leAlbum.setId(rs.getInt("alb_id"));
                leAlbum.setNom(rs.getString("nom"));
                leAlbum.setDateCreation(rs.getString("dateCreation"));
                leAlbum.setCheminImg(rs.getString("cheminImg"));
                leAlbum.setDescription(rs.getString("description"));
                leAlbum.setArchiver(rs.getInt("archiver"));

                ArrayList<Titre> lesTitresAlbum = DaoTitre.getLesTitresAlbum(connection, rs.getInt("alb_id"));
                leAlbum.setLesTitres(lesTitresAlbum);

                lesAlbums.add(leAlbum);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesAlbums;
    }

    public static ArrayList<Album> getLesAlbumsByGroupe(Connection connection, int idGroupe) {
        ArrayList<Album> lesAlbums = new ArrayList<Album>();
        try {
            //preparation de la requete
            requete = connection.prepareStatement("select * from album where idGroupe = ?");
            requete.setInt(1, idGroupe);
            System.out.println("Requete" + requete);

            //executer la requete
            rs = requete.executeQuery();

            //On hydrate l'objet métier Album et sa relation Genre avec les résultats de la requête
            while (rs.next()) {

                Album leAlbum = new Album();
                leAlbum.setId(rs.getInt("alb_id"));
                leAlbum.setNom(rs.getString("nom"));
                leAlbum.setDateCreation(rs.getString("dateCreation"));
                leAlbum.setCheminImg(rs.getString("cheminImg"));
                leAlbum.setDescription(rs.getString("description"));
                leAlbum.setArchiver(rs.getInt("archiver"));

                ArrayList<Titre> lesTitresAlbum = DaoTitre.getLesTitresAlbum(connection, rs.getInt("alb_id"));
                leAlbum.setLesTitres(lesTitresAlbum);

                lesAlbums.add(leAlbum);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesAlbums;
    }

    public static Album getLeAlbum(Connection connection, int idAlbum) {
        Album leAlbum = new Album();
        try {
            //preparation de la requete
            requete = connection.prepareStatement("select * from album where alb_id=?");
            requete.setInt(1, idAlbum);
            System.out.println("Requete" + requete);

            //executer la requete
            rs = requete.executeQuery();

            //On hydrate l'objet métier Album et sa relation Genre avec les résultats de la requête
            if (rs.next()) {

                leAlbum.setId(rs.getInt("alb_id"));
                leAlbum.setNom(rs.getString("nom"));
                leAlbum.setDateCreation(rs.getString("dateCreation"));
                leAlbum.setCheminImg(rs.getString("cheminImg"));
                leAlbum.setLienAlbum(rs.getString("lienAlbum"));
                leAlbum.setDescription(rs.getString("description"));
                leAlbum.setArchiver(rs.getInt("archiver"));

                Connection con = ConnexionBdd.ouvrirConnexion();
                ArrayList<Titre> lesTitresAlbum = DaoTitre.getLesTitresAlbum(con, idAlbum);
                leAlbum.setLesTitres(lesTitresAlbum);

                Groupe leGroupe = DaoGroupe.getLeGroupe(con, rs.getInt("idGroupe"));
                leAlbum.setGroupe(leGroupe);

                ConnexionBdd.fermerConnexion(con);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return leAlbum;
    }

    public static Album ajouterAlbum(Connection connection, Album unAlbum) {
        int idGenere = -1;
        try {
            requete = connection.prepareStatement("INSERT INTO ALBUM (nom, dateCreation, cheminImg, idGroupe, description)\n"
                    + "VALUES (?,?,?,?,?)", requete.RETURN_GENERATED_KEYS);
            requete.setString(1, unAlbum.getNom());
            requete.setString(2, unAlbum.getDateCreation());
            requete.setString(3, unAlbum.getCheminImg());
            requete.setInt(4, unAlbum.getGroupe().getId());
            requete.setString(5, unAlbum.getDescription());

            System.out.println("requeteInsertion=" + requete);
            /* Exécution de la requête */
            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            // Récupération de id auto-généré par la bdd dans la table groupe
            rs = requete.getGeneratedKeys();
            while (rs.next()) {
                idGenere = rs.getInt(1);
                unAlbum.setId(idGenere);
            }

            // si le résultat de la requete est différent de 1, c'est que la requête a échoué.
            // Dans ce cas, on remet l'objet groupe à null
            if (resultatRequete != 1) {
                unAlbum = null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
            unAlbum = null;
        }
        return unAlbum;
    }

    public static int desinscrireAlbum(Connection connection, int idAlbum){
        try
        {
            requete = connection.prepareStatement("UPDATE album SET archiver = 1 WHERE alb_id = ?");
            requete.setInt(1, idAlbum);
            
            System.out.println("requete updateDesInscriptionGroupe=" + requete);
            

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultat requete=" + resultatRequete);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return idAlbum;
    }
    
    public static int inscrireAlbum(Connection connection, int idAlbum){
        try
        {
            requete = connection.prepareStatement("UPDATE album SET archiver = 0 WHERE alb_id = ?");
            requete.setInt(1, idAlbum);
            
            System.out.println("requete updateDesInscriptionGroupe=" + requete);
            

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultat requete=" + resultatRequete);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return idAlbum;
    }

}
