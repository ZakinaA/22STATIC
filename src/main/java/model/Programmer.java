/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sio2
 */
public class Programmer {
    private Groupe leGroupe;
    private Festival leFestival;
    private String dateProgrammation;

    public Programmer() {
    }

    public Groupe getLeGroupe() {
        return leGroupe;
    }

    public void setLeGroupe(Groupe leGroupe) {
        this.leGroupe = leGroupe;
    }

    public Festival getLeFestival() {
        return leFestival;
    }

    public void setLeFestival(Festival leFestival) {
        this.leFestival = leFestival;
    }


    public String getDateProgrammation() {
        return dateProgrammation;
    }

    public void setDateProgrammation(String dateProgrammation) {
        this.dateProgrammation = dateProgrammation;
    }
    
    
}
