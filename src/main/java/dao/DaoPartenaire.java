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
import model.Partenaire;
import model.Jury;
import model.Titre;

/**
 *
 * @author arnaud.le_cozannet
 */
public class DaoPartenaire {
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
    
    public static Partenaire getLePartenaire(Connection connection, int idPartenaire){
        Partenaire lePartenaire = new  Partenaire();
        try
        {
            //preparation de la requete
            requete=connection.prepareStatement("select * from partenaire par_id=?;");
            requete.setInt(1, idPartenaire);
            System.out.println("Requete" + requete);

            //executer la requete
            rs=requete.executeQuery();
            if ( rs.next() ) {
                lePartenaire.setId(rs.getInt("par_id"));
                lePartenaire.setNom(rs.getString("nom"));
                lePartenaire.setPrenom(rs.getString("prenom"));
                
                Jury leJury = new Jury();
                leJury.setLibelle(rs.getString("libelle"));
                lePartenaire.setJury(leJury);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lePartenaire;
    }
}
