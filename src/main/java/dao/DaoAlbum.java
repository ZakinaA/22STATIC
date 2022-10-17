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
import model.Titre;
import test.ConnexionBdd;

/**
 *
 * @author sio2
 */
public class DaoAlbum {
     Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;

    public static ArrayList<Album> getLesAlbums(Connection connection){
        ArrayList<Album> lesAlbums = new  ArrayList<Album>();
        try
        {
            //preparation de la requete
            requete=connection.prepareStatement("select * from album");
            System.out.println("Requete" + requete);

            //executer la requete
            rs=requete.executeQuery();

            //On hydrate l'objet métier Album et sa relation Genre avec les résultats de la requête
            while ( rs.next() ) {


                Album leAlbum = new Album();
                leAlbum.setId(rs.getInt("alb_id"));
                leAlbum.setNom(rs.getString("nom"));
                leAlbum.setDateCreation(rs.getString("dateCreation"));
                leAlbum.setCheminImg(rs.getString("cheminImg"));
                
                lesAlbums.add(leAlbum);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesAlbums ;
    }
    public static ArrayList<Titre> getLesTitresAlbum(Connection connection, int idTitre){
        ArrayList<Titre> lesTitres = new  ArrayList<Titre>();
        try
        {
            //preparation de la requete
                requete=connection.prepareStatement("SELECT titre.intitule, titre.duree, titre.lienURL FROM titre, album WHERE titre.idAlbum = album.alb_id AND album.alb_id = ?");
                requete.setInt(1, idTitre);
                System.out.println("Requete" + requete);

                //executer la requete
                rs=requete.executeQuery();

            //On hydrate l'objet métier Titre et sa relation Genre avec les résultats de la requête
            while ( rs.next() ) {


                Titre leTitre = new Titre();
                leTitre.setIntitule(rs.getString("titre.numero"));
                leTitre.setDuree(rs.getString("titre.duree"));
                leTitre.setLienURL(rs.getString("titre.lienURL"));
                lesTitres.add(leTitre);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesTitres ;
    }
    
     public static Album getLeAlbum(Connection connection, int idAlbum){
        Album leAlbum = new Album();
        try
        {
            //preparation de la requete
            requete=connection.prepareStatement("select * from album where alb_id=?");
            requete.setInt(1, idAlbum);
            System.out.println("Requete" + requete);

            //executer la requete
            rs=requete.executeQuery();

            //On hydrate l'objet métier Album et sa relation Genre avec les résultats de la requête
            if ( rs.next() ) {
                
                leAlbum.setId(rs.getInt("ald_id"));
                leAlbum.setNom(rs.getString("nom"));
                leAlbum.setDateCreation(rs.getString("dateCreation"));
                leAlbum.setCheminImg(rs.getString("cheminImg"));
                
                Connection con = ConnexionBdd.ouvrirConnexion();
                ArrayList<Titre> lesTitresAlbum = DaoTitre.getLesTitresAlbum(con, idAlbum);
                leAlbum.setLesTitres(lesTitresAlbum);
                
                ConnexionBdd.fermerConnexion(con);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return leAlbum ;
    }

    
    public static Album ajouterAlbum(Connection connection, Album unAlbum){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("INSERT INTO ALBUM (nom, dateCreation, cheminImg)\n" +
                    "VALUES (?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setString(1, unAlbum.getNom());
            requete.setString(2, unAlbum.getDateCreation());
            requete.setString(3, unAlbum.getCheminImg());

            System.out.println("requeteInsertion=" + requete);
            /* Exécution de la requête */
            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            // Récupération de id auto-généré par la bdd dans la table groupe
            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unAlbum.setId(idGenere);
            }

            // si le résultat de la requete est différent de 1, c'est que la requête a échoué.
            // Dans ce cas, on remet l'objet groupe à null
            if (resultatRequete != 1){
                unAlbum= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
            unAlbum= null;
        }
        return unAlbum ;
    }
}
