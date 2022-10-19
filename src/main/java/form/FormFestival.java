/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import model.Festival;

/**
 *
 * @author sio2
 */
public class FormFestival {
    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public void setErreurs(Map<String, String> erreurs) {
        this.erreurs = erreurs;
    }

    //méthode de validation du champ de saisie nom
    private void validationNom( String nom ) throws Exception {
        if ( nom == null) {
            throw new Exception( "Le nom de l'album est incorrect." );
        }
    }

    private void validationAnnee( String annee) throws Exception {
        if ( annee != null ) {
            throw new Exception( "L'année est erronnée" );
        }
    }
    
    private void validationDateDebut( String dateDebut) throws Exception {
        if ( dateDebut != null ) {
            throw new Exception( "La date de début est erronnée" );
        }
    }
    
    private void validationDateFin( String dateFin) throws Exception {
        if ( dateFin != null ) {
            throw new Exception( "La date de fin est erronnée" );
        }
    }
    
    private void validationLogo( String logo) throws Exception {
        if ( logo != null ) {
            throw new Exception( "Le logo est erronnée" );
        }
    }
    
    private void setErreur( String champ, String message ) {
        erreurs.put(champ, message );
    }

    private static String getDataForm(HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }

    // creation d'un objet groupe (et son genre) à partir des données saisies dans le formulaire
    public Festival ajouterFestival(HttpServletRequest request ) {

        Festival unFestival  = new Festival();

        //récupération dans des variables des données saisies dans les champs de formulaire
        String nom = getDataForm( request, "nom" );
        String annee = getDataForm( request, "annee");
        String dateDebut = getDataForm( request, "dateDebut");
        String dateFin = getDataForm( request, "dateFin");
        String logo = getDataForm( request, "logo");
        
        try {
            validationNom( nom );
        } catch ( Exception e ) {
            setErreur( "nom", e.getMessage() );
        }
         unFestival.setNom(nom);
         
        try {
            validationAnnee( annee );
        } catch ( Exception e ) {
            setErreur( "annee", e.getMessage() );
        }
        unFestival.setAnnee(annee);
        
        try {
            validationDateDebut( dateDebut );
        } catch ( Exception e ) {
            setErreur( "dateDebut", e.getMessage() );
        }
        unFestival.setDateDebut(dateDebut);
        
        try {
            validationDateFin( dateFin );
        } catch ( Exception e ) {
            setErreur( "dateFin", e.getMessage() );
        }
        unFestival.setDateFin(dateFin);
        
        try {
            validationLogo( logo );
        } catch ( Exception e ) {
            setErreur( "logo", e.getMessage() );
        }
        unFestival.setLogo(logo);
        
        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'ajout.";
        } else {
            resultat = "Échec de l'ajout.";
        }
        System.out.println("resultat erreurs="+resultat);
        
        unFestival.setLogo(logo);
        unFestival.setDateFin(dateFin);
        unFestival.setDateDebut(dateDebut);
        unFestival.setAnnee(annee);
        unFestival.setNom(nom);
        return unFestival;   
    }
}
