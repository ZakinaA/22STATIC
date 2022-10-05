/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.DaoGroupe.rs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Membre;
import model.Partenaire;
import model.Utilisateur;
import test.ConnexionBdd;

/**
 *
 * @author arnaud.le_cozannet
 */
public class DaoUtilisateur {
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
    public static Utilisateur getLeUtilisateur(Connection connection, String Login , String Mdp){

        Utilisateur leUtilisateur = new Utilisateur();
        try
        {
            //preparation de la requete
            requete=connection.prepareStatement("select * from utilisateur where login=? and mdp=?");
            requete.setString(1, Login);
            requete.setString(1, Mdp);
            System.out.println("Requete" + requete);

            //executer la requete
            rs=requete.executeQuery();

            //On hydrate l'objet métier Utilisateur et sa relation Genre avec les résultats de la requête
            if ( rs.next() ) {
                
                leUtilisateur.setLogin(rs.getString("login"));
                String idMembre = Integer.toString(rs.getInt("idMembre"));
                
                Connection con = ConnexionBdd.ouvrirConnexion();
                
                if (idMembre != "null"){
                    
                    Membre leMembre = DaoMembre.getLeMembre(connection, rs.getInt("idMembre"));
                    leUtilisateur.setMembre(leMembre);
                }
                else{
                    Partenaire lePartenaire = DaoPartenaire.getLePartenaire(connection, rs.getInt("idPartenaire"));
                    leUtilisateur.setPartenaire(lePartenaire);
                }
                ConnexionBdd.fermerConnexion(con);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return leUtilisateur ;
    }
}
