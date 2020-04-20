package com.starlinks.test.scoreboard;

import com.starlinks.core.api.StarAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestScoreboardPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        final ServicesManager services = Bukkit.getServicesManager();
        final StarAPI api = services.load(StarAPI.class);

        /*
         * Just initialize the bukkit's asynchronous task
         */
        ScoreboardTaskTest taskTest = new ScoreboardTaskTest(api);
    }
}
