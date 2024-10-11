package Métier.MetierGestion;

import java.util.List;

import com.mongodb.MongoWriteException;

import Métier.MetierPojo.Seance;

import persistance.DaoSeance;

public class SeanceGestion {
	private DaoSeance daoSeance;

    public SeanceGestion(DaoSeance daoSeance) {
        this.daoSeance = daoSeance;
    }
    public Seance getSeance(String id) {
        return daoSeance.getSeance(id);
    }
    
    public List<Seance> getTaches() {
        return daoSeance.getSeances();
    }

    public void ajouterSeance(Seance seance) throws MongoWriteException {
        daoSeance.ajouterSeance(seance);
    }

    public void modifierSeance(String id, Seance seanceModifie) throws IllegalArgumentException {
        daoSeance.modifierSeance(id, seanceModifie);
    }

    public void supprimerSeance(String id) throws IllegalArgumentException {
        daoSeance.supprimerSeance(id);
    }

    public List<String> getDocumentsDuSeance(String seanceId) {
        return daoSeance.getDocumentsDuSeance(seanceId);
    }

    public void ajouterDocumentAuSeance(String seanceId, String documentId) {
        daoSeance.ajouterDocumentAuSeance(seanceId, documentId);
    }

    public void ajouternoteAuSeance(String seanceId, String notes) {
        daoSeance.ajouternoteAuSeance(seanceId, notes);
    }
}
