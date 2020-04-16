package com.starlinks.core.teste;

import com.starlinks.core.api.command.CommandInfo;
import com.starlinks.core.api.command.CommandTarget;
import com.starlinks.core.api.command.StarCommand;
import org.bukkit.command.CommandSender;

public final class TesteCommand extends StarCommand {

    public TesteCommand() {
        super(CommandInfo.builder()
                .name("teste")
                .aliases(new String[]{"testando"})
                .target(CommandTarget.PLAYER)
                .build()
        );
    }

    @Override
    public void onCall(CommandSender sender, String label, String[] args) {
        sender.sendMessage("Lolo guei kkkkkkkkkkkkkk lindão");
    }
}
