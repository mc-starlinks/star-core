package com.starlinks.core.sdk.entity.configuration;

import com.starlinks.core.api.entity.configuration.StarFile;
import com.starlinks.core.sdk.StarImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

@Getter
@RequiredArgsConstructor
public final class StarYamlFile implements StarFile {

    private final JavaPlugin pluginInstance;
    private final String fileName;

    private FileConfiguration config;
    private File externalFile;

    @Override
    public StarFile loadInto() {

        if (externalFile == null || !externalFile.exists()) {
            pluginInstance.saveResource(fileName, false);
            externalFile = new File(pluginInstance.getDataFolder(), fileName);
        }

        config = YamlConfiguration.loadConfiguration(externalFile);
        return this;
    }

    @Override
    public String getString(String key) {
        final String content = config.getString(key);
        return StarImpl.STAR_GEAR.colourText(content);
    }
}