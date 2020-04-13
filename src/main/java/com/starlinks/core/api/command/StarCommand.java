package com.starlinks.core.api.command;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.command.CommandSender;

@Getter
@RequiredArgsConstructor
public abstract class StarCommand {

    private final CommandInfo info;

    public abstract void onCall(CommandSender sender, String label, String[] args);
}
