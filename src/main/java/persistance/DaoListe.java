package persistance;

import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;

import Métier.MetierPojo.Liste;

public class DaoListe {
    private Connexion connexion;

    public DaoListe(Connexion connexion) {
        this.connexion = connexion;
    }

    public List<Liste> getDocuments() {
        List<Liste> listes = new ArrayList<>();
        MongoCollection<Document> collection = connexion.getDatabase().getCollection("Listes");
        for (Document liste : collection.find()) {
            listes.add(listeFromPojo(liste));
        }
        return listes;
    }

    public Liste getListe(String id) {
        Document document = connexion.findOneDocument("Listes", new Document("_id", new ObjectId(id)));
        return document != null ? listeFromPojo(document) : null;
    }

    public void ajouterListe(Liste listePojo) throws MongoWriteException {
        try {
            Document liste = listeToPojo(listePojo);
            connexion.insertDocument("Listes", liste);
            listePojo.setID(liste.getObjectId("_id").toString());
        } catch (MongoWriteException e) {
            System.err.println("Erreur lors de l'ajout du document : " + e.getMessage());
            throw e;
        }
    }

    public void modifierListe(String id, Liste listeModifie) throws IllegalArgumentException {
        try {
            Document liste = listeToPojo(listeModifie);
            connexion.updateDocument("Listes", new Document("_id", new ObjectId(id)), liste);
        } catch (IllegalArgumentException e) {
            System.err.println("ID invalide pour la modification du document : " + e.getMessage());
            throw e;
        }
    }

    public void supprimerListe(String id) throws IllegalArgumentException {
        try {
            connexion.deleteDocument("Listes", new Document("_id", new ObjectId(id)));
        } catch (IllegalArgumentException e) {
            System.err.println("ID invalide pour la suppression du document : " + e.getMessage());
            throw e;
        }
    }
    
    public List<String> getTachesDeListe(String listeId) {
        Document query = new Document("_id", new ObjectId(listeId));
        MongoCollection<Document> listeCollection = connexion.getDatabase().getCollection("Listes");
        Document listeDoc = listeCollection.find(query).first();
        return listeDoc != null ? listeDoc.getList("taches", String.class, new ArrayList<>()) : new ArrayList<>();
    }
    
    public void ajouterTacheAListe(String listeId, String tacheId) {
        try {
            Document query = new Document("_id", new ObjectId(listeId));
            Document update = new Document("$addToSet", new Document("taches", tacheId));
            MongoCollection<Document> listeCollection = connexion.getDatabase().getCollection("Listes");
            listeCollection.updateOne(query, update);
        } catch (IllegalArgumentException e) {
            // Gérer l'exception d'argument invalide
            System.err.println("ID invalide pour l'ajout de tache à la liste : " + e.getMessage());
            throw e;
        }
    }

    // Méthode utilitaire pour convertir un objet Liste en Document
    private Document listeToPojo(Liste liste) {
        return new Document("_id", new ObjectId(liste.getID()))
                .append("description", liste.getDescription())
                .append("taches", liste.getTaches_id());
    }

    // Méthode utilitaire pour convertir un Document en objet Liste
    private Liste listeFromPojo(Document document) {
        Liste liste = new Liste();
        liste.setDescription(document.getString("description"));
        List<String> tachesList = document.getList("taches", String.class);
        if (tachesList != null) {
            liste.setTaches_id(new ArrayList<>(tachesList));
        } else {
            liste.setTaches_id(new ArrayList<>());
        }
        liste.setID(document.getObjectId("_id").toString());
        return liste;
    }
}
