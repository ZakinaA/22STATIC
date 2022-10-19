/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Dispositif;
import model.Genre;
import model.Groupe;
import model.Membre;
import model.Titre;
import test.ConnexionBdd;
import static test.ConnexionBdd.fermerConnexion;

/**
 *
 * @author Zakina
 */
public class DaoGroupe {
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;

    public static ArrayList<Groupe> getLesGroupes(Connection connection){
        ArrayList<Groupe> lesGroupes = new  ArrayList<Groupe>();
        try
        {
            //preparation de la requete
            requete=connection.prepareStatement("select * from groupe, genre, membre where idMembre=mem_id and idGenre = gen_id");
            System.out.println("Requete" + requete);

            //executer la requete
            rs=requete.executeQuery();

            //On hydrate l'objet métier Groupe et sa relation Genre avec les résultats de la requête
            while ( rs.next() ) {


                Groupe leGroupe = new Groupe();
                leGroupe.setId(rs.getInt("gro_id"));
                leGroupe.setNom(rs.getString("nom"));
                leGroupe.setDateCreation(rs.getString("dateCreation"));
                leGroupe.setTelephone(rs.getString("telephone"));
                leGroupe.setMelSiteWeb(rs.getString("melSiteWeb"));
                leGroupe.setLieuRepetition(rs.getString("lieuRepetition"));
                leGroupe.setEstSelectionne(rs.getInt("estSelectionne"));

                Genre leGenre = new Genre();
                leGenre.setId(rs.getInt("gen_id"));
                leGenre.setLibelle(rs.getString("libelle"));
                leGroupe.setGenre(leGenre);
                
                Membre leMembre = new Membre();
                leMembre.setNom(rs.getString("membre.nom"));
                leMembre.setPrenom(rs.getString("prenom"));
                leGroupe.setMembre(leMembre);
                
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

    public static ArrayList<Groupe> getLesGroupesByDispositif(Connection connection, int idDispositif){
        ArrayList<Groupe> lesGroupes = new  ArrayList<Groupe>();
        try
        {
            //preparation de la requete
            requete=connection.prepareStatement("select * from groupe, dispositif where idDispositif = dis_id and dis_id=?");
            requete.setInt(1, idDispositif);
            System.out.println("Requete" + requete);

            //executer la requete
            rs=requete.executeQuery();

            //On hydrate l'objet métier Groupe et sa relation Genre avec les résultats de la requête
            while ( rs.next() ) {


                Groupe leGroupe = new Groupe();
                leGroupe.setId(rs.getInt("gro_id"));
                leGroupe.setNom(rs.getString("nom"));
                leGroupe.setDateCreation(rs.getString("dateCreation"));
                leGroupe.setTelephone(rs.getString("telephone"));
                leGroupe.setMelSiteWeb(rs.getString("melSiteWeb"));
                leGroupe.setLieuRepetition(rs.getString("lieuRepetition"));
                
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

    public static ArrayList<Groupe> getLesGroupesByMembre(Connection connection, int idMembre){
        ArrayList<Groupe> lesGroupes = new  ArrayList<Groupe>();
        try
        {
            //preparation de la requete
            requete=connection.prepareStatement("select * from groupe, groupemembre, membre, genre where idGenre=gen_id and idGroupe=gro_id and groupe.idMembre=mem_id and groupemembre.idMembre=?");
            requete.setInt(1, idMembre);
            System.out.println("Requete" + requete);

            //executer la requete
            rs=requete.executeQuery();

            //On hydrate l'objet métier Groupe et sa relation Genre avec les résultats de la requête
            while ( rs.next() ) {


                Groupe leGroupe = new Groupe();
                leGroupe.setId(rs.getInt("gro_id"));
                leGroupe.setNom(rs.getString("nom"));
                leGroupe.setDateCreation(rs.getString("dateCreation"));
                leGroupe.setTelephone(rs.getString("telephone"));
                leGroupe.setMelSiteWeb(rs.getString("melSiteWeb"));
                leGroupe.setLieuRepetition(rs.getString("lieuRepetition"));
                
                Membre leMembre = new Membre();
                leMembre.setId(rs.getInt("mem_id"));
                leMembre.setNom(rs.getString("membre.nom"));
                leMembre.setPrenom(rs.getString("prenom"));
                leGroupe.setMembre(leMembre);
                
                Genre leGenre = new Genre();
                leGenre.setLibelle(rs.getString("libelle"));
                leGroupe.setGenre(leGenre);
                
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
    
    public static Groupe getLeGroupeduMembre(Connection connection, int idMembre){
        Groupe leGroupe = new Groupe();
        try
        {
            //preparation de la requete
            requete=connection.prepareStatement("select * from groupe, genre where idGenre=gen_id and idMembre=?");
            requete.setInt(1, idMembre);
            System.out.println("Requete" + requete);

            //executer la requete
            rs=requete.executeQuery();

            //On hydrate l'objet métier Groupe et sa relation Genre avec les résultats de la requête
            if ( rs.next() ) {

                leGroupe.setId(rs.getInt("gro_id"));
                leGroupe.setNom(rs.getString("nom"));
                leGroupe.setDateCreation(rs.getString("dateCreation"));
                leGroupe.setTelephone(rs.getString("telephone"));
                leGroupe.setMelSiteWeb(rs.getString("melSiteWeb"));
                leGroupe.setLieuRepetition(rs.getString("lieuRepetition"));
                leGroupe.setEstSelectionne(rs.getInt("estSelectionne"));
                
                Genre leGenre = new Genre();
                leGenre.setId(rs.getInt("gen_id"));
                leGenre.setLibelle(rs.getString("libelle"));
                leGroupe.setGenre(leGenre);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return leGroupe;
    }
    
    
    
    public static Groupe getLeGroupe(Connection connection, int idGroupe){

        Groupe leGroupe = new Groupe();
        try
        {
            //preparation de la requete
            requete=connection.prepareStatement("select * from groupe, membre where groupe.idMembre=mem_id and gro_id=?");
            requete.setInt(1, idGroupe);
            System.out.println("Requete" + requete);

            //executer la requete
            rs=requete.executeQuery();

            //On hydrate l'objet métier Groupe et sa relation Genre avec les résultats de la requête
            if ( rs.next() ) {
                
                leGroupe.setId(rs.getInt("gro_id"));
                leGroupe.setNom(rs.getString("groupe.nom"));
                leGroupe.setDateCreation(rs.getString("dateCreation"));
                leGroupe.setTelephone(rs.getString("telephone"));
                leGroupe.setMelSiteWeb(rs.getString("melSiteWeb"));
                leGroupe.setLieuRepetition(rs.getString("lieuRepetition"));
                

                Membre leMembre = new Membre();
                leMembre.setId(rs.getInt("mem_id"));
                leMembre.setNom(rs.getString("membre.nom"));
                leMembre.setPrenom(rs.getString("prenom"));

                leGroupe.setMembre(leMembre);
                
                Connection con = ConnexionBdd.ouvrirConnexion();
                ArrayList<Membre> lesMembresDuGroupes = DaoMembre.getLesMembresDuGroupe(con, idGroupe);
                leGroupe.setLesMembres(lesMembresDuGroupes);
                
                ArrayList<Titre> lesTitresDuGroupes = DaoTitre.getLesTitresDuGroupe(con, idGroupe);
                leGroupe.setLesTitres(lesTitresDuGroupes);
                
                ConnexionBdd.fermerConnexion(con);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return leGroupe ;
    }

    public static ArrayList<Groupe> getLesGroupesdispo(Connection connection, int idDispositif){
        ArrayList<Groupe> lesGroupes = new  ArrayList<Groupe>();
        try
        {
            //preparation de la requete
            requete=connection.prepareStatement("select * from groupe, dispositif where idDispositif = dis_id and dis_id=?");
            requete.setInt(1, idDispositif);
            System.out.println("Requete" + requete);

            //executer la requete
            rs=requete.executeQuery();

            //On hydrate l'objet métier Groupe et sa relation Genre avec les résultats de la requête
            while ( rs.next() ) {


                Groupe leGroupe = new Groupe();
                leGroupe.setId(rs.getInt("gro_id"));
                leGroupe.setNom(rs.getString("nom"));
                leGroupe.setDateCreation(rs.getString("dateCreation"));

                Dispositif leDispositif = new Dispositif();
                leDispositif.setId(rs.getInt("dis_id"));
                leDispositif.setAnnee(rs.getInt("annee"));
                leDispositif.setLibelle(rs.getString("libelle"));

                leGroupe.setDispositif(leDispositif);
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
    
    
    
    public static Groupe ajouterGroupe(Connection connection, Groupe unGroupe){
        int idGenere = -1;
        try
        {
            //preparation de la requete
            // gpe_id (clé primaire de la table groupe) est en auto_increment,donc on ne renseigne pas cette valeur
            // le paramètre RETURN_GENERATED_KEYS est ajouté à la requête afin de pouvoir récupérer l'id généré par la bdd (voir ci-dessous)
            // supprimer ce paramètre en cas de requête sans auto_increment.
            requete=connection.prepareStatement("INSERT INTO GROUPE ( nom, dateCreation, telephone, melSiteWeb, lieuRepetition, estSelectionne, idDispositif, idMembre, idGenre)\n" +
                    "VALUES (?,?,?,?,?,?,?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setString(1, unGroupe.getNom());
            requete.setString(2, unGroupe.getDateCreation());
            requete.setString(3, unGroupe.getTelephone());
            requete.setString(4, unGroupe.getMelSiteWeb());
            requete.setString(5, unGroupe.getLieuRepetition());
            requete.setInt(6, unGroupe.getEstSelectionne());
            requete.setInt(7, unGroupe.getDispositif().getId());
            requete.setInt(8, unGroupe.getMembre().getId());
            requete.setInt(9, unGroupe.getGenre().getId());

            System.out.println("requeteInsertion=" + requete);
            /* Exécution de la requête */
            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            // Récupération de id auto-généré par la bdd dans la table groupe
            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unGroupe.setId(idGenere);
            }

            // si le résultat de la requete est différent de 1, c'est que la requête a échoué.
            // Dans ce cas, on remet l'objet groupe à null
            if (resultatRequete != 1){
                unGroupe= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
            unGroupe= null;
        }
        return unGroupe ;
    }
    
    ////
    public static Membre ajouterMembre(Connection connection, Membre unMembre){
        int idGenere = -1;
        try
        {
            //preparation de la requete
            // gpe_id (clé primaire de la table groupe) est en auto_increment,donc on ne renseigne pas cette valeur
            // le paramètre RETURN_GENERATED_KEYS est ajouté à la requête afin de pouvoir récupérer l'id généré par la bdd (voir ci-dessous)
            // supprimer ce paramètre en cas de requête sans auto_increment.
            requete=connection.prepareStatement("INSERT INTO `groupemembre` (`idGroupe`, `idMembre`, `idInstrument`) VALUES ('?', '?', '1')");
            requete.setInt(1, unMembre.getLesGroupes().get(1).getId());
            requete.setInt(2, unMembre.getId());

            System.out.println("requeteInsertion=" + requete);
            /* Exécution de la requête */
            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);


            // si le résultat de la requete est différent de 1, c'est que la requête a échoué.
            // Dans ce cas, on remet l'objet groupe à null
            if (resultatRequete != 1){
                unMembre = null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
            unMembre = null;
        }
        return unMembre ;
    }
    ////
    
    public static int supprimerMembreDunGroupe(Connection connection, int idGroupe, int idMembre){
        try
        {
            requete=connection.prepareStatement("DELETE FROM groupemembre WHERE idGroupe=? and idGroupe=?");
            requete.setInt(1, idGroupe);
            requete.setInt(2, idGroupe);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");=
        }
        return 1 ;
    }
}
