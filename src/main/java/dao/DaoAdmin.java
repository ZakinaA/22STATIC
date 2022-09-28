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
import model.Instrument;
import model.Membre;
import model.Statut;

/**
 *
 * @author Zakina
 */
public class DaoAdmin {

    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;

    public static ArrayList<Genre> getLesGenres(Connection connection){
        ArrayList<Genre> lesGenres = new  ArrayList<Genre>();
        try
        {
            requete=connection.prepareStatement("select * from  genre ");
            rs=requete.executeQuery();
            while ( rs.next() ) {

                Genre leGenre = new Genre();
                leGenre.setId(rs.getInt("gen_id"));
                leGenre.setLibelle(rs.getString("libelle"));
                lesGenres.add(leGenre);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesGenres ;
    }
    public static ArrayList<Dispositif> getLesDispositifs(Connection connection){
        ArrayList<Dispositif> lesDispositifs = new  ArrayList<Dispositif>();
        try
        {
            requete=connection.prepareStatement("select * from  dispositif ");
            rs=requete.executeQuery();
            while ( rs.next() ) {

                Dispositif leDispositif = new Dispositif();
                leDispositif.setId(rs.getInt("dis_id"));
                leDispositif.setLibelle(rs.getString("libelle"));
                lesDispositifs.add(leDispositif);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesDispositifs ;
    }
    public static ArrayList<Membre> getLesMembres(Connection connection){
        ArrayList<Membre> lesMembres = new  ArrayList<Membre>();
        try
        {
            requete=connection.prepareStatement("select * from  membre ");
            rs=requete.executeQuery();
            while ( rs.next() ) {

                Membre leMembre = new Membre();
                leMembre.setId(rs.getInt("mem_id"));
                leMembre.setNom(rs.getString("nom"));
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
    public static ArrayList<Instrument> getLesInstruments(Connection connection){
        ArrayList<Instrument> lesInstruments = new  ArrayList<Instrument>();
        try
        {
            requete=connection.prepareStatement("select * from  instrument ");
            rs=requete.executeQuery();
            while ( rs.next() ) {

                Instrument leInstrument = new Instrument();
                leInstrument.setId(rs.getInt("ins_id"));
                leInstrument.setLibelle(rs.getString("libelle"));
                lesInstruments.add(leInstrument);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesInstruments ;
    }
    
    public static ArrayList<Statut> getLesStatuts(Connection connection){
        ArrayList<Statut> lesStatuts = new  ArrayList<Statut>();
        try
        {
            requete=connection.prepareStatement("select * from  statut ");
            rs=requete.executeQuery();
            while ( rs.next() ) {

                Statut leStatut = new Statut();
                leStatut.setId(rs.getInt("sta_code"));
                leStatut.setLibelleStatut(rs.getString("libelleStatut"));
                lesStatuts.add(leStatut);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesStatuts ;
    }
}
