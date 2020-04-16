package com.starlinks.core.sdk;

import com.starlinks.core.api.StarAPI;
import com.starlinks.core.api.entity.ScoreFactory;
import com.starlinks.core.sdk.commands.CommandHandler;
import com.starlinks.core.sdk.entity.ScoreImpl;
import com.starlinks.core.sdk.entity.properties.PropFileImpl;
import com.starlinks.core.teste.ScoreTask;
import com.starlinks.core.teste.TesteCommand;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Getter
@RequiredArgsConstructor
public final class StarImpl implements StarAPI {

    public static final Class<Player> PLAYER_CLASS = Player.class;
    private static final ScheduledExecutorService SCHEDULED_EXECUTOR_SERVICE = Executors
            .newScheduledThreadPool(2);

    private final StarLinks instance;

    public PropFileImpl messageProperties;
    private CommandHandler commandHandler;
    private ScoreFactory scoreFactory;

    @Override
    public void onActivate() {
        messageProperties = new PropFileImpl("message.properties")
                .loadInto();

        commandHandler = new CommandHandler(instance, messageProperties);
        scoreFactory = new ScoreImpl();

        /*
         * Only for testes
         */
        commandHandler.register(new TesteCommand());
        new ScoreTask(this);
    }

    @Override
    public void onDeactivate() {
    }
}
