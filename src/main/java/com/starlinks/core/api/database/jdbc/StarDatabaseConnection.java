package com.starlinks.core.api.database.jdbc;

public interface StarDatabaseConnection {

    StarDatabaseProvider loginWithCredentials(StarDatabaseCredentials credentials);

    boolean openAllConnections();
    void closeAllConnections();

}
