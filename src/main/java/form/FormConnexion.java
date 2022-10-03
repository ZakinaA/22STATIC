package form;

import model.Genre;
import model.Groupe;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import model.Dispositif;
import model.Instrument;
import model.Membre;
import model.Statut;

public class FormConnexion {

    private String resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();

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
    private void validationMail( String mail ) throws Exception {
        if ( mail != null) {
            throw new Exception( "Le mail ne peut pas être null." );
        }
    }

    private void validationMDP( String mdp) throws Exception {
        if ( mdp != null) {
            throw new Exception( "le mot de passe ne peut pas être null." );
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
    public Membre ajouterMembre(HttpServletRequest request ) {

        Membre unMembre  = new Membre();

        //récupération dans des variables des données saisies dans les champs de formulaire
        String mail = getDataForm( request, "mail" );
        String mdp = getDataForm( request, "mdp");

        try {
            validationMail( mail );
        } catch ( Exception e ) {
            setErreur( "mail", e.getMessage() );
        }
         unMembre.setMail(mail);
         
        try {
            validationMDP( mdp );
        } catch ( Exception e ) {
            setErreur( "mdp", e.getMessage() );
        }
        unMembre.setMDP(mdp);
        
        
        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'ajout.";
        } else {
            resultat = "Échec de l'ajout.";
        }
        System.out.println("resultat erreurs="+resultat);

        // hydratation de l'objet membre avec les variables valorisées ci-dessus
        

        return unMembre;
        
        
    }
}
