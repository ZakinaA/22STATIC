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
import model.Titre;
import model.Titre;
/**
 *
 * @author sio2
 */
public class DaoTitre {
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
    public static ArrayList<Titre> getLesTitresDuGroupe(Connection connection, int idGroupe){
        ArrayList<Titre> lesTitres = new  ArrayList<Titre>();
        try
        {
            //preparation de la requete
                requete=connection.prepareStatement("select * from titre, groupe where gro_id = idGroupe and gro_id = ?");
                requete.setInt(1, idGroupe);
                System.out.println("Requete" + requete);

                //executer la requete
                rs=requete.executeQuery();

            //On hydrate l'objet métier Groupe et sa relation Genre avec les résultats de la requête
            while ( rs.next() ) {


                Titre leTitre = new Titre();
                leTitre.setNumero(rs.getInt("numero"));
                leTitre.setIntitule(rs.getString("intitule"));
                leTitre.setDuree(rs.getInt("duree"));
                leTitre.setLienURL(rs.getString("lienURL"));

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
}
