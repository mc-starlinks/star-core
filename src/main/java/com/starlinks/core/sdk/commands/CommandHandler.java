package com.starlinks.core.sdk.commands;

import com.starlinks.core.api.command.CommandTarget;
import com.starlinks.core.api.command.StarCommand;
import com.starlinks.core.api.command.StarCommandFactory;
import com.starlinks.core.api.command.StarCommandInfo;
import com.starlinks.core.api.entity.properties.PropFile;
import com.starlinks.core.sdk.StarImpl;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public final class CommandHandler implements StarCommandFactory {

    private static final CommandMap commandMap = ((CraftServer) Bukkit.getServer())
            .getCommandMap();

    private final JavaPlugin instance;
    private final PropFile properties;

    public void register(StarCommand... command) {
        final List<Command> mappedCommands = Arrays
                .stream(command)
                .map(star -> new Dispatcher(this, star))
                .collect(Collectors.toList());

        final String prefixCallback = instance
                .getName()
                .toLowerCase();

        commandMap.registerAll(prefixCallback, mappedCommands);
    }

    public boolean executor(
            StarCommand star,
            CommandSender sender,
            String label,
            String[] args
    ) {

        StarCommandInfo info = star.getCommandInfo();
        if (StarImpl.PLAYER_CLASS.isInstance(sender)) {

            if (info.getTarget() == CommandTarget.CONSOLE) {
                final String onlyConsole = properties.get("ONLY_CONSOLE");
                sender.sendMessage(onlyConsole);
                return true;
            }

            Player player = (Player) sender;
            if (!player.hasPermission(info.getPermission())) {
                final String noEnoughPermission = properties.get("INSUFFICIENT_PERMISSION");
                sender.sendMessage(noEnoughPermission);
                return true;
            }

        } else if (info.getTarget() == CommandTarget.PLAYER) {
            final String onlyPlayer = properties.get("ONLY_PLAYER");
            sender.sendMessage(onlyPlayer);
            return true;
        }

        star.onCall(sender, label, args);
        return true;
    }
}
