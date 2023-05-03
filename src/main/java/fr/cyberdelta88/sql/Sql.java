package fr.cyberdelta88.sql;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import fr.cyberdelta88.sql.commands.Cmdtest;
import fr.cyberdelta88.sql.commands.Cmdwrite;
import org.bson.Document;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.function.Consumer;

public final class Sql extends JavaPlugin {


    @Override
    public void onEnable() {
        MongoClient mongoClient = MongoClients.create("mongodb+srv://delta:delta@cluster0.zzyp9xp.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase database = mongoClient.getDatabase("sample_weatherdata");
        MongoCollection<Document> col = database.getCollection("data");
        col.find().forEach((Consumer<Document>) document -> {
            System.out.println(document.toJson());
        });

        this.getCommand("maventest").setExecutor(new Cmdtest());
        this.getCommand("mongodbwrite").setExecutor(new Cmdwrite());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
