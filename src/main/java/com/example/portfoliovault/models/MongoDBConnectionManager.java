package com.example.portfoliovault.models;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoDBConnectionManager {
    private static String CONNECTION_URI = "mongodb://localhost:27017";
    private static MongoClient mongoClient;

    static {
       try{
           mongoClient = MongoClients.create(CONNECTION_URI);
       }catch (Exception exception){
           exception.printStackTrace();
       }
    }

    public static MongoClient getMongoClient() {
        return mongoClient;
    }
}
