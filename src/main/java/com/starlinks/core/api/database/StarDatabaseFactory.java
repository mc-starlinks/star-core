package com.starlinks.core.api.database;

import com.starlinks.core.api.database.jdbc.StarDatabaseProvider;
import com.starlinks.core.api.database.mongo.StarCollectionProvider;

public interface StarDatabaseFactory {

    StarDatabaseProvider newMysqlProvider();

    StarCollectionProvider newMongoProvider();
}
