package persistance;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;


import Métier.MetierPojo.Seance;

public class DaoSeance {
	 private Connexion connexion;

	    public DaoSeance(Connexion connexion) {
	        this.connexion = connexion;
	    }

	    public List<Seance> getSeances() {
	        List<Seance> seances = new ArrayList<>();
	        MongoCollection<Document> collection = connexion.getDatabase().getCollection("Seances");
	        for (Document seance : collection.find()) {
	            seances.add(seanceFromPojo(seance));
	        }
	        return seances;
	    }

	    public Seance getSeance(String id) {
	        Document document = connexion.findOneDocument("Seances", new Document("_id", new ObjectId(id)));
	        return document != null ? seanceFromPojo(document) : null;
	    }

	    public void ajouterSeance(Seance seancePojo) throws MongoWriteException {
	        try {
	            Document seance = seanceToPojo(seancePojo);
	            connexion.insertDocument("Seances", seance);
	            seancePojo.setID(seance.getObjectId("_id").toString());
	        } catch (MongoWriteException e) {
	            System.err.println("Erreur lors de l'ajout du document : " + e.getMessage());
	            throw e;
	        }
	    }

	    public void modifierSeance(String id, Seance seanceModifie) throws IllegalArgumentException {
	        try {
	            Document seance = seanceToPojo(seanceModifie);
	            connexion.updateDocument("Seances", new Document("_id", new ObjectId(id)), seance);
	        } catch (IllegalArgumentException e) {
	            System.err.println("ID invalide pour la modification du document : " + e.getMessage());
	            throw e;
	        }
	    }

	    public void supprimerSeance(String id) throws IllegalArgumentException {
	        try {
	            connexion.deleteDocument("Seances", new Document("_id", new ObjectId(id)));
	        } catch (IllegalArgumentException e) {
	            System.err.println("ID invalide pour la suppression du document : " + e.getMessage());
	            throw e;
	        }
	    }
	    
	    public List<String> getDocumentsDuSeance(String seanceId) {
	        Document query = new Document("_id", new ObjectId(seanceId));
	        MongoCollection<Document> seanceCollection = connexion.getDatabase().getCollection("Seances");
	        Document seanceDoc = seanceCollection.find(query).first();
	        return seanceDoc != null ? seanceDoc.getList("documents", String.class, new ArrayList<>()) : new ArrayList<>();
	    }
	    
	    public void ajouterDocumentAuSeance(String seanceId, String documentId) {
	        try {
	            Document query = new Document("_id", new ObjectId(seanceId));
	            Document update = new Document("$addToSet", new Document("documents", documentId));
	            MongoCollection<Document> seanceCollection = connexion.getDatabase().getCollection("Seances");
	            seanceCollection.updateOne(query, update);
	        } catch (IllegalArgumentException e) {
	            // Gérer l'exception d'argument invalide
	            System.err.println("ID invalide pour l'ajout de document au seance : " + e.getMessage());
	            throw e;
	        }
	    }
	    
	    public void ajouternoteAuSeance(String seanceId, String notes) {
	        try {
	            Document query = new Document("_id", new ObjectId(seanceId));
	            Document update = new Document("$set", new Document("notes", notes));
	            MongoCollection<Document> seanceCollection = connexion.getDatabase().getCollection("Seances");
	            seanceCollection.updateOne(query, update);
	        } catch (IllegalArgumentException e) {
	            // Gérer l'exception d'argument invalide
	            System.err.println("ID invalide pour l'ajout de document au seance : " + e.getMessage());
	            throw e;
	        }
	    }

	    // Méthode utilitaire pour convertir un objet DocumentPojo en Document
	    private Document seanceToPojo(Seance seance) {
	        return new Document("_id", new ObjectId(seance.getID()))
	                .append("description", seance.getDescription())
	                .append("date_debut", seance.getDate_debut())
	                .append("date_fin", seance.getDate_fin())
	                .append("notes", seance.getNotes());
	    }

	    // Méthode utilitaire pour convertir un Document en objet DocumentPojo
	    private Seance seanceFromPojo(Document document) {
	        Seance seance = new Seance();
	        seance.setDescription(document.getString("description"));
	        seance.setDate_debut(document.getString("date_debut"));
	        seance.setDate_fin(document.getString("date_fin"));
	        seance.setNotes(document.getString("notes"));
	        seance.setID(document.getObjectId("_id").toString());
	        List<String> documentsList = document.getList("documentes", String.class);
	        if (documentsList != null) {
	            seance.setDocuments(new ArrayList<>(documentsList));
	        } else {
	            seance.setDocuments(new ArrayList<>());
	        }
	        return seance;
	    }
}
