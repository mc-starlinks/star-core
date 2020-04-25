package com.starlinks.core.api.database.jdbc;

import com.starlinks.core.api.commons.StarFunction;

import java.sql.ResultSet;
import java.util.Optional;

public interface StarDatabaseProvider extends StarDatabaseConnection {

    <K> Optional<K> query(String query, StarFunction<ResultSet, K> function, Object... objects);

    void update(String query, Object... objects);

    void closeEntity(AutoCloseable... closeable);
}