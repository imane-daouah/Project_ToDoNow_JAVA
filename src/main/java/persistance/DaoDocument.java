package persistance;

import org.bson.Document;

import Métier.MetierPojo.DocumentPojo;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;

public class DaoDocument {
    private Connexion connexion;

    public DaoDocument(Connexion connexion) {
        this.connexion = connexion;
    }

    public List<DocumentPojo> getDocuments() {
        List<DocumentPojo> documents = new ArrayList<>();
        MongoCollection<Document> collection = connexion.getDatabase().getCollection("Documents");
        for (Document document : collection.find()) {
            documents.add(documentFromPojo(document));
        }
        return documents;
    }

    public DocumentPojo getDocument(String id) {
        Document document = connexion.findOneDocument("Documents", new Document("_id", new ObjectId(id)));
        return document != null ? documentFromPojo(document) : null;
    }

    public void ajouterDocument(DocumentPojo documentPojo) throws MongoWriteException {
        try {
            Document document = documentToPojo(documentPojo);
            connexion.insertDocument("Documents", document);
            documentPojo.setID(document.getObjectId("_id").toString());
        } catch (MongoWriteException e) {
            System.err.println("Erreur lors de l'ajout du document : " + e.getMessage());
            throw e;
        }
    }

    public void modifierDocument(String id, DocumentPojo documentModifie) throws IllegalArgumentException {
        try {
            Document document = documentToPojo(documentModifie);
            connexion.updateDocument("Documents", new Document("_id", new ObjectId(id)), document);
        } catch (IllegalArgumentException e) {
            System.err.println("ID invalide pour la modification du document : " + e.getMessage());
            throw e;
        }
    }

    public void supprimerDocument(String id) throws IllegalArgumentException {
        try {
            connexion.deleteDocument("Documents", new Document("_id", new ObjectId(id)));
        } catch (IllegalArgumentException e) {
            System.err.println("ID invalide pour la suppression du document : " + e.getMessage());
            throw e;
        }
    }

    // Méthode utilitaire pour convertir un objet DocumentPojo en Document
    private Document documentToPojo(DocumentPojo documentPojo) {
        return new Document("_id", new ObjectId(documentPojo.getID()))
                .append("description", documentPojo.getDescription())
                .append("date_ajout", documentPojo.getDate_ajout())
                .append("chemin_acces", documentPojo.getChemin_acces());
    }

    // Méthode utilitaire pour convertir un Document en objet DocumentPojo
    private DocumentPojo documentFromPojo(Document document) {
        DocumentPojo documentPojo = new DocumentPojo();
        documentPojo.setID(document.getObjectId("_id").toString());
        documentPojo.setDescription(document.getString("description"));
        documentPojo.setDate_ajout(document.getString("date_ajout"));
        documentPojo.setChemin_acces(document.getString("chemin_acces"));
        return documentPojo;
    }
}
