package com.starlinks.core.api.command;

import org.bukkit.command.CommandSender;

public interface StarCommand {

    StarCommandInfo getCommandInfo();

    void onCall(CommandSender sender, String label, String[] args);
}
