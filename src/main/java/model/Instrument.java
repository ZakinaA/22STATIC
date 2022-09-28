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
public class Instrument {
 private int id;
    private String libelle;
    private ArrayList<Membre> lesMembres;
    private ArrayList<GroupeMembreInstrument> lesGroupesMembresInstruments ;
    

    public Instrument() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public ArrayList<Membre> getLesMembres() {
        return lesMembres;
    }

    public void setLesMembres(ArrayList<Membre> lesMembres) {
        this.lesMembres = lesMembres;
    }
    
    public void addUnMembres(Membre unMembre){
        if (lesMembres == null){
            lesMembres = new ArrayList<>();
        }
        lesMembres.add(unMembre);
    }

    public ArrayList<GroupeMembreInstrument> getLesGroupesMembresInstruments() {
        return lesGroupesMembresInstruments;
    }

    public void setLesGroupesMembresInstruments(ArrayList<GroupeMembreInstrument> lesGroupesMembresInstruments) {
        this.lesGroupesMembresInstruments = lesGroupesMembresInstruments;
    }
    
    
    public void addUngroupeMembreInstrument(GroupeMembreInstrument unGroupeMembreInstrument){
        if (lesGroupesMembresInstruments == null){
            lesGroupesMembresInstruments = new ArrayList<>();
        }
        lesGroupesMembresInstruments.add(unGroupeMembreInstrument);
    }
}

