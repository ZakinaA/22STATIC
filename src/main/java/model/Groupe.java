/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Zakina
 */
public class Groupe {
    
    private int id;
    private String nom;
    private String dateCreation;
    private String telephone;
    private String melSiteWeb;
    private String lieuRepetition;
    private int estSelectionne;
    private Genre genre ;
    private Dispositif dispositif;
    private Membre membre;
    private ArrayList<Titre> lesTitres ;
    private ArrayList<Membre> lesMembres ;
    private ArrayList<LieuConcert> lesLieuConcerts ;
    private ArrayList<GroupeMembreInstrument> lesGroupesMembresInstruments ;
    
    
        public Groupe() {
    }
    
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMelSiteWeb() {
        return melSiteWeb;
    }

    public void setMelSiteWeb(String melSiteWeb) {
        this.melSiteWeb = melSiteWeb;
    }

    public String getLieuRepetition() {
        return lieuRepetition;
    }

    public void setLieuRepetition(String lieuRepetition) {
        this.lieuRepetition = lieuRepetition;
    }

    public int getEstSelectionne() {
        return estSelectionne;
    }

    public void setEstSelectionne(int estSelectionne) {
        this.estSelectionne = estSelectionne;
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

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Dispositif getDispositif() {
        return dispositif;
    }

    public void setDispositif(Dispositif dispositif) {
        this.dispositif = dispositif;
    }

    public ArrayList<Titre> getLesTitres() {
        return lesTitres;
    }

    public void setLesTitres(ArrayList<Titre> lesTitres) {
        this.lesTitres = lesTitres;
    }

    public ArrayList<Membre> getLesMembres() {
        return lesMembres;
    }

    public void setLesMembres(ArrayList<Membre> lesMembres) {
        this.lesMembres = lesMembres;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

   public void addUntitre(Titre unTitre){
        if (lesTitres == null){
            lesTitres = new ArrayList<>();
        }
        lesTitres.add(unTitre);
    }
   
   public void addUnmembre(Membre unMembre){
        if (lesMembres == null){
            lesMembres = new ArrayList<>();
        }
        lesMembres.add(unMembre);
    }

    public ArrayList<LieuConcert> getLesLieuConcerts() {
        return lesLieuConcerts;
    }

    public void setLesLieuConcerts(ArrayList<LieuConcert> lesLieuConcerts) {
        this.lesLieuConcerts = lesLieuConcerts;
    }
    
    public void addUnlieuConcert(LieuConcert unLieuConcert){
        if (lesLieuConcerts == null){
            lesLieuConcerts = new ArrayList<>();
        }
        lesLieuConcerts.add(unLieuConcert);
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
