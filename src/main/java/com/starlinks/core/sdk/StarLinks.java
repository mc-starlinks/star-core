package com.starlinks.core.sdk;

import com.starlinks.core.api.StarAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class StarLinks extends JavaPlugin {

    private StarAPI starApi;

    @Override
    public void onEnable() {
        final StarLinks instance = getPlugin(StarLinks.class);
        starApi = new StarImpl(instance);

        /*
         * Starts the SDK
         */
        starApi.onActivate();

        final ServicesManager manager = Bukkit.getServicesManager();

        /*
         * Register the service instance, used to share api components
         */
        manager.register(
                StarAPI.class,
                starApi,
                instance,
                ServicePriority.Normal
        );
    }

    @Override
    public void onDisable() {
        starApi.onDeactivate();
    }
}
