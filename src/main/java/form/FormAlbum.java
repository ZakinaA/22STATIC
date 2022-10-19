/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import model.Album;

/**
 *
 * @author sio2
 */
public class FormAlbum {
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
        if ( nom != null && nom.length() < 2 ) {
            throw new Exception( "Le nom de l'album est incorrect." );
        }
    }

    private void validationDateCreation( String dateCreation) throws Exception {
        if ( dateCreation != null && dateCreation.length() < 4  ) {
            throw new Exception( "la date de création est erronnée" );
        }
    }
    
    private void validationCheminImg( String cheminImg) throws Exception {
        if ( cheminImg != null && cheminImg.length() < 4  ) {
            throw new Exception( "L'image est erronnée" );
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
    public Album ajouterAlbum(HttpServletRequest request ) {

        Album unAlbum  = new Album();

        //récupération dans des variables des données saisies dans les champs de formulaire
        String nom = getDataForm( request, "nom" );
        String dateCreation = getDataForm( request, "dateCreation");
        String cheminImg = getDataForm( request, "cheminImg");
        
        System.out.println("resultat erreurs="+resultat);
        
        unAlbum.setCheminImg(cheminImg);
        unAlbum.setDateCreation(dateCreation);
        unAlbum.setNom(nom);
        return unAlbum;      
    }
}
