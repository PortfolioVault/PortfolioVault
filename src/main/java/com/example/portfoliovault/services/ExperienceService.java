package com.example.portfoliovault.services;

import com.example.portfoliovault.models.Experience;
import com.example.portfoliovault.models.MongoDBConnectionManager;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import org.bson.BsonValue;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Named
@ApplicationScoped
public class ExperienceService {

    private static String DB_NAME = "PortfolioVault";
    private static String COLLECTION_NAME = "portfolios";

    public void addExperience(BsonValue userId, Experience experience) {

        MongoClient mongoClient = MongoDBConnectionManager.getMongoClient();
        MongoDatabase database = mongoClient.getDatabase(DB_NAME);

        MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

        Document lastExperience = experience.toDocument();
        Bson filter = Filters.eq("_id", userId);
        Bson update = Updates.addToSet("experiences", lastExperience);
        UpdateOptions options = new UpdateOptions().upsert(true);

        // Update the user document based on the userId
        collection.updateOne(filter, update, options);
    }
}