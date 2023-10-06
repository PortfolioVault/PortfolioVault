package com.example.portfoliovault.services;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.example.portfoliovault.models.MongoDBConnectionManager;
import com.mongodb.client.result.InsertOneResult;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import org.bson.BsonValue;
import org.bson.Document;

@Named
@ApplicationScoped
public class UserService {
    private static String DB_NAME = "PortfolioVault";
    private static String COLLECTION_NAME = "portfolios";

    public BsonValue registerUser(String firstName, String lastName, String email, String password) {
        MongoClient mongoClient = MongoDBConnectionManager.getMongoClient();

        // Get the database and collection (replace "your-database-name" and "users" with your actual names)
        MongoDatabase database = mongoClient.getDatabase(DB_NAME);
        MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

        // Create a document with user data and insert it into the collection
        Document userDocument = new Document()
                .append("firstname", firstName)
                .append("lastname", lastName)
                .append("email", email)
                .append("password", password);

        InsertOneResult result = collection.insertOne(userDocument);
        return result.getInsertedId();
    }
}
