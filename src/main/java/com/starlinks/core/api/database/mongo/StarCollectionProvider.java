package com.starlinks.core.api.database.mongo;

import com.mongodb.client.MongoDatabase;

public interface StarCollectionProvider extends StarCollectionConnection {

    MongoDatabase getDatabase(String databaseName);
}
