/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import dao.DaoMembre;
import java.sql.Connection;
import java.util.ArrayList;
import model.Dispositif;
import model.Instrument;
import model.Membre;
import model.Statut;

/**
 *
 * @author sio2
 */
public class TestDaoMembre {
    public static void main(String[] args) {
        Connection con = ConnexionBdd.ouvrirConnexion();
        
        /*Membre mem = new Membre();
        mem.setNom("Bouzin");
        mem.setPrenom("Charlot");
        
        Instrument instrument = new Instrument();
        instrument.setId(1);
        mem.setInstrument(instrument);
        
        Statut statut = new Statut();
        statut.setId(1);
        mem.setStatut(statut);        
        
        Membre leMembreInsere = DaoMembre.ajouterMembre(con, mem);*/
        
        ArrayList<Membre> lesMembres = DaoMembre.getLesMembresbyinstrument(con, 2);
        for(int i=0; i<lesMembres.size(); i++){
            Membre mem = lesMembres.get(i);
            if(i==0){
                System.out.println("La " + mem.getInstrument().getLibelle() + " est joué par : ");
            }
            System.out.println(mem.getNom()+" "+ mem.getPrenom());
        }
        
        ConnexionBdd.fermerConnexion(con);
    }
}
