package com.starlinks.core.api;

import com.starlinks.core.api.command.StarCommandFactory;
import com.starlinks.core.api.database.StarDatabaseFactory;
import com.starlinks.core.api.database.mongo.StarCollectionProvider;
import com.starlinks.core.api.entity.configuration.StarFile;
import com.starlinks.core.api.entity.score.ScoreFactory;
import org.bukkit.plugin.java.JavaPlugin;

public interface StarAPI extends BaseAPI {

    StarDatabaseFactory getDatabaseFactory();
    StarFile getMessageFile();
    StarCollectionProvider getPrincipalProvider();
    StarFile getConfigFile();
    JavaPlugin getInstance();
    ScoreFactory getScoreFactory();
    StarCommandFactory getCommandHandler();

}
