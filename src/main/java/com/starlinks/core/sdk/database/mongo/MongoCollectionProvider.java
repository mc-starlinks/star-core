package com.starlinks.core.sdk.database.mongo;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.starlinks.core.api.database.mongo.StarCollectionCredentials;
import com.starlinks.core.api.database.mongo.StarCollectionProvider;
import com.starlinks.core.sdk.StarImpl;
import com.starlinks.core.sdk.database.mongo.codec.IStackCodec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public final class MongoCollectionProvider implements StarCollectionProvider {

    private static final CodecRegistry CODEC_REGISTRY = CodecRegistries.fromRegistries(
            MongoClientSettings.getDefaultCodecRegistry(),
            CodecRegistries.fromProviders(
                    PojoCodecProvider.builder()
                            .automatic(true)
                            .build()
            ),
            CodecRegistries.fromCodecs(new IStackCodec(StarImpl.STAR_GEAR))
    );

    private MongoClient client;

    @Override
    public StarCollectionProvider loginWithCredentials(StarCollectionCredentials credentials) {
        client = MongoClients.create(
                credentials.getConnectionURI()
        );
        return this;
    }

    @Override
    public MongoDatabase getDatabase(String databaseName) {
        return client.getDatabase(databaseName)
                .withCodecRegistry(CODEC_REGISTRY);
    }

    @Override
    public void closeConnection() {
        client.close();
    }
}
