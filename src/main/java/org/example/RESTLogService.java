package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import org.bson.Document;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import static spark.Spark.port;
import static spark.Spark.post;

public class RESTLogService {

    public static void main(String[] args) {
        port(getPort());
        MongoClientURI uri = new MongoClientURI("mongodb://3.85.148.34:27017/monguitodb");

        MongoClient mongoClient = new MongoClient(uri);
        try {
            MongoDatabase database = mongoClient.getDatabase("monguitodb");
            post("/json", (request, response) -> {
                String body = request.body().substring(5);
                MongoCollection<Document> collection = database.getCollection("monguitodb");

                Document document = new Document("message", body)
                        .append("date", new Date());

                collection.insertOne(document);

                List<Document> documents = collection.find()
                        .projection(Projections.excludeId())
                        .sort(new Document("date", -1))
                        .limit(10)
                        .into(new ArrayList<>());

                JSONArray jsonArray = new JSONArray();
                for (Document d : documents) {
                    JSONObject jsonObject = new JSONObject(d);
                    jsonArray.add(jsonObject);
                }
                String json = jsonArray.toJSONString();
                response.status(200);
                return json;
            });


        } catch (MongoException e) {
            System.err.println("Error al conectarse a la base de datos MongoDB: " + e.getMessage());
        }
    }



    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4568;
    }


}
