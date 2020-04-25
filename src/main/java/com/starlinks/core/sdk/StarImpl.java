package com.starlinks.core.sdk;

import com.starlinks.core.api.StarAPI;
import com.starlinks.core.api.command.StarCommandFactory;
import com.starlinks.core.api.database.StarDatabaseFactory;
import com.starlinks.core.api.database.mongo.StarCollectionProvider;
import com.starlinks.core.api.entity.configuration.StarFile;
import com.starlinks.core.api.entity.score.ScoreFactory;
import com.starlinks.core.sdk.commands.CommandHandler;
import com.starlinks.core.sdk.database.DatabaseFactoryImpl;
import com.starlinks.core.sdk.database.mongo.credentials.MongoURI;
import com.starlinks.core.sdk.entity.configuration.StarYamlFile;
import com.starlinks.core.sdk.entity.score.ScoreImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;

@Getter
@RequiredArgsConstructor
public final class StarImpl implements StarAPI {

    public static final StarGear STAR_GEAR = new StarGear();
    public static final Class<Player> PLAYER_CLASS = Player.class;

    private final StarLinks instance;

    private StarCollectionProvider principalProvider;
    private StarDatabaseFactory databaseFactory;
    private StarFile messageFile;
    private StarFile configFile;
    private StarCommandFactory commandHandler;
    private ScoreFactory scoreFactory;

    @Override
    public void onActivate() {
        configFile = new StarYamlFile(
                instance, "config.yml"
        ).loadInto();

        messageFile = new StarYamlFile(
                instance, "message.yml"
        ).loadInto();

        databaseFactory = new DatabaseFactoryImpl();
        commandHandler = new CommandHandler(instance, messageFile);
        scoreFactory = new ScoreImpl();
        principalProvider = databaseFactory
                .newMongoProvider()
                .loginWithCredentials(new MongoURI(
                        configFile.getString("mongo_uri")
                ));
    }

    @Override
    public void onDeactivate() {
        principalProvider.closeConnection();
    }
}