package com.starlinks.core.sdk;

import com.starlinks.core.api.StarAPI;
import com.starlinks.core.api.command.StarCommandHandler;
import com.starlinks.core.api.entity.ScoreFactory;
import com.starlinks.core.api.entity.properties.PropFile;
import com.starlinks.core.sdk.commands.CommandHandler;
import com.starlinks.core.sdk.entity.ScoreImpl;
import com.starlinks.core.sdk.entity.properties.PropFileImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;

@Getter
@RequiredArgsConstructor
public final class StarImpl implements StarAPI {

    public static final Class<Player> PLAYER_CLASS = Player.class;

    private final StarLinks instance;

    public PropFile messageProperties;
    private StarCommandHandler commandHandler;
    private ScoreFactory scoreFactory;

    @Override
    public void onActivate() {
        messageProperties = new PropFileImpl(
                "message.properties"
        ).loadInto();

        commandHandler = new CommandHandler(instance, messageProperties);
        scoreFactory = new ScoreImpl();
    }

    @Override
    public void onDeactivate() {
    }
}
