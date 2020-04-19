package com.starlinks.test.command;

import com.starlinks.core.api.command.CommandTarget;
import com.starlinks.core.api.command.StarCommand;
import com.starlinks.core.api.command.StarCommandInfo;
import com.starlinks.core.sdk.commands.info.CommandInfo;
import org.bukkit.command.CommandSender;

public final class TestCommand implements StarCommand {

    @Override
    public StarCommandInfo getCommandInfo() {
        return CommandInfo.builder()
                .name("test")
                .target(CommandTarget.PLAYER)
                .permission("starlinks.admin")
                .aliases(new String[]{"testing"})
                .build();
    }

    @Override
    public void onCall(CommandSender sender, String label, String[] args) {
        sender.sendMessage("All Working!");
    }
}
