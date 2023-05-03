package fr.cyberdelta88.sql.commands;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Cmdtest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player p =(Player) sender;
            p.sendMessage(ChatColor.GOLD + "it worked");
            MongoClient mongoClient = MongoClients.create("mongodb+srv://delta:delta@cluster0.zzyp9xp.mongodb.net/?retryWrites=true&w=majority");
            MongoDatabase database = mongoClient.getDatabase("sample_weatherdata");
            MongoCollection<Document> col = database.getCollection("data");
            Document data1 = col.find().first();
            System.out.println(data1.getString("callLetters"));
            p.sendMessage(data1.getString("callLetters"));
        }
        return false;
    }
}
