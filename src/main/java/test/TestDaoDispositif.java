/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import dao.DaoDispositif;
import dao.DaoGroupe;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import model.Dispositif;
import model.Genre;
import model.Groupe;
import model.Membre;

/**
 *
 * @author sio2
 */
public class TestDaoDispositif {    
    public static void main(String[] args) {
        Connection con = ConnexionBdd.ouvrirConnexion();
        
        /*ArrayList<Dispositif> lesDispositifs = DaoDispositif.getLesDispositifs(con);
        for(int i=0; i<lesDispositifs.size(); i++){
            Dispositif disp = lesDispositifs.get(i);
            System.out.println("Libelle du dispositif : " + disp.getLibelle());
        }*/
        
        Dispositif dis = new Dispositif();
        dis.setAnnee(2020);
        dis.setLibelle("NormanziK");
        
        
        Dispositif leDispositifInsere = DaoDispositif.ajouterDispositif(con, dis);
        
        ConnexionBdd.fermerConnexion(con);
    }
    
}
