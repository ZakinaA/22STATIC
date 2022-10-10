/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Sofiane
 */
public class Admin {
    private int id;
    private String nom;
    private String prenom;
    private String login;
    private String mdp;
    private Groupe groupe;
    private Membre membre;
    private Jury jury;
    private Festival festival;
    private LieuConcert lieuConcert;
    private Dispositif dispositif;
    private Titre titre;
    private Album album;
    private Genre genre;
    private Instrument instrument;
    private Statut statut;
    private Utilisateur utilisateur;
    private Partenaire partenaire;

    public Admin() {
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    public Jury getJury() {
        return jury;
    }

    public void setJury(Jury jury) {
        this.jury = jury;
    }

    public Festival getFestival() {
        return festival;
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }

    public LieuConcert getLieuConcert() {
        return lieuConcert;
    }

    public void setLieuConcert(LieuConcert lieuConcert) {
        this.lieuConcert = lieuConcert;
    }

    public Dispositif getDispositif() {
        return dispositif;
    }

    public void setDispositif(Dispositif dispositif) {
        this.dispositif = dispositif;
    }

    public Titre getTitre() {
        return titre;
    }

    public void setTitre(Titre titre) {
        this.titre = titre;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Partenaire getPartenaire() {
        return partenaire;
    }

    public void setPartenaire(Partenaire partenaire) {
        this.partenaire = partenaire;
    }
}
