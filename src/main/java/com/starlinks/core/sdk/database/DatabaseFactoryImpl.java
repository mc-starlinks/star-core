package com.starlinks.core.sdk.database;

import com.starlinks.core.api.database.StarDatabaseFactory;
import com.starlinks.core.api.database.StarDatabaseProvider;
import com.starlinks.core.sdk.database.mysql.MysqlDatabaseProvider;

public final class DatabaseFactoryImpl implements StarDatabaseFactory {

    @Override
    public StarDatabaseProvider newMysqlProvider() {
        return new MysqlDatabaseProvider();
    }
}
