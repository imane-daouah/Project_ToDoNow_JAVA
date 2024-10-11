package persistance;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.MongoException;



import org.bson.Document;

public class Connexion {
	private static Connexion instance;
    private MongoClient mongoClient;
    private MongoDatabase database;

    // Constructeur privé pour empêcher l'instanciation directe depuis l'extérieur
    private Connexion() {
        try {
            // Connexion à MongoDB
            mongoClient = MongoClients.create("mongodb://localhost:27017");
            // Sélection de la base de données
            database = mongoClient.getDatabase("GestionTaches");
        } catch (MongoException e) {
            System.err.println("Erreur de connexion à MongoDB : " + e.getMessage());
        }
    }

    // Méthode pour obtenir l'instance unique de la connexion
    public static synchronized Connexion getInstance() {
        if (instance == null) {
            instance = new Connexion();
        }
        return instance;
    }

    // Méthode pour obtenir la base de données
    public MongoDatabase getDatabase() {
        return database;
    }

    // Méthode pour insérer un document dans une collection
    public void insertDocument(String collectionName, Document document) {
        try {
            MongoCollection<Document> collection = database.getCollection(collectionName);
            collection.insertOne(document);
        } catch (MongoException e) {
            System.err.println("Erreur lors de l'insertion du document : " + e.getMessage());
        }
    }

    // Méthode pour lire tous les documents d'une collection
    public void readAllDocuments(String collectionName) {
        try {
            MongoCollection<Document> collection = database.getCollection(collectionName);
            for (Document doc : collection.find()) {
                System.out.println(doc.toJson());
            }
        } catch (MongoException e) {
            System.err.println("Erreur lors de la lecture des documents : " + e.getMessage());
        }
    }
 // Méthode pour lire un document dans une collection par un filtre donné
    public Document findOneDocument(String collectionName, Document filter) {
        try {
            MongoCollection<Document> collection = database.getCollection(collectionName);
            return collection.find(filter).first();
        } catch (MongoException e) {
            System.err.println("Erreur lors de la lecture du document : " + e.getMessage());
            throw e;
        }
    }

    // Méthode pour mettre à jour un document dans une collection
    public void updateDocument(String collectionName, Document filter, Document updatedDocument) {
        try {
            MongoCollection<Document> collection = database.getCollection(collectionName);
            collection.replaceOne(filter, updatedDocument);
        } catch (MongoException e) {
            System.err.println("Erreur lors de la mise à jour du document : " + e.getMessage());
            throw e;
        }
    }

    // Méthode pour supprimer un document dans une collection
    public void deleteDocument(String collectionName, Document filter) {
        try {
            MongoCollection<Document> collection = database.getCollection(collectionName);
            collection.deleteOne(filter);
        } catch (MongoException e) {
            System.err.println("Erreur lors de la suppression du document : " + e.getMessage());
            throw e;
        }
    }
}

