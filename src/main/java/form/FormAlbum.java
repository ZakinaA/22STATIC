/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form;

import dao.DaoGroupe;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import model.Album;
import model.Groupe;
import static test.ConnexionBdd.connection;

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

    private void validationDescription(String description) throws Exception {
        if (description != null && description.length() < 10) {
            throw new Exception("La description de l'album est incorrecte.");
        }
    }

    private void validationCheminImg(String cheminImg) throws Exception {
        if (cheminImg == null || cheminImg.equals("")) {
            throw new Exception("Le chemin de l'image de l'album est obligatoire.");
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

        // récupération dans des variables des données saisies dans les champs de formulaire
        String nom = getDataForm(request, "nom");
        String lienPlaylist = getDataForm(request, "lienPlaylist");
        String description = getDataForm(request, "description");
        String date = getDataForm(request, "date");
        String image = getDataForm(request, "image");
        int idGroupe = Integer.valueOf(getDataForm(request, "groupeId")); //Cast un string vers int
        
        Groupe leGroupe = new Groupe();
        leGroupe.setId(idGroupe);
        
        unAlbum.setNom(nom);
        unAlbum.setLienAlbum(lienPlaylist);
        unAlbum.setDescription(description);
        unAlbum.setDateCreation(date);
        unAlbum.setCheminImg(image);
        unAlbum.setGroupe(leGroupe);
        
        try {
            validationNom(nom);
        } catch (Exception e) {
            setErreur("nom", e.getMessage());
        }

        try {
            validationDescription(description);
        } catch (Exception e) {
            setErreur("description", e.getMessage());
        }

        /*try {
            validationDate(date);
        } catch (Exception e) {
            setErreur("date", e.getMessage());
        }*/

        /*try {
            validationImage(image);
        } catch (Exception e) {
            setErreur("image", e.getMessage());
        }*/

        if (erreurs.isEmpty()) {
            resultat = "Succès de l'ajout de l'album.";
        } else {
            resultat = "Échec de l'ajout de l'album.";
        }
        
        return unAlbum;      
    }
}
