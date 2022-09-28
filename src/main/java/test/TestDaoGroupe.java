/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import dao.DaoGroupe;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Groupe;
import java.util.ArrayList;
import model.Dispositif;
import model.Genre;
import model.Membre;
import model.Titre;

/**
 *
 * @author Zakina
 */
public class TestDaoGroupe {
    
    public static void main(String[] args) {
        Connection con = ConnexionBdd.ouvrirConnexion();
        
        Groupe leGroupe = DaoGroupe.getLeGroupe(con, 2);
        System.out.println("Nom du groupe : " + leGroupe.getNom());
        System.out.println("Le membre contact du groupe est : " + leGroupe.getMembre().getNom());
        for(int i=0; i<leGroupe.getLesMembres().size(); i++){
            Membre mem = leGroupe.getLesMembres().get(i);
            System.out.println("Les membres du groupe sont : " + mem.getNom());
        }
        for(int i=0; i<leGroupe.getLesTitres().size(); i++){
            Titre tit = leGroupe.getLesTitres().get(i);
            System.out.println("Les Titres du groupe sont : " + tit.getIntitule());
        }
        /*ArrayList<Groupe> lesGroupes = DaoGroupe.getLesGroupes(con);
        for(int i=0; i<lesGroupes.size(); i++){
            Groupe grp = lesGroupes.get(i);
            System.out.println("Nom du groupe : " + grp.getNom()+" genre du groupe : "+ grp.getGenre().getLibelle());
        }
        ArrayList<Groupe> lesGroupes = DaoGroupe.getLesGroupesdispo(con, 1);
        for(int i=0; i<lesGroupes.size(); i++){
            Groupe grp = lesGroupes.get(i);
            System.out.println("Nom du groupe : " + grp.getNom()+", dispositif du groupe : "+ grp.getDispositif().getLibelle());
        }*/
        
        Groupe gp = new Groupe();
        gp.setNom("Les Flash");
        gp.setDateCreation("2012-02-21");
        
        Dispositif dispositif = new Dispositif();
        dispositif.setId(1);
        gp.setDispositif(dispositif);
        
        Membre membre = new Membre();
        membre.setId(1);
        gp.setMembre(membre);
        
        Genre genre = new Genre();
        genre.setId(1);
        gp.setGenre(genre);
        
        Groupe leGroupeInsere = DaoGroupe.ajouterGroupe(con, gp);

        ConnexionBdd.fermerConnexion(con);
    }
    
}
