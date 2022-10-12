/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author sio2
 */
public class Jury {
    private int id;
    private String libelle;
    private Dispositif dispositif;
    private ArrayList<Partenaire> lesPartenaires;

    public Jury() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Partenaire> getLesPartenaires() {
        return lesPartenaires;
    }

    public void setLesPartenaires(ArrayList<Partenaire> lesPartenaires) {
        this.lesPartenaires = lesPartenaires;
    }
    

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Dispositif getDispositif() {
        return dispositif;
    }

    public void setDispositif(Dispositif dispositif) {
        this.dispositif = dispositif;
    }
    
    
}
