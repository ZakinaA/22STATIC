package form;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import model.Dispositif;

public class FormDispositif {

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
    private void validationNom( String libelle ) throws Exception {
        if ( libelle != null && libelle.length() < 3 ) {
            throw new Exception( "Le nom du dispositif est incorrect." );
        }
    }

    private void validationDateCreation( String dateCreation) throws Exception {
        if ( dateCreation != null && dateCreation.length() < 4  ) {
            throw new Exception( "la date de création est erronnée" );
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
    public Dispositif ajouterDispositif(HttpServletRequest request ) {

        Dispositif unDispositif  = new Dispositif();

        //récupération dans des variables des données saisies dans les champs de formulaire
        String libelle = getDataForm( request, "libelle" );
        String dateCreation = getDataForm( request, "dateCreation");

        try {
            validationNom( libelle );
        } catch ( Exception e ) {
            setErreur( "libelle", e.getMessage() );
        }
        
        try {
            validationDateCreation( dateCreation );
        } catch ( Exception e ) {
            setErreur( "dateCreation", e.getMessage() );
        }

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'ajout.";
        } else {
            resultat = "Échec de l'ajout.";
        }
        System.out.println("resultat erreurs="+resultat);
        
        unDispositif.setAnnee(Integer.parseInt(dateCreation));
        unDispositif.setLibelle(libelle);
        return unDispositif;      
    }
}
