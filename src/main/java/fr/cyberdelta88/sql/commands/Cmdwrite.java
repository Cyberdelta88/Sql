package fr.cyberdelta88.sql.commands;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Cmdwrite implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        MongoClient mongoClient = MongoClients.create("mongodb+srv://delta:delta@cluster0.zzyp9xp.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase database = mongoClient.getDatabase("mongodb_test");
        MongoCollection<Document> col = database.getCollection("col_test");

        if(sender instanceof Player) {
            Document data = new Document("Rank", "VIP")
                    .append("canfly", false)
                    .append("prefix", "VIP")
                    .append("numberOfBonusCoins", 100);
            col.insertOne(data);
        }

        return false;
    }
}
