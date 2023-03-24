package stepsDefinition;

import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.logging.Logger;

public class dbConnection {

    public static MongoCollection<Document> booksCollection;
    public static MongoCollection<Document> companiesCollection;


}
