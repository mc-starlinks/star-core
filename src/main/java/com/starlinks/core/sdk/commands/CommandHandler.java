package com.starlinks.core.sdk.commands;

import com.starlinks.core.api.StarAPI;
import com.starlinks.core.api.command.CommandInfo;
import com.starlinks.core.api.command.CommandTarget;
import com.starlinks.core.api.command.StarCommand;
import com.starlinks.core.sdk.StarGear;
import com.starlinks.core.sdk.StarImpl;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
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
public final class CommandHandler {

    private static final String INSUFFICIENT_PERMISSION = StarGear.colourText(
            "&cVocê não tem permissão necessária para executar este comando."
    );

    private static final String ONLY_CONSOLE = StarGear.colourText(
            "&cApenas o console pode executar este comando."
    );

    private static final String ONLY_PLAYER = StarGear.colourText(
            "&cApenas jogadores podem executar este comando."
    );

    private static final CommandMap commandMap = ((CraftServer) Bukkit.getServer())
            .getCommandMap();

    private final JavaPlugin instance;
    private final StarImpl starAPI;

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

        CommandInfo info = star.getInfo();
        if (starAPI.getPlayerClass().isInstance(sender)) {

            if(info.getTarget() == CommandTarget.CONSOLE) {
                sender.sendMessage(ONLY_CONSOLE);
                return true;
            }

            Player player = (Player) sender;
            if (info.getPermission() != null && !player.hasPermission(info.getPermission())) {
                sender.sendMessage(INSUFFICIENT_PERMISSION);
                return true;
            }
        } else {
            if(info.getTarget() == CommandTarget.PLAYER) {
                sender.sendMessage(ONLY_PLAYER);
                return true;
            }
        }

        star.onCall(sender, label, args);
        return true;
    }
}
