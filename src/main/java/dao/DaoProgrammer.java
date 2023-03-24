/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.DaoFestival.requete;
import static dao.DaoFestival.rs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Groupe;
import model.Membre;
import model.Programmer;

/**
 *
 * @author arnaud.le_cozannet
 */
class DaoProgrammer {
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
    public static ArrayList<Programmer> getLesProgrammersByFestival(Connection connection, int idFestival){
        ArrayList<Programmer> LesProgrammers = new  ArrayList<Programmer>();
        try
        {
            //preparation de la requete
                requete=connection.prepareStatement("SELECT * FROM programmer WHERE idFestival = ?");
                requete.setInt(1, idFestival);
                System.out.println("Requete" + requete);

                //executer la requete
                rs=requete.executeQuery();

            //On hydrate l'objet métier Groupe et sa relation Genre avec les résultats de la requête
            while ( rs.next() ) {

                Programmer leProgrammer = new Programmer();
                leProgrammer.setDateProgrammation(rs.getString("dateProgrammation"));
                Groupe leGroupe = DaoGroupe.getLeGroupe(connection, rs.getInt("idGroupe")); 
                leProgrammer.setLeGroupe(leGroupe);
                
                LesProgrammers.add(leProgrammer);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return LesProgrammers ;
    }
}
