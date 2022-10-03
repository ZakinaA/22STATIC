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
public class Membre {
    private int id;
    private String nom;
    private String prenom;
    private String mail;
    private String MDP;
    private ArrayList<Groupe> lesGroupes ;
    private Statut statut ;
    private Instrument instrument ;
    private ArrayList<GroupeMembreInstrument> lesGroupesMembresInstruments ;
    
    public Membre() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMDP() {
        return MDP;
    }

    public void setMDP(String mdp) {
        this.MDP = mdp;
    }    
    
    public ArrayList<Groupe> getLesGroupes() {
        return lesGroupes;
    }

    public void setLesGroupes(ArrayList<Groupe> lesGroupes) {
        this.lesGroupes = lesGroupes;
    }
    
    public void addUngroupe(Groupe unGroupe){
        if (lesGroupes == null){
            lesGroupes = new ArrayList<>();
        }
        lesGroupes.add(unGroupe);
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
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
