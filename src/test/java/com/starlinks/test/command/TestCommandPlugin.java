package com.starlinks.test.command;

import com.starlinks.core.api.StarAPI;
import com.starlinks.core.api.database.StarDatabaseProvider;
import com.starlinks.core.sdk.database.credentials.UniversalCredentials;
import com.starlinks.test.command.TestCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestCommandPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        final ServicesManager services = Bukkit.getServicesManager();
        final StarAPI api = services.load(StarAPI.class);

        /*
         * Register the commands without use plugin.yml
         */
        api.getCommandHandler().register(
                new TestCommand()
        );
    }
}
