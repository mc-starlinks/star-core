package com.starlinks.core.sdk.database;

import com.starlinks.core.api.database.StarDatabaseFactory;
import com.starlinks.core.api.database.jdbc.StarDatabaseProvider;
import com.starlinks.core.api.database.mongo.StarCollectionProvider;
import com.starlinks.core.sdk.database.jdbc.MysqlDatabaseProvider;
import com.starlinks.core.sdk.database.mongo.MongoCollectionProvider;

public final class DatabaseFactoryImpl implements StarDatabaseFactory {

    @Override
    public StarDatabaseProvider newMysqlProvider() {
        return new MysqlDatabaseProvider();
    }

    @Override
    public StarCollectionProvider newMongoProvider() {
        return new MongoCollectionProvider();
    }
}
