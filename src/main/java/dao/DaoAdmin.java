/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Admin;
import model.Album;
import model.Dispositif;
import model.Festival;
import model.Genre;
import model.Groupe;
import model.Instrument;
import model.Jury;
import model.LieuConcert;
import model.Membre;
import model.Partenaire;
import model.Statut;
import model.Titre;
import model.Utilisateur;

/**
 *
 * @author Zakina
 */
public class DaoAdmin {



    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;

    public static ArrayList<Admin> getLesAdmins(Connection connection){
        ArrayList<Admin> lesAdmins = new  ArrayList<Admin>();
        try
        {
            requete=connection.prepareStatement("select * from  admin ");
            rs=requete.executeQuery();
            while ( rs.next() ) {

                Admin leAdmin = new Admin();
                leAdmin.setId(rs.getInt("adm_id"));
                leAdmin.setNom(rs.getString("nom"));
                leAdmin.setPrenom(rs.getString("prenom"));
                lesAdmins.add(leAdmin);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesAdmins ;
    }
    
    public static ArrayList<Admin> getLeAdmin(Connection connection){
        ArrayList<Admin> lAdmin = new  ArrayList<Admin>();
        try
        {
            requete=connection.prepareStatement("select * from  admin ");
            rs=requete.executeQuery();
            while ( rs.next() ) {

                Admin leAdmin = new Admin();
                leAdmin.setId(rs.getInt("adm_id"));
                leAdmin.setNom(rs.getString("nom"));
                leAdmin.setPrenom(rs.getString("prenom"));
                lAdmin.add(leAdmin);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lAdmin ;
    }
        
    public static ArrayList<Groupe> getLesGroupes(Connection connection){
        ArrayList<Groupe> lesGroupes = new  ArrayList<Groupe>();
        try
        {
            requete=connection.prepareStatement("select * from  groupe ");
            rs=requete.executeQuery();
            while ( rs.next() ) {

                Groupe leGroupe = new Groupe();
                leGroupe.setId(rs.getInt("gro_id"));
                leGroupe.setNom(rs.getString("nom"));
                leGroupe.setDateCreation(rs.getString("dateCreation"));
                leGroupe.setTelephone(rs.getString("telephone"));
                leGroupe.setMelSiteWeb(rs.getString("melSiteWeb"));
                leGroupe.setLieuRepetition(rs.getString("lieuRepetition"));
                lesGroupes.add(leGroupe);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesGroupes ;
    }
    
        public static Groupe ajouterGroupe(Connection connection, Groupe unGroupe){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("INSERT INTO GROUPE ( nom, dateCreation, telephone, melSiteWeb, lieuRepetition, estSelectionne, idDispositif, idMembre, idGenre)\n" +
                    "VALUES (?,?,?,?,?,?,?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setString(1, unGroupe.getNom());
            requete.setString(2, unGroupe.getDateCreation());
            requete.setString(3, unGroupe.getTelephone());
            requete.setString(4, unGroupe.getMelSiteWeb());
            requete.setString(5, unGroupe.getLieuRepetition());
            //requete.setInt(6, unGroupe.getEstSelectionne());
            requete.setInt(7, unGroupe.getDispositif().getId());
            requete.setInt(8, unGroupe.getMembre().getId());
            requete.setInt(9, unGroupe.getGenre().getId());

            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unGroupe.setId(idGenere);
            }

            if (resultatRequete != 1){
                unGroupe= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unGroupe= null;
        }
        return unGroupe ;
    }
        
        public static Groupe modifierGroupe(Connection connection, Groupe unGroupe){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("ALTER TABLE GROUPE ( nom, dateCreation, telephone, melSiteWeb, lieuRepetition, estSelectionne, idDispositif, idMembre, idGenre)\n" +
                    "VALUES (?,?,?,?,?,?,?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setString(1, unGroupe.getNom());
            requete.setString(2, unGroupe.getDateCreation());
            requete.setString(3, unGroupe.getTelephone());
            requete.setString(4, unGroupe.getMelSiteWeb());
            requete.setString(5, unGroupe.getLieuRepetition());
            //requete.setInt(6, unGroupe.getEstSelectionne());
            requete.setInt(7, unGroupe.getDispositif().getId());
            requete.setInt(8, unGroupe.getMembre().getId());
            requete.setInt(9, unGroupe.getGenre().getId());

            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unGroupe.setId(idGenere);
            }

            if (resultatRequete != 1){
                unGroupe= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unGroupe= null;
        }
        return unGroupe ;
    }
    
        
       public static Groupe supprimerGroupe(Connection connection, Groupe unGroupe){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("DELETE INTO GROUPE ( nom, dateCreation, telephone, melSiteWeb, lieuRepetition, estSelectionne, idDispositif, idMembre, idGenre)\n" +
                    "VALUES (?,?,?,?,?,?,?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setString(1, unGroupe.getNom());
            requete.setString(2, unGroupe.getDateCreation());
            requete.setString(3, unGroupe.getTelephone());
            requete.setString(4, unGroupe.getMelSiteWeb());
            requete.setString(5, unGroupe.getLieuRepetition());
            //requete.setInt(6, unGroupe.getEstSelectionne());
            requete.setInt(7, unGroupe.getDispositif().getId());
            requete.setInt(8, unGroupe.getMembre().getId());
            requete.setInt(9, unGroupe.getGenre().getId());

            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unGroupe.setId(idGenere);
            }

            if (resultatRequete != 1){
                unGroupe= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unGroupe= null;
        }
        return unGroupe ;
    }
       
       public static ArrayList<Membre> getLesMembres(Connection connection){
        ArrayList<Membre> lesMembres = new  ArrayList<Membre>();
        try
        {
            requete=connection.prepareStatement("select * from  membre ");
            rs=requete.executeQuery();
            while ( rs.next() ) {

                Membre leMembre = new Membre();
                leMembre.setId(rs.getInt("mem_id"));
                leMembre.setNom(rs.getString("nom"));
                lesMembres.add(leMembre);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesMembres ;
    }
    
    
    public static Membre ajouterMembre(Connection connection, Membre unMembre){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("INSERT INTO MEMBRE ( id, nom, prenom" + "VALUES (?,?,?)", requete.RETURN_GENERATED_KEYS );
            Membre leMembre = new Membre();
                leMembre.setId(rs.getInt("mem_id"));
                leMembre.setNom(rs.getString("nom"));
                leMembre.setPrenom(rs.getString("prenom"));
            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unMembre.setId(idGenere);
            }

            if (resultatRequete != 1){
                unMembre= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unMembre= null;
        }
        return unMembre ;
    }
        
        public static Membre modifierMembre(Connection connection, Membre unMembre){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("ALTER TABLE MEMBRE ( id, nom, prenom" + "VALUES (?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setInt(1, unMembre.getId());
            requete.setString(2, unMembre.getNom());
            requete.setString(3, unMembre.getPrenom());

            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unMembre.setId(idGenere);
            }

            if (resultatRequete != 1){
                unMembre= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unMembre= null;
        }
        return unMembre ;
    }
    
        
       public static Membre supprimerMembre(Connection connection, Membre unMembre){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("DELETE TABLE MEMBRE ( id, nom, prenom" + "VALUES (?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setInt(1, unMembre.getId());
            requete.setString(2, unMembre.getNom());
            requete.setString(3, unMembre.getPrenom());

            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unMembre.setId(idGenere);
            }

            if (resultatRequete != 1){
                unMembre= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unMembre= null;
        }
        return unMembre ;
    }
       
      public static ArrayList<Jury> getLesJurys(Connection connection){
        ArrayList<Jury> lesJurys = new  ArrayList<Jury>();
        try
        {
            requete=connection.prepareStatement("select * from  jury ");
            rs=requete.executeQuery();
            while ( rs.next() ) {

                Jury leJury = new Jury();
                leJury.setId(rs.getInt("jur_id"));
                leJury.setLibelle(rs.getString("nom"));
                lesJurys.add(leJury);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesJurys ;
    }
    
    
    public static Jury ajouterJury(Connection connection, Jury unJury){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("INSERT INTO JURY ( id, libelle" + "VALUES (?,?)", requete.RETURN_GENERATED_KEYS );
            Jury leJury = new Jury();
                leJury.setId(rs.getInt("mem_id"));
                leJury.setLibelle(rs.getString("libelle"));
            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unJury.setId(idGenere);
            }

            if (resultatRequete != 1){
                unJury= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unJury= null;
        }
        return unJury ;
    }
        
        public static Jury modifierJury(Connection connection, Jury unJury){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("ALTER TABLE JURY ( id, libelle" + "VALUES (?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setInt(1, unJury.getId());
            requete.setString(2, unJury.getLibelle());

            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unJury.setId(idGenere);
            }

            if (resultatRequete != 1){
                unJury= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unJury= null;
        }
        return unJury ;
    }
    
        
       public static Jury supprimerJury(Connection connection, Jury unJury){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("DELETE TABLE JURY ( id, libelle" + "VALUES (?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setInt(1, unJury.getId());
            requete.setString(2, unJury.getLibelle());

            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unJury.setId(idGenere);
            }

            if (resultatRequete != 1){
                unJury= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unJury= null;
        }
        return unJury ;
    }
       
       
       
        public static ArrayList<Festival> getLesFestivals(Connection connection){
        ArrayList<Festival> lesFestivals = new  ArrayList<Festival>();
        try
        {
            requete=connection.prepareStatement("select * from  festival ");
            rs=requete.executeQuery();
            while ( rs.next() ) {

                Festival leFestival = new Festival();
                leFestival.setId(rs.getInt("fes_id"));
                leFestival.setNom(rs.getString("nom"));
                leFestival.setAnnee(rs.getString("annee"));
                lesFestivals.add(leFestival);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesFestivals ;
    }
    
    
    public static Festival ajouterFestival(Connection connection, Festival unFestival){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("INSERT INTO FESTIVAL ( id, nom, annee" + "VALUES (?,?,?)", requete.RETURN_GENERATED_KEYS );
            Festival leFestival = new Festival();
                leFestival.setId(rs.getInt("fes_id"));
                leFestival.setNom(rs.getString("nom"));
                leFestival.setAnnee(rs.getString("annee"));
            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unFestival.setId(idGenere);
            }

            if (resultatRequete != 1){
                unFestival= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unFestival= null;
        }
        return unFestival ;
    }
        
        /*public static Festival modifierFestival(Connection connection, Festival unFestival){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("ALTER TABLE FESTIVAL ( id, nom, annee" + "VALUES (?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setInt(1, unFestival.getId());
            requete.setString(2, unFestival.getNom());
            requete.setInt(3, unFestival.getAnnee());

            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unFestival.setId(idGenere);
            }

            if (resultatRequete != 1){
                unFestival= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unFestival= null;
        }
        return unFestival ;
    }
    
        
       public static Festival supprimerFestival(Connection connection, Festival unFestival){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("DELETE TABLE FESTIVAL ( id, nom, annee" + "VALUES (?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setInt(1, unFestival.getId());
            requete.setString(2, unFestival.getNom());
            requete.setInt(3, unFestival.getAnnee());

            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unFestival.setId(idGenere);
            }

            if (resultatRequete != 1){
                unFestival= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unFestival= null;
        }
        return unFestival ;
    }*/
       
        public static ArrayList<Dispositif> getLesDispositifs(Connection connection){
        ArrayList<Dispositif> lesDispositifs = new  ArrayList<Dispositif>();
        try
        {
            requete=connection.prepareStatement("select * from  dispositif ");
            rs=requete.executeQuery();
            while ( rs.next() ) {

                Dispositif leDispositif = new Dispositif();
                leDispositif.setId(rs.getInt("dis_id"));
                leDispositif.setAnnee(rs.getInt("annee"));
                leDispositif.setLibelle(rs.getString("libelle"));
                lesDispositifs.add(leDispositif);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesDispositifs ;
    }
    
    
    public static Dispositif ajouterDispositif(Connection connection, Dispositif unDispositif){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("INSERT INTO DISPOSITIF ( id, annee, libelle" + "VALUES (?,?,?)", requete.RETURN_GENERATED_KEYS );
            Dispositif leDispositif = new Dispositif();
                leDispositif.setId(rs.getInt("fes_id"));
                leDispositif.setAnnee(rs.getInt("annee"));
                leDispositif.setLibelle(rs.getString("nom"));
                
            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unDispositif.setId(idGenere);
            }

            if (resultatRequete != 1){
                unDispositif= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unDispositif= null;
        }
        return unDispositif ;
    }
        
        public static Dispositif modifierDispositif(Connection connection, Dispositif unDispositif){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("ALTER TABLE DISPOSITIF ( id, nom, libelle" + "VALUES (?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setInt(1, unDispositif.getId());
            requete.setInt(2, unDispositif.getAnnee());
            requete.setString(3, unDispositif.getLibelle());
            

            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unDispositif.setId(idGenere);
            }

            if (resultatRequete != 1){
                unDispositif= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unDispositif= null;
        }
        return unDispositif ;
    }
    
        
       public static Dispositif supprimerDispositif(Connection connection, Dispositif unDispositif){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("DELETE TABLE DISPOSITIF ( id, nom, libelle" + "VALUES (?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setInt(1, unDispositif.getId());
            requete.setInt(2, unDispositif.getAnnee());
            requete.setString(3, unDispositif.getLibelle());

            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unDispositif.setId(idGenere);
            }

            if (resultatRequete != 1){
                unDispositif= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unDispositif= null;
        }
        return unDispositif ;
    }
       
       public static ArrayList<Titre> getLesTitres(Connection connection){
        ArrayList<Titre> lesTitres = new  ArrayList<Titre>();
        try
        {
            requete=connection.prepareStatement("select * from  TITRE ");
            rs=requete.executeQuery();
            while ( rs.next() ) {

                Titre leTitre = new Titre();
                leTitre.setNumero(rs.getInt("numero"));
                leTitre.setIntitule(rs.getString("intitule"));
                leTitre.setDuree(rs.getString("duree"));
                leTitre.setLienURL(rs.getString("lienURL"));
                lesTitres.add(leTitre);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesTitres ;
    }
    
    
    public static Titre ajouterTitre(Connection connection, Titre unTitre){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("INSERT INTO TITRE ( id, annee, libelle" + "VALUES (?,?,?)", requete.RETURN_GENERATED_KEYS );
            Titre leTitre = new Titre();
                leTitre.setNumero(rs.getInt("numero"));
                leTitre.setIntitule(rs.getString("intitule"));
                leTitre.setDuree(rs.getString("duree"));
                leTitre.setLienURL(rs.getString("lienURL"));
                
            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unTitre.setNumero(idGenere);
            }

            if (resultatRequete != 1){
                unTitre= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unTitre= null;
        }
        return unTitre ;
    }/*
        
        public static Titre modifierTitre(Connection connection, Titre unTitre){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("ALTER TABLE TITRE ( id, intitule, duree, lienURL" + "VALUES (?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setInt(1, unTitre.getNumero());
            requete.setString(2, unTitre.getIntitule());
            requete.setInt(3, unTitre.getDuree());
            requete.setString(4, unTitre.getLienURL());

            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unTitre.setNumero(idGenere);
            }

            if (resultatRequete != 1){
                unTitre= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unTitre= null;
        }
        return unTitre ;
    }
    
        
       public static Titre supprimerTitre(Connection connection, Titre unTitre){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("DELETE TABLE TITRE ( id, intitule, duree, lienURL" + "VALUES (?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setInt(1, unTitre.getNumero());
            requete.setString(2, unTitre.getIntitule());
            requete.setInt(3, unTitre.getDuree());
            requete.setString(4, unTitre.getLienURL());

            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unTitre.setNumero(idGenere);
            }

            if (resultatRequete != 1){
                unTitre= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unTitre= null;
        }
        return unTitre ;
    }*/
       
        public static ArrayList<Album> getLesAlbums(Connection connection){
        ArrayList<Album> lesAlbums = new  ArrayList<Album>();
        try
        {
            requete=connection.prepareStatement("select * from  Album ");
            rs=requete.executeQuery();
            while ( rs.next() ) {

                Album leAlbum = new Album();
                leAlbum.setId(rs.getInt("alb_id"));
                leAlbum.setNom(rs.getString("nom"));
                leAlbum.setDateCreation(rs.getString("dateCreation"));
                lesAlbums.add(leAlbum);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesAlbums ;
    }
    
    
    public static Album ajouterAlbum(Connection connection, Album unAlbum){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("INSERT INTO ALBUM ( id, nom, dateCreation" + "VALUES (?,?,?)", requete.RETURN_GENERATED_KEYS );
            Album leAlbum = new Album();
                leAlbum.setId(rs.getInt("alb_id"));
                leAlbum.setNom(rs.getString("nom"));
                leAlbum.setDateCreation(rs.getString("dateCreation"));
                
            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unAlbum.setId(idGenere);
            }

            if (resultatRequete != 1){
                unAlbum= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unAlbum= null;
        }
        return unAlbum ;
    }
        
        public static Album modifierAlbum(Connection connection, Album unAlbum){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("ALTER TABLE ALBUM ( id, nom, dateCreation" + "VALUES (?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setInt(1, unAlbum.getId());
            requete.setString(2, unAlbum.getNom());
            requete.setString(3, unAlbum.getDateCreation());
            

            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unAlbum.setId(idGenere);
            }

            if (resultatRequete != 1){
                unAlbum= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unAlbum= null;
        }
        return unAlbum ;
    }
    
        
       public static Album supprimerAlbum(Connection connection, Album unAlbum){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("DELETE TABLE ALBUM ( id, nom, dateCreation" + "VALUES (?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setInt(1, unAlbum.getId());
            requete.setString(2, unAlbum.getNom());
            requete.setString(3, unAlbum.getDateCreation());

            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unAlbum.setId(idGenere);
            }

            if (resultatRequete != 1){
                unAlbum= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unAlbum= null;
        }
        return unAlbum ;
    }
       
        public static ArrayList<Genre> getLesGenres(Connection connection){
        ArrayList<Genre> lesGenres = new  ArrayList<Genre>();
        try
        {
            requete=connection.prepareStatement("select * from  GENRE");
            rs=requete.executeQuery();
            while ( rs.next() ) {

                Genre leGenre = new Genre();
                leGenre.setId(rs.getInt("gen_id"));
                leGenre.setLibelle(rs.getString("libelle"));
                lesGenres.add(leGenre);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesGenres ;
    }
    
    
    public static Genre ajouterGenre(Connection connection, Genre unGenre){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("INSERT INTO GENRE ( id, libelle" + "VALUES (?,?)", requete.RETURN_GENERATED_KEYS );
            Genre leGenre = new Genre();
                leGenre.setId(rs.getInt("gen_id"));
                leGenre.setLibelle(rs.getString("libelle"));
                
            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unGenre.setId(idGenere);
            }

            if (resultatRequete != 1){
                unGenre= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unGenre= null;
        }
        return unGenre ;
    }
        
        public static Genre modifierGenre(Connection connection, Genre unGenre){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("ALTER TABLE GENRE ( id, libelle" + "VALUES (?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setInt(1, unGenre.getId());
            requete.setString(2, unGenre.getLibelle());
            

            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unGenre.setId(idGenere);
            }

            if (resultatRequete != 1){
                unGenre= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unGenre= null;
        }
        return unGenre ;
    }
    
        
       public static Genre supprimerGenre(Connection connection, Genre unGenre){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("DELETE TABLE GENRE ( id, libelle" + "VALUES (?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setInt(1, unGenre.getId());
            requete.setString(2, unGenre.getLibelle());

            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unGenre.setId(idGenere);
            }

            if (resultatRequete != 1){
                unGenre= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unGenre= null;
        }
        return unGenre ;
    }
       
       public static ArrayList<Instrument> getLesInstruments(Connection connection){
        ArrayList<Instrument> lesInstruments = new  ArrayList<Instrument>();
        try
        {
            requete=connection.prepareStatement("select * from  instrument");
            rs=requete.executeQuery();
            while ( rs.next() ) {

                Instrument leInstrument = new Instrument();
                leInstrument.setId(rs.getInt("ins_id"));
                leInstrument.setLibelle(rs.getString("libelle"));
                lesInstruments.add(leInstrument);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesInstruments ;
    }
    
    
    public static Instrument ajouterInstrument(Connection connection, Instrument unInstrument){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("INSERT INTO INSTRUMENT ( id, libelle" + "VALUES (?,?)", requete.RETURN_GENERATED_KEYS );
            Instrument leInstrument = new Instrument();
                leInstrument.setId(rs.getInt("gen_id"));
                leInstrument.setLibelle(rs.getString("libelle"));
                
            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unInstrument.setId(idGenere);
            }

            if (resultatRequete != 1){
                unInstrument= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unInstrument= null;
        }
        return unInstrument ;
    }
        
        public static Instrument modifierInstrument(Connection connection, Instrument unInstrument){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("ALTER TABLE INSTRUMENT ( id, libelle" + "VALUES (?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setInt(1, unInstrument.getId());
            requete.setString(2, unInstrument.getLibelle());
            

            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unInstrument.setId(idGenere);
            }

            if (resultatRequete != 1){
                unInstrument= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unInstrument= null;
        }
        return unInstrument ;
    }
    
        
       public static Instrument supprimerInstrument(Connection connection, Instrument unInstrument){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("DELETE TABLE INSTRUMENT ( id, libelle" + "VALUES (?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setInt(1, unInstrument.getId());
            requete.setString(2, unInstrument.getLibelle());

            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unInstrument.setId(idGenere);
            }

            if (resultatRequete != 1){
                unInstrument= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unInstrument= null;
        }
        return unInstrument ;
    }
       
       public static ArrayList<Statut> getLesStatuts(Connection connection){
        ArrayList<Statut> lesStatuts = new  ArrayList<Statut>();
        try
        {
            requete=connection.prepareStatement("select * from  statut ");
            rs=requete.executeQuery();
            while ( rs.next() ) {

                Statut leStatut = new Statut();
                leStatut.setId(rs.getInt("sta_code"));
                leStatut.setLibelleStatut(rs.getString("libelleStatut"));
                lesStatuts.add(leStatut);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesStatuts ;
    }
    
    
    public static Statut ajouterStatut(Connection connection, Statut unStatut){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("INSERT INTO STATUT ( id, libelleStatut" + "VALUES (?,?)", requete.RETURN_GENERATED_KEYS );
            Statut leStatut = new Statut();
                leStatut.setId(rs.getInt("sta_id"));
                leStatut.setLibelleStatut(rs.getString("libelleStatut"));
                
            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unStatut.setId(idGenere);
            }

            if (resultatRequete != 1){
                unStatut= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unStatut= null;
        }
        return unStatut ;
    }
        
        public static Statut modifierStatut(Connection connection, Statut unStatut){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("ALTER TABLE STATUT ( id, libelleStatut" + "VALUES (?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setInt(1, unStatut.getId());
            requete.setString(2, unStatut.getLibelleStatut());
            

            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unStatut.setId(idGenere);
            }

            if (resultatRequete != 1){
                unStatut= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unStatut= null;
        }
        return unStatut ;
    }
    
        
       public static Statut supprimerStatut(Connection connection, Statut unStatut){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("DELETE TABLE STATUT ( id, libelleStatut" + "VALUES (?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setInt(1, unStatut.getId());
            requete.setString(2, unStatut.getLibelleStatut());

            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unStatut.setId(idGenere);
            }

            if (resultatRequete != 1){
                unStatut= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unStatut= null;
        }
        return unStatut ;
    }
       
       public static ArrayList<Utilisateur> getLesUtilisateurs(Connection connection){
        ArrayList<Utilisateur> lesUtilisateurs = new  ArrayList<Utilisateur>();
        try
        {
            requete=connection.prepareStatement("select * from  UTILISATEUR ");
            rs=requete.executeQuery();
            while ( rs.next() ) {

                Utilisateur leUtilisateur = new Utilisateur();
                leUtilisateur.setId(rs.getInt("uti_id"));
                leUtilisateur.setLogin(rs.getString("login"));
                leUtilisateur.setMdp(rs.getString("mdp"));
                
                lesUtilisateurs.add(leUtilisateur);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesUtilisateurs ;
    }
    
    
    public static Utilisateur ajouterUtilisateur(Connection connection, Utilisateur unUtilisateur){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("INSERT INTO UTILISATEUR ( id, login, mdp" + "VALUES (?,?,?)", requete.RETURN_GENERATED_KEYS );
            Utilisateur leUtilisateur = new Utilisateur();
                leUtilisateur.setId(rs.getInt("uti_id"));
                leUtilisateur.setLogin(rs.getString("login"));
                leUtilisateur.setMdp(rs.getString("mdp"));
                
            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unUtilisateur.setId(idGenere);
            }

            if (resultatRequete != 1){
                unUtilisateur= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unUtilisateur= null;
        }
        return unUtilisateur ;
    }
        
        public static Utilisateur modifierUtilisateur(Connection connection, Utilisateur unUtilisateur){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("ALTER TABLE UTILISATEUR ( id, login, mdp" + "VALUES (?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setInt(1, unUtilisateur.getId());
            requete.setString(2, unUtilisateur.getLogin());
            requete.setString(3, unUtilisateur.getMdp());

            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unUtilisateur.setId(idGenere);
            }

            if (resultatRequete != 1){
                unUtilisateur= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unUtilisateur= null;
        }
        return unUtilisateur ;
    }
    
        
       public static Utilisateur supprimerUtilisateur(Connection connection, Utilisateur unUtilisateur){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("DELETE TABLE UTILISATEUR ( id, login, mdp" + "VALUES (?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setInt(1, unUtilisateur.getId());
            requete.setString(2, unUtilisateur.getLogin());
            requete.setString(3, unUtilisateur.getMdp());
            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unUtilisateur.setId(idGenere);
            }

            if (resultatRequete != 1){
                unUtilisateur= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unUtilisateur= null;
        }
        return unUtilisateur ;
    }
       
       public static ArrayList<Partenaire> getLesPartenaires(Connection connection){
        ArrayList<Partenaire> lesPartenaires = new  ArrayList<Partenaire>();
        try
        {
            requete=connection.prepareStatement("select * from  PARTENAIRE ");
            rs=requete.executeQuery();
            while ( rs.next() ) {

                Partenaire lePartenaire = new Partenaire();
                lePartenaire.setId(rs.getInt("par_id"));
                lePartenaire.setNom(rs.getString("nom"));
                lePartenaire.setPrenom(rs.getString("prenom"));
                lesPartenaires.add(lePartenaire);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesPartenaires ;
    }
    
    
    public static Partenaire ajouterPartenaire(Connection connection, Partenaire unPartenaire){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("INSERT INTO PARTENAIRE ( id, nom, prenom" + "VALUES (?,?,?)", requete.RETURN_GENERATED_KEYS );
            Partenaire lePartenaire = new Partenaire();
                lePartenaire.setId(rs.getInt("par_id"));
                lePartenaire.setNom(rs.getString("nom"));
                lePartenaire.setPrenom(rs.getString("prenom"));
                
            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unPartenaire.setId(idGenere);
            }

            if (resultatRequete != 1){
                unPartenaire= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unPartenaire= null;
        }
        return unPartenaire ;
    }
        
        public static Partenaire modifierPartenaire(Connection connection, Partenaire unPartenaire){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("ALTER TABLE PARTENAIRE ( id, nom, prenom" + "VALUES (?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setInt(1, unPartenaire.getId());
            requete.setString(2, unPartenaire.getNom());
            requete.setString(3, unPartenaire.getPrenom());

            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unPartenaire.setId(idGenere);
            }

            if (resultatRequete != 1){
                unPartenaire= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unPartenaire= null;
        }
        return unPartenaire ;
    }
    
        
       public static Partenaire supprimerPartenaire(Connection connection, Partenaire unPartenaire){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("DELETE TABLE PARTENAIRE ( id, nom, prenom" + "VALUES (?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setInt(1, unPartenaire.getId());
            requete.setString(2, unPartenaire.getNom());
            requete.setString(3, unPartenaire.getPrenom());
            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unPartenaire.setId(idGenere);
            }

            if (resultatRequete != 1){
                unPartenaire= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unPartenaire= null;
        }
        return unPartenaire ;
    }/*
       
       public static ArrayList<LieuConcert> getLesLieuConcerts(Connection connection){
        ArrayList<LieuConcert> lesLieuConcerts = new  ArrayList<LieuConcert>();
        try
        {
            requete=connection.prepareStatement("select * from  LIEUCONCERT ");
            rs=requete.executeQuery();
            while ( rs.next() ) {

                LieuConcert leLieuConcert = new LieuConcert();
                leLieuConcert.setId(rs.getInt("par_id"));
                leLieuConcert.setNom(rs.getString("nom"));
                leLieuConcert.setVille(rs.getString("ville"));
                leLieuConcert.setCodePostal(rs.getInt("codePostal"));
                lesLieuConcerts.add(leLieuConcert);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesLieuConcerts ;
    }
    
    
    public static LieuConcert ajouterLieuConcert(Connection connection, LieuConcert unLieuConcert){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("INSERT INTO LIEUCONCERT ( id, nom, ville,codePostal" + "VALUES (?,?,?,?)", requete.RETURN_GENERATED_KEYS );
            LieuConcert leLieuConcert = new LieuConcert();
                leLieuConcert.setId(rs.getInt("par_id"));
                leLieuConcert.setNom(rs.getString("nom"));
                leLieuConcert.setVille(rs.getString("ville"));
                leLieuConcert.setCodePostal(rs.getInt("codePostal"));
                
            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unLieuConcert.setId(idGenere);
            }

            if (resultatRequete != 1){
                unLieuConcert= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unLieuConcert= null;
        }
        return unLieuConcert ;
    }
        
        public static LieuConcert modifierLieuConcert(Connection connection, LieuConcert unLieuConcert){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("ALTER TABLE LIEUCONCERT ( id, nom, ville, codePostal" + "VALUES (?,?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setInt(1, unLieuConcert.getId());
            requete.setString(2, unLieuConcert.getNom());
            requete.setString(3, unLieuConcert.getVille());
            requete.setInt(1, unLieuConcert.getCodePostal());

            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unLieuConcert.setId(idGenere);
            }

            if (resultatRequete != 1){
                unLieuConcert= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unLieuConcert= null;
        }
        return unLieuConcert ;
    }
    
        
       public static LieuConcert supprimerLieuConcert(Connection connection, LieuConcert unLieuConcert){
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("DELETE TABLE LIEUCONCERT ( id, nom, ville, codePostal" + "VALUES (?,?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setInt(1, unLieuConcert.getId());
            requete.setString(2, unLieuConcert.getNom());
            requete.setString(3, unLieuConcert.getVille());
            requete.setInt(1, unLieuConcert.getCodePostal());
            
            System.out.println("requeteInsertion=" + requete);

            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unLieuConcert.setId(idGenere);
            }

            if (resultatRequete != 1){
                unLieuConcert= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();

            unLieuConcert= null;
        }
        return unLieuConcert ;
    }*/
}
