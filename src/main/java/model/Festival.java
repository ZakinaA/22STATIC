/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Guillaume martin
 */
public class Festival {
    private int id;
    private String nom;
    private String annee;
    private String dateDebut;
    private String dateFin;
    private String logo;
    private ArrayList<Programmer> lesProgrammer ;
    

    public Festival(){
    }
    
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getAnnee() {
        return annee;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public String getLogo() {
        return logo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public ArrayList<Programmer> getLesProgrammer() {
        return lesProgrammer;
    }

    public void setLesProgrammer(ArrayList<Programmer> lesProgrammer) {
        this.lesProgrammer = lesProgrammer;
    }

    
}
