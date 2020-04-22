package com.starlinks.core.api.database.mongo;

public interface StarCollectionConnection {

    StarCollectionProvider loginWithCredentials(StarCollectionCredentials credentials);

    void closeConnection();
}
