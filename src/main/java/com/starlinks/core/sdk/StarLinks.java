package com.starlinks.core.sdk;

import com.starlinks.core.api.StarAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class StarLinks extends JavaPlugin {

    private StarLinks instance;
    private StarAPI starApi;

    @Override
    public void onEnable() {
        instance = this;
        starApi = new StarImpl(instance);
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
