/*
 * Click nbfs://nbhost/SystemFilSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFilSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import dao.DaoGroupe;
import dao.DaoInstrument;
import dao.DaoMembre;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Instrument;
import java.util.ArrayList;
import model.Dispositif;
import model.Genre;
import model.Groupe;
import model.Membre;
import model.Titre;

/**
 *
 * @author Zakina
 */
public class TestDaoInstrument {
    
    public static void main(String[] args) {
        Connection con = ConnexionBdd.ouvrirConnexion();
        
        Instrument lInstrument = DaoInstrument.getLesMembresbyinstrument(con, 3);
        System.out.println("L'instrument " + lInstrument.getLibelle()+ " est joué par :");
        for(int i=0; i<lInstrument.getLesMembres().size(); i++){
            Membre mem = lInstrument.getLesMembres().get(i);
            System.out.println(mem.getNom()+" "+mem.getPrenom());
        }
        
        /*
        Instrument ins = new Instrument();
        ins.setLibelle("Maraca");
        
        Instrument lInstrumentInsere = DaoInstrument.ajouterInstrument(con, ins);*/

        ConnexionBdd.fermerConnexion(con);
    }
    
}

