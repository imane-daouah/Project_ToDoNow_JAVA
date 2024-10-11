package persistance;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;

import Métier.MetierPojo.Tache;

public class DaoTache {
	private Connexion connexion;

    public DaoTache(Connexion connexion) {
        this.connexion = connexion;
    }

    public List<Tache> getTaches() {
        List<Tache> taches = new ArrayList<>();
        MongoCollection<Document> collection = connexion.getDatabase().getCollection("Taches");
        for (Document tacheDoc : collection.find()) {
            taches.add(tacheFromDocument(tacheDoc));
        }
        return taches;
    }

    public Tache getTache(String id) {
        Document tacheDoc = connexion.findOneDocument("Taches", new Document("_id", new ObjectId(id)));
        return tacheDoc != null ? tacheFromDocument(tacheDoc) : null;
    }

    public void ajouterTache(Tache tache) throws MongoWriteException {
        try {
            Document nouvelleTache = tacheToDocument(tache);
            connexion.insertDocument("Taches", nouvelleTache);
            tache.setID(nouvelleTache.getObjectId("_id").toString());
        } catch (MongoWriteException e) {
            // Gérer l'exception d'écriture MongoDB
            System.err.println("Erreur lors de l'ajout de la tâche : " + e.getMessage());
            throw e;
        }
    }

    public void modifierTache(String id, Tache tacheModifie) throws IllegalArgumentException {
        try {
            Document tacheModifieDoc = tacheToDocument(tacheModifie);
            connexion.updateDocument("Taches", new Document("_id", new ObjectId(id)), tacheModifieDoc);
        } catch (IllegalArgumentException e) {
            // Gérer l'exception d'argument invalide
            System.err.println("ID invalide pour la modification de la tâche : " + e.getMessage());
            throw e;
        }
    }
    

    public void supprimerTache(String id) throws IllegalArgumentException {
        try {
            connexion.deleteDocument("Taches", new Document("_id", new ObjectId(id)));
        } catch (IllegalArgumentException e) {
            // Gérer l'exception d'argument invalide
            System.err.println("ID invalide pour la suppression de la tâche : " + e.getMessage());
            throw e;
        }
    }
    public List<String> getSeancesDeTache(String tacheId) {
        Document query = new Document("_id", new ObjectId(tacheId));
        MongoCollection<Document> tacheCollection = connexion.getDatabase().getCollection("Taches");
        Document tacheDoc = tacheCollection.find(query).first();
        return tacheDoc != null ? tacheDoc.getList("seance_id", String.class, new ArrayList<>()) : new ArrayList<>();
    }
    
    public void ajouterDocumentAuTache(String tacheId, String documentId) {
        try {
            Document query = new Document("_id", new ObjectId(tacheId));
            Document update = new Document("$addToSet", new Document("documents", documentId));
            MongoCollection<Document> tacheCollection = connexion.getDatabase().getCollection("taches");
            tacheCollection.updateOne(query, update);
        } catch (IllegalArgumentException e) {
            // Gérer l'exception d'argument invalide
            System.err.println("ID invalide pour l'ajout de document au tache : " + e.getMessage());
            throw e;
        }
    }
    
    public String getSeanceDeTache(String tacheId) {
        Document query = new Document("_id", new ObjectId(tacheId));
        MongoCollection<Document> tacheCollection = connexion.getDatabase().getCollection("Taches");
        Document tacheDoc = tacheCollection.find(query).first();
        return tacheDoc != null ? tacheDoc.getString("seance_id") : null;
    }
    
    // Méthode utilitaire pour convertir un objet Tache en Document
    private Document tacheToDocument(Tache tache) {
        return new Document("categorie", tache.getCategorie())
                .append("description", tache.getDescription())
                .append("date_debut", tache.getDate_debut())
                .append("date_fin", tache.getDate_fin())
               ;
    }

    // Méthode utilitaire pour convertir un Document en objet Tache
    private Tache tacheFromDocument(Document document) {
        Tache tache = new Tache(
                document.getString("categorie"),
                document.getString("description"),
                document.getString("date_debut"),
                document.getString("date_fin"),
                document.getString("statut")
        );
        tache.setID(document.getObjectId("_id").toString());
        List<String> documentsList = document.getList("documentes", String.class);
        if (documentsList != null) {
            tache.setDocuments_associes(new ArrayList<>(documentsList));
        } else {
            tache.setDocuments_associes(new ArrayList<>());
        }
        return tache;
    }
}
