package Métier.MetierGestion;

import java.util.List;
import com.mongodb.MongoWriteException;
import Métier.MetierPojo.Projet;
import persistance.DaoProjet;
public class ProjetGestion {
	private DaoProjet daoProjet;
    
    public ProjetGestion(DaoProjet daoProjet) {
    	this.daoProjet=daoProjet;
    }
    
    public Projet getProjet(String id) {
        return daoProjet.getProjet(id);
    }
    public List<Projet> getProjets() {
        return daoProjet.getProjets();
    }

    public void ajouterProjet(Projet projet) throws MongoWriteException {
        daoProjet.ajouterProjet(projet);
    }
    
    public void modifierProjet(String id, Projet projetModifie) throws IllegalArgumentException {
        daoProjet.modifierProjet(id, projetModifie);
    }

    public void supprimerProjet(String id) throws IllegalArgumentException {
        daoProjet.supprimerProjet(id);
    }
    
    public List<String> getDocumentsDuProjet(String projetId) {
        return daoProjet.getDocumentsDuProjet(projetId);
    }
    
    public List<String> getSeancesDuProjet(String projetId) {
        return daoProjet.getSeancesDuProjet(projetId);
    }
    
    public List<String> getTachesDuProjet(String projetId) {
        return daoProjet.getTachesDuProjet(projetId);
    }
    
    public void ajouterDocumentAuProjet(String projetId, String documentId) {
        daoProjet.ajouterDocumentAuProjet(projetId, documentId);
    }
    
    public void ajouterTacheAuProjet(String projetId, String tacheId) {
        daoProjet.ajouterTacheAuProjet(projetId, tacheId);
    }
    
    public void ajouterSeanceAuProjet(String projetId, String seanceId) {
        daoProjet.ajouterSeanceAuProjet(projetId, seanceId);
    }
}
