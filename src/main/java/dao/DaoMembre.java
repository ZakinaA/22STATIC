/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.DaoGroupe.requete;
import static dao.DaoGroupe.rs;
import static dao.DaoMembre.requete;
import static dao.DaoMembre.rs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Membre;
import model.Genre;
import model.Groupe;
import model.Instrument;
import model.Membre;
import model.Statut;
import model.Titre;

/**
 *
 * @author sio2
 */
public class DaoMembre {
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
    public static ArrayList<Membre> getConnexion(Connection connection){
        ArrayList<Membre> lesMembres = new  ArrayList<Membre>();
        try
        {
            //preparation de la requete
            requete=connection.prepareStatement("select mail, mdp from membre");
            System.out.println("Requete" + requete);

            //executer la requete
            rs=requete.executeQuery();
            while ( rs.next() ) {
                Membre leMembre = new Membre();
                leMembre.setMail(rs.getString("mail"));
                leMembre.setMDP(rs.getString("mdp"));

                lesMembres.add(leMembre);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesMembres;
    }
    
    public static Membre getLeMembre(Connection connection, int idMembre){
        Membre leMembre = new  Membre();
        try
        {
            //preparation de la requete
            requete=connection.prepareStatement("select * from membre,instrument,statut where idInstrument=ins_id and idStatut=sta_code and mem_id=?");
            requete.setInt(1, idMembre);
            System.out.println("Requete" + requete);

            //executer la requete
            rs=requete.executeQuery();
            if ( rs.next() ) {
                leMembre.setNom(rs.getString("membre.nom"));
                leMembre.setPrenom(rs.getString("prenom"));
                
                Instrument lInstrument = new Instrument();
                lInstrument.setLibelle(rs.getString("instrument.libelle"));
                leMembre.setInstrument(lInstrument);
                
                Statut leStatut = new Statut();
                leStatut.setLibelleStatut(rs.getString("libelleStatut"));
                leMembre.setStatut(leStatut);

            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return leMembre;
    }
    
    public static ArrayList<Membre> getLesMembresbyinstrument(Connection connection, int idInstrument){
        ArrayList<Membre> lesMembres = new  ArrayList<Membre>();
        try
        {
            //preparation de la requete
            requete=connection.prepareStatement("select membre.nom, prenom from instrument, membre where ins_id=idInstrument and ins_id=?");
            requete.setInt(1, idInstrument);
            System.out.println("Requete" + requete);

            //executer la requete
            rs=requete.executeQuery();
            while ( rs.next() ) {
                Membre leMembre = new Membre();
                leMembre.setNom(rs.getString("membre.nom"));
                leMembre.setPrenom(rs.getString("prenom"));

                lesMembres.add(leMembre);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesMembres;
    }
    
    public static ArrayList<Membre> getLesMembresDuGroupe(Connection connection, int idGroupe){
        ArrayList<Membre> lesMembres = new  ArrayList<Membre>();
        try
        {
            //preparation de la requete
                requete=connection.prepareStatement("select mem_id, membre.nom, prenom from membre, groupe, groupemembre where gro_id = idGroupe and groupemembre.idMembre = mem_id and gro_id = ?");
                requete.setInt(1, idGroupe);
                System.out.println("Requete" + requete);

                //executer la requete
                rs=requete.executeQuery();

            //On hydrate l'objet métier Groupe et sa relation Genre avec les résultats de la requête
            while ( rs.next() ) {


                Membre leMembre = new Membre();
                leMembre.setId(rs.getInt("mem_id"));
                leMembre.setNom(rs.getString("membre.nom"));
                leMembre.setPrenom(rs.getString("prenom"));

                lesMembres.add(leMembre);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesMembres ;
    }
    
    public static Membre ajouterMembre(Connection connection, Membre unMembre){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("INSERT INTO MEMBRE (nom, prenom, idInstrument, idStatut)\n" +
                    "VALUES (?,?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setString(1, unMembre.getNom());
            requete.setString(2, unMembre.getPrenom());
            requete.setInt(3, unMembre.getInstrument().getId());
            requete.setInt(4, unMembre.getStatut().getId());

            System.out.println("requeteInsertion=" + requete);
            /* Exécution de la requête */
            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            // Récupération de id auto-généré par la bdd dans la table groupe
            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unMembre.setId(idGenere);
            }

            // si le résultat de la requete est différent de 1, c'est que la requête a échoué.
            // Dans ce cas, on remet l'objet groupe à null
            if (resultatRequete != 1){
                unMembre= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
            unMembre= null;
        }
        return unMembre ;
    }
}
