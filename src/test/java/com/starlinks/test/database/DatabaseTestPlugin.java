package com.starlinks.test.database;

import com.starlinks.core.api.StarAPI;
import com.starlinks.core.api.database.StarDatabaseProvider;
import com.starlinks.core.sdk.database.credentials.UniversalCredentials;
import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class DatabaseTestPlugin extends JavaPlugin {

    private StarDatabaseProvider provider;

    @Override
    public void onEnable() {
        final ServicesManager servicesManager = Bukkit.getServicesManager();
        final StarAPI api = servicesManager.load(StarAPI.class);

        provider = api.getDatabaseFactory()
                .newMysqlProvider()
                .loginWithCredentials(
                        new UniversalCredentials("localhost:3304", "starlinks", "root", "")
                );

        if(provider.openAllConnections()) {
            provider.update("create table if not exists starcore(own varchar(1))");
        }
    }

    @Override
    public void onDisable() {
        provider.closeAllConnections();
    }
}
