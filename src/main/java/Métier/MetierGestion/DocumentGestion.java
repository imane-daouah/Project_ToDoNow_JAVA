package Métier.MetierGestion;

import java.util.List;

import com.mongodb.MongoWriteException;

import Métier.MetierPojo.DocumentPojo;
import persistance.DaoDocument;

public class DocumentGestion {
	private DaoDocument daoDocument;

    public DocumentGestion(DaoDocument daoDocument) {
        this.daoDocument = daoDocument;
    }

    public List<DocumentPojo> getDocuments() {
        return daoDocument.getDocuments();
    }

    public DocumentPojo getDocument(String id) {
        return daoDocument.getDocument(id);
    }

    public void ajouterDocument(DocumentPojo documentPojo) throws MongoWriteException {
        daoDocument.ajouterDocument(documentPojo);
    }

    public void modifierDocument(String id, DocumentPojo documentModifie) throws IllegalArgumentException {
        daoDocument.modifierDocument(id, documentModifie);
    }

    public void supprimerDocument(String id) throws IllegalArgumentException {
        daoDocument.supprimerDocument(id);
    }
}
