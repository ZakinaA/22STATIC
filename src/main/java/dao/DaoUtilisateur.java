/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static model.MD5.getMd5;
import model.Membre;
import model.Utilisateur;

/**
 *
 * @author arnaud.le_cozannet
 */
public class DaoUtilisateur {

    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
    public static Utilisateur getLUtilisateur(Connection connection, String login){
        Utilisateur lUtilisateur = new  Utilisateur();
        try
        {
            //preparation de la requete
            requete=connection.prepareStatement("select * from utilisateur where login=?");
            requete.setString(1, login);
            System.out.println("Requete" + requete);

            //executer la requete
            rs=requete.executeQuery();
            if ( rs.next() ) {
                lUtilisateur.setId(rs.getInt("uti_id"));
                lUtilisateur.setLogin(rs.getString("login"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lUtilisateur;
    }
    
    public static Utilisateur ajouterUtilisateur(Connection connection, Membre unMembre){
        int idGenere = -1;
        Utilisateur unUtilisateur = unMembre.getLesUtilisateurs().get(0);
        try
        {
            requete=connection.prepareStatement("INSERT INTO utilisateur (login, mdp, idMembre)\n" +
                    "VALUES (?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setString(1, unUtilisateur.getLogin());
            requete.setString(2, getMd5(unUtilisateur.getMdp()));
            requete.setInt(3, unMembre.getId());

            System.out.println("requeteInsertion=" + requete);
            /* Exécution de la requête */
            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            // Récupération de id auto-généré par la bdd dans la table groupe
            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unUtilisateur.setId(idGenere);
            }

            // si le résultat de la requete est différent de 1, c'est que la requête a échoué.
            // Dans ce cas, on remet l'objet groupe à null
            if (resultatRequete != 1){
                unUtilisateur= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
            unUtilisateur= null;
        }
        return unUtilisateur;
    }
}
