/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.DaoMembre.requete;
import static dao.DaoMembre.rs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Instrument;
import model.Membre;
import test.ConnexionBdd;

/**
 *
 * @author sio2
 */
public class DaoInstrument {

    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
    public static Instrument getLesMembresbyinstrument(Connection connection, int idInstrument){
        Instrument lInstrument = new Instrument();
        try
        {
            //preparation de la requete
            requete=connection.prepareStatement("select libelle from instrument where ins_id=?");
            requete.setInt(1, idInstrument);
            System.out.println("Requete" + requete);

            //executer la requete
            rs=requete.executeQuery();
            if ( rs.next() ) {
                
                lInstrument.setLibelle(rs.getString("libelle"));

                Connection con = ConnexionBdd.ouvrirConnexion();
                
                ArrayList<Membre> getLesMembresbyinstrument = DaoMembre.getLesMembresbyinstrument(con, idInstrument);
                lInstrument.setLesMembres(getLesMembresbyinstrument);
                
                ConnexionBdd.fermerConnexion(con);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lInstrument;
    }
    
    
    public static Instrument ajouterInstrument(Connection connection, Instrument unInstrument){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("INSERT INTO Instrument (libelle)\n" +
                    "VALUES (?)", requete.RETURN_GENERATED_KEYS );
            requete.setString(1, unInstrument.getLibelle());

            System.out.println("requeteInsertion=" + requete);
            /* Exécution de la requête */
            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            // Récupération de id auto-généré par la bdd dans la table groupe
            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unInstrument.setId(idGenere);
            }

            // si le résultat de la requete est différent de 1, c'est que la requête a échoué.
            // Dans ce cas, on remet l'objet groupe à null
            if (resultatRequete != 1){
                unInstrument= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
            unInstrument= null;
        }
        return unInstrument ;
    }
}
