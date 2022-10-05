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
import model.Genre;
import model.Groupe;
import model.Membre;

/**
 *
 * @author Zakina
 */
public class DaoJury {
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;

    public static ArrayList<Groupe> getLesGroupesSelectionne(Connection connection){
        ArrayList<Groupe> lesGroupes = new  ArrayList<Groupe>();
        try
        {
            //preparation de la requete
            requete=connection.prepareStatement("select * from groupe, genre, membre where idMembre=mem_id and idGenre = gen_id and estSelectionne = 1");
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
    
}
