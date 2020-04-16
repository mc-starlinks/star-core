package com.starlinks.core.api;

import com.starlinks.core.api.entity.ScoreFactory;
import com.starlinks.core.api.entity.properties.PropFile;
import com.starlinks.core.sdk.commands.CommandHandler;
import org.bukkit.plugin.java.JavaPlugin;

public interface StarAPI {

    PropFile getMessageProperties();
    JavaPlugin getInstance();
    ScoreFactory getScoreFactory();
    CommandHandler getCommandHandler();

    void onActivate();
    void onDeactivate();
}
