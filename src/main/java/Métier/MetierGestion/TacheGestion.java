package Métier.MetierGestion;

import java.util.List;

import com.mongodb.MongoWriteException;

import Métier.MetierPojo.Tache;
import persistance.DaoTache;

public class TacheGestion {
	private DaoTache daoTache;

    public TacheGestion(DaoTache daoTache) {
        this.daoTache = daoTache;
    }

    public List<Tache> getTaches() {
        return daoTache.getTaches();
    }

    public Tache getTache(String id) {
        return daoTache.getTache(id);
    }

    public void ajouterTache(Tache tache) throws MongoWriteException {
        daoTache.ajouterTache(tache);
    }

    public void modifierTache(String id, Tache tacheModifie) throws IllegalArgumentException {
        daoTache.modifierTache(id, tacheModifie);
    }

    public void supprimerTache(String id) throws IllegalArgumentException {
        daoTache.supprimerTache(id);
    }

    public List<String> getSeancesDeTache(String tacheId) {
        return daoTache.getSeancesDeTache(tacheId);
    }

    public void ajouterDocumentAuTache(String tacheId, String documentId) {
        daoTache.ajouterDocumentAuTache(tacheId, documentId);
    }

    public String getSeanceDeTache(String tacheId) {
        return daoTache.getSeanceDeTache(tacheId);
    }
}
