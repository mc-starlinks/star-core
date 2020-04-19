package com.starlinks.core.api;

import com.starlinks.core.api.command.StarCommandHandler;
import com.starlinks.core.api.entity.ScoreFactory;
import com.starlinks.core.api.entity.properties.PropFile;
import org.bukkit.plugin.java.JavaPlugin;

public interface StarAPI extends BaseAPI {

    PropFile getMessageProperties();
    JavaPlugin getInstance();
    ScoreFactory getScoreFactory();
    StarCommandHandler getCommandHandler();

}
