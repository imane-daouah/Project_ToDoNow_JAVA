package persistance;

import org.bson.Document;
import org.bson.types.ObjectId;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import Métier.MetierPojo.Projet;
import java.util.ArrayList;
import java.util.List;

public class DaoProjet {
	private Connexion connexion;

    public DaoProjet(Connexion connexion) {
        this.connexion = connexion;
    }

    public List<Projet> getProjets() {
    	List<Projet> projets = new ArrayList<>();
        MongoCollection<Document> collection = connexion.getDatabase().getCollection("Projets");
    	for (Document projet : collection.find()) {
            projets.add(projetFromDocument(projet));
        }
        return projets;
    }

    public Projet getProjet(String id) {
        Document projetDoc = connexion.findOneDocument("Projets", new Document("_id", new ObjectId(id)));
        return projetDoc != null ? projetFromDocument(projetDoc) : null;
    }

    public void ajouterProjet(Projet projet) throws MongoWriteException {
        try {
            Document nouveauProjet = projetToDocument(projet);
            connexion.insertDocument("Projets", nouveauProjet);
            projet.setID(nouveauProjet.getObjectId("_id").toString());
        } catch (MongoWriteException e) {
            // Gérer l'exception d'écriture MongoDB
            System.err.println("Erreur lors de l'ajout du projet : " + e.getMessage());
            throw e;
        }
    }

    public void modifierProjet(String id, Projet projetModifie) throws IllegalArgumentException {
        try {
        	Document projetModifie1 = projetToDocument(projetModifie);
            connexion.updateDocument("Projets", new Document("_id", new ObjectId(id)), projetModifie1);
        } catch (IllegalArgumentException e) {
            // Gérer l'exception d'argument invalide
            System.err.println("ID invalide pour la modification du projet : " + e.getMessage());
            throw e;
        }
    }

    public void supprimerProjet(String id) throws IllegalArgumentException {
        try {
            connexion.deleteDocument("Projets", new Document("_id", new ObjectId(id)));
        } catch (IllegalArgumentException e) {
            // Gérer l'exception d'argument invalide
            System.err.println("ID invalide pour la suppression du projet : " + e.getMessage());
            throw e;
        }
    }
    
    public List<String> getDocumentsDuProjet(String projetId) {
        Document query = new Document("_id", new ObjectId(projetId));
        MongoCollection<Document> projetCollection = connexion.getDatabase().getCollection("Projets");
        Document projetDoc = projetCollection.find(query).first();
        return projetDoc != null ? projetDoc.getList("documents", String.class, new ArrayList<>()) : new ArrayList<>();
    }
    
    public List<String> getSeancesDuProjet(String projetId) {
        Document query = new Document("_id", new ObjectId(projetId));
        MongoCollection<Document> projetCollection = connexion.getDatabase().getCollection("Projets");
        Document projetDoc = projetCollection.find(query).first();
        return projetDoc != null ? projetDoc.getList("seances", String.class, new ArrayList<>()) : new ArrayList<>();
    }
    
    public List<String> getTachesDuProjet(String projetId) {
        Document query = new Document("_id", new ObjectId(projetId));
        MongoCollection<Document> projetCollection = connexion.getDatabase().getCollection("Projets");
        Document projetDoc = projetCollection.find(query).first();
        return projetDoc != null ? projetDoc.getList("taches", String.class, new ArrayList<>()) : new ArrayList<>();
    }
    
    public void ajouterDocumentAuProjet(String projetId, String documentId) {
        try {
            Document query = new Document("_id", new ObjectId(projetId));
            Document update = new Document("$addToSet", new Document("documents", documentId));
            MongoCollection<Document> projetCollection = connexion.getDatabase().getCollection("Projets");
            projetCollection.updateOne(query, update);
        } catch (IllegalArgumentException e) {
            // Gérer l'exception d'argument invalide
            System.err.println("ID invalide pour l'ajout de document au projet : " + e.getMessage());
            throw e;
        }
    }
    
    public void ajouterTacheAuProjet(String projetId, String tacheId) {
        try {
            Document query = new Document("_id", new ObjectId(projetId));
            Document update = new Document("$addToSet", new Document("taches", tacheId));
            MongoCollection<Document> projetCollection = connexion.getDatabase().getCollection("Projets");
            projetCollection.updateOne(query, update);
        } catch (IllegalArgumentException e) {
            // Gérer l'exception d'argument invalide
            System.err.println("ID invalide pour l'ajout de tâche au projet : " + e.getMessage());
            throw e;
        }
    }
    
    public void ajouterSeanceAuProjet(String projetId, String seanceId) {
        try {
            Document query = new Document("_id", new ObjectId(projetId));
            Document update = new Document("$addToSet", new Document("seances", seanceId));
            MongoCollection<Document> projetCollection = connexion.getDatabase().getCollection("Projets");
            projetCollection.updateOne(query, update);
        } catch (IllegalArgumentException e) {
            // Gérer l'exception d'argument invalide
            System.err.println("ID invalide pour l'ajout de séance au projet : " + e.getMessage());
            throw e;
        }
    }
 // Méthode utilitaire pour convertir un objet Projet en Document
    private Document projetToDocument(Projet projet) {
        return new Document("categorie", projet.getCategorie())
                .append("type", projet.getType())
                .append("description", projet.getDescription())
                .append("date_debut", projet.getDate_debut())
                .append("date_fin", projet.getDate_fin())
               /* .append("statut", "ouvert")
                .append("seances", projet.getSeances())
                .append("document", projet.getDocuments())*/;
               
    }

    // Méthode utilitaire pour convertir un Document en objet Projet
    private Projet projetFromDocument(Document document) {
        Projet projet = new Projet(
                document.getString("categorie"),
                document.getString("type"),
                document.getString("description"),
                document.getString("date_debut"),
                document.getString("date_fin"));
        projet.setID(document.getObjectId("_id").toString());

        // Traitement des listes qui peuvent être null
        List<String> tachesList = document.getList("taches", String.class);
        if (tachesList != null) {
            projet.setTaches(new ArrayList<>(tachesList));
        } else {
            projet.setTaches(new ArrayList<>());
        }

        List<String> seancesList = document.getList("seances", String.class);
        if (seancesList != null) {
            projet.setSeances(new ArrayList<>(seancesList));
        } else {
            projet.setSeances(new ArrayList<>());
        }

        List<String> documentsList = document.getList("documents", String.class);
        if (documentsList != null) {
            projet.setDocuments(new ArrayList<>(documentsList));
        } else {
            projet.setDocuments(new ArrayList<>());
        }

        return projet;
    }
   
}
