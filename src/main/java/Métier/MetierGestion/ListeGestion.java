package Métier.MetierGestion;

import java.util.List;

import com.mongodb.MongoWriteException;

import Métier.MetierPojo.Liste;
import persistance.DaoListe;

public class ListeGestion {
	private DaoListe daoListe;

    public ListeGestion(DaoListe daoListe) {
        this.daoListe = daoListe;
    }

    public List<Liste> getDocuments() {
        return daoListe.getDocuments();
    }

    public Liste getListe(String id) {
        return daoListe.getListe(id);
    }

    public void ajouterListe(Liste listePojo) throws MongoWriteException {
        daoListe.ajouterListe(listePojo);
    }

    public void modifierListe(String id, Liste listeModifie) throws IllegalArgumentException {
        daoListe.modifierListe(id, listeModifie);
    }

    public void supprimerListe(String id) throws IllegalArgumentException {
        daoListe.supprimerListe(id);
    }
    
    public List<String> getTachesDeListe(String listeId) {
        return daoListe.getTachesDeListe(listeId);
    }
    
    public void ajouterTacheAListe(String listeId, String tacheId) {
        daoListe.ajouterTacheAListe(listeId, tacheId);
    }
}
