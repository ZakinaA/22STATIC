/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import dao.DaoJury;
import java.sql.Connection;

/**
 *
 * @author sio2
 */
public class TestDaoJury {
     public static void main(String[] args) {
        Connection con = ConnexionBdd.ouvrirConnexion();
        
        DaoJury.desinscrireGroupe(con, 5);

        ConnexionBdd.fermerConnexion(con);
    }
}
