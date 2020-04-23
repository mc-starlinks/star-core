package com.starlinks.core.sdk.entity.configuration;

import com.starlinks.core.api.entity.configuration.StarFile;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
@RequiredArgsConstructor
public final class StarYamlFile implements StarFile {

    private final JavaPlugin pluginInstance;
    private final String fileName;

    @Override
    public StarFile loadInto() {
        return this;
    }
}