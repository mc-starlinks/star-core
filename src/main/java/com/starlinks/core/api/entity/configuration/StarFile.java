package com.starlinks.core.api.entity.configuration;

import org.bukkit.plugin.java.JavaPlugin;

public interface StarFile {

    String getFileName();

    JavaPlugin getPluginInstance();

    StarFile loadInto();

    String getString(String key);
}
