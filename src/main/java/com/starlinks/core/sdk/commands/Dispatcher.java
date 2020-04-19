package com.starlinks.core.sdk.commands;

import com.starlinks.core.api.command.StarCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public final class Dispatcher extends Command {

    private final StarCommand command;
    private final CommandHandler handler;

    public Dispatcher(CommandHandler handler, StarCommand command) {
        super(
                command.getCommandInfo().getName(),
                "StarLinks<descriptor>",
                "StarLinks<usage>",
                command.getCommandInfo().getAliases()
        );

        this.handler = handler;
        this.command = command;
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        return handler.executor(
                command,
                commandSender,
                s,
                strings
        );
    }
}
