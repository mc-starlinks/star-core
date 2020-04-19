package com.starlinks.core.api.command;

import org.bukkit.command.CommandSender;

public interface StarCommandHandler {

    void register(StarCommand... command);
    boolean executor(StarCommand star, CommandSender sender, String label, String[] args);

}
