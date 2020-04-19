package com.starlinks.core.api.database;

public interface StarDatabaseConnection {

    StarDatabaseProvider loginWithCredentials(StarDatabaseCredentials credentials);

    boolean openAllConnections();
    void closeAllConnections();

}
