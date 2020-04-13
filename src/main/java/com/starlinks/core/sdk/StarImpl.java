package com.starlinks.core.sdk;

import com.starlinks.core.api.StarAPI;
import com.starlinks.core.api.entity.ScoreFactory;
import com.starlinks.core.sdk.commands.CommandHandler;
import com.starlinks.core.sdk.entity.ScoreImpl;
import com.starlinks.core.teste.ScoreTask;
import com.starlinks.core.teste.TesteCommand;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;

@Getter
@RequiredArgsConstructor
public final class StarImpl implements StarAPI {

    private final Class<Player> playerClass = Player.class;

    private final StarLinks instance;

    private CommandHandler commandHandler;
    private ScoreFactory scoreFactory;

    @Override
    public void onActivate() {
        commandHandler = new CommandHandler(instance, this);
        scoreFactory = new ScoreImpl();

        commandHandler.register(new TesteCommand());
        new ScoreTask(this);
    }

    @Override
    public void onDeactivate() {
    }
}
