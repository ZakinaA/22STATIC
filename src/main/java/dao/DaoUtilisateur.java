/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Utilisateur;

/**
 *
 * @author arnaud.le_cozannet
 */
public class DaoUtilisateur {

    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
    public static Utilisateur ajouterUtilisateur(Connection connection, Utilisateur unUtilisateur){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("INSERT INTO utilisateur (login, mdp, idPartenaire, idMembre)\n" +
                    "VALUES (?,?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setString(1, unUtilisateur.getLogin());
            requete.setString(2, unUtilisateur.getMdp());
            requete.setInt(4, unUtilisateur.getMembre().getId());

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
