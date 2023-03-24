/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Sofiane
 */
public class Album {
    
    private int id;
    private String nom;
    private String dateCreation;
    private String cheminImg;
    private String lienAlbum;
    private Groupe groupe;
    private ArrayList<Titre> lesTitres ;

    public Album() {
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

    public String getCheminImg() {
        return cheminImg;
    }

    public String getLienAlbum() {
        return lienAlbum;
    }

    public void setLienAlbum(String lienAlbum) {
        this.lienAlbum = lienAlbum;
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

    public void setCheminImg(String cheminImg) {
        this.cheminImg = cheminImg;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public void setLesTitres(ArrayList<Titre> lesTitres) {
        this.lesTitres = lesTitres;
    }

    public ArrayList<Titre> getLesTitres() {
        return lesTitres;
    }
}
