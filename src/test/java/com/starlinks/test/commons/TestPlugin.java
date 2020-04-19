package com.starlinks.test.commons;

import com.starlinks.core.api.StarAPI;
import com.starlinks.test.command.TestCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        final ServicesManager services = Bukkit.getServicesManager();
        final StarAPI api = services.load(StarAPI.class);

        api.getCommandHandler().register(
                new TestCommand()
        );
    }
}
