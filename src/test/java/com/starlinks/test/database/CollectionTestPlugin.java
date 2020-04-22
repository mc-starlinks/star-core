package com.starlinks.test.database;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.starlinks.core.api.StarAPI;
import com.starlinks.core.api.database.mongo.StarCollectionProvider;
import com.starlinks.core.sdk.database.mongo.credentials.MongoURI;
import com.starlinks.test.database.pojo.TestPojo;
import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public final class CollectionTestPlugin extends JavaPlugin {

    private StarCollectionProvider provider;

    @Override
    public void onEnable() {
        final ServicesManager servicesManager = Bukkit.getServicesManager();
        final StarAPI api = servicesManager.load(StarAPI.class);

        provider = api.getDatabaseFactory()
                .newMongoProvider()
                .loginWithCredentials(
                        new MongoURI("mongodb://localhost:27017")
                );

        final MongoDatabase database = provider.getDatabase("starlinks");
        final MongoCollection<TestPojo> pojoCollection = database.getCollection(
                "test", TestPojo.class
        );

        /*
         * Simple insert item
         */
        final TestPojo testPojo = new TestPojo();
        testPojo.setUuid(UUID.randomUUID());
        testPojo.setMoney(10);

        pojoCollection.insertOne(testPojo);
    }

    @Override
    public void onDisable() {
        provider.closeConnection();
    }
}