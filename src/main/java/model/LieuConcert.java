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
public class LieuConcert {
    private int id;
    private String nom;
    private String prenom;
    private int codePostal;
    private ArrayList<Groupe> lesGroupes ;

    public LieuConcert() {
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

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
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
}
