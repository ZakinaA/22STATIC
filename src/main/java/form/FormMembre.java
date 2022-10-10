package form;

import java.util.ArrayList;
import model.Genre;
import model.Groupe;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import model.Dispositif;
import model.Instrument;
import model.Membre;
import model.Statut;
import model.Utilisateur;

public class FormMembre {

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
    private void validationNom( String nom ) throws Exception {
        if ( nom == null) {
            throw new Exception( "Le nom ne peut pas être null." );
        }
    }

    private void validationPrenom( String prenom) throws Exception {
        if ( prenom == null) {
            throw new Exception( "le prenom ne peut pas être null." );
        }
    }
    
    private void validationLogin( String login) throws Exception {
        if ( login == null) {
            throw new Exception( "le login ne peut pas être null." );
        }
    }
    
    private void validationMdp( String mdp) throws Exception {
        if ( mdp == null) {
            throw new Exception( "le mdp ne peut pas être null." );
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
    public Utilisateur ajouterMembre(HttpServletRequest request ) {

        Membre unMembre  = new Membre();

        //récupération dans des variables des données saisies dans les champs de formulaire
        String nom = getDataForm( request, "nom" );
        String prenom = getDataForm( request, "prenom");
        int idInstrument = Integer.parseInt(getDataForm( request, "idInstrument" ));
        int idStatut = Integer.parseInt(getDataForm( request, "idStatut" ));

        try {
            validationNom( nom );
        } catch ( Exception e ) {
            setErreur( "nom", e.getMessage() );
        }
         unMembre.setNom(nom);
         
        try {
            validationPrenom( prenom );
        } catch ( Exception e ) {
            setErreur( "prenom", e.getMessage() );
        }
        unMembre.setPrenom(prenom);
        
     
        Statut leStatut = new Statut();
        leStatut.setId(idStatut);
        unMembre.setStatut(leStatut);
        
        Instrument leInstrument = new Instrument();
        leInstrument.setId(idInstrument);
        unMembre.setInstrument(leInstrument);
        
        Utilisateur unUtilisateur = new Utilisateur();
        String login = getDataForm( request, "login" );
        String mdp = getDataForm( request, "mdp");
        unUtilisateur.setMembre(unMembre);        
        
        try {
            validationLogin( login );
        } catch ( Exception e ) {
            setErreur( "login", e.getMessage() );
        }
        unUtilisateur.setLogin(login);
        
        try {
            validationMdp( mdp );
        } catch ( Exception e ) {
            setErreur( "mdp", e.getMessage() );
        }
        unUtilisateur.setMdp(mdp);
        
        
        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'ajout.";
        } else {
            resultat = "Échec de l'ajout.";
        }
        System.out.println("resultat erreurs="+resultat);
        
        return unUtilisateur;
        
        
    }
}
