package com.example.portfoliovault.services;

import com.example.portfoliovault.models.Experience;
import com.example.portfoliovault.models.MongoDBConnectionManager;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import org.bson.BsonValue;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Named
@ApplicationScoped
public class ExperienceService {

    private static String DB_NAME = "PortfolioVault";
    private static String COLLECTION_NAME = "portfolios";

    public void addExperience(BsonValue userId, LinkedList<Experience> experiences) {

        MongoClient mongoClient = MongoDBConnectionManager.getMongoClient();
        MongoDatabase database = mongoClient.getDatabase(DB_NAME);

        //1st Methode
        MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

        // Create a document with experiences and update the user document
        List<Document> experienceDocuments = new ArrayList<>();
        for (Experience experience : experiences) {
            experienceDocuments.add(experience.toDocument());
        }

        // Create an update query to add experiences to the user document
        Document updateQuery = new Document("$push", new Document("experiences", new Document("$each", experienceDocuments)));

        // Update the user document based on the userId
        collection.updateOne(Filters.eq("_id", userId), updateQuery);

    }
}