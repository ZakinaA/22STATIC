/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Sofiane
 */
public class Intervenants {
    private int id;
    private String nom;
    private String prenom;
    private boolean spécialité;
    
    public Intervenants() {
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

    public boolean isSpécialité() {
        return spécialité;
    }

    public void setSpécialité(boolean spécialité) {
        this.spécialité = spécialité;
    }
}
