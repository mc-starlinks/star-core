package com.starlinks.core.api;

import com.starlinks.core.api.command.StarCommandFactory;
import com.starlinks.core.api.database.StarDatabaseFactory;
import com.starlinks.core.api.entity.ScoreFactory;
import com.starlinks.core.api.entity.properties.PropFile;
import org.bukkit.plugin.java.JavaPlugin;

public interface StarAPI extends BaseAPI {

    StarDatabaseFactory getDatabaseFactory();
    PropFile getMessageProperties();
    JavaPlugin getInstance();
    ScoreFactory getScoreFactory();
    StarCommandFactory getCommandHandler();

}
