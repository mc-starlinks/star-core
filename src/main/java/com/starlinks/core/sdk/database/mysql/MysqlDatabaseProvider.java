package com.starlinks.core.sdk.database.mysql;

import com.starlinks.core.api.commons.StarFunction;
import com.starlinks.core.api.commons.StarRunnable;
import com.starlinks.core.api.database.StarDatabaseCredentials;
import com.starlinks.core.api.database.StarDatabaseProvider;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Getter
public final class MysqlDatabaseProvider extends MysqlConnectionPool implements StarDatabaseProvider {

    private HikariDataSource source;

    @Override
    public StarDatabaseProvider loginWithCredentials(StarDatabaseCredentials credentials) {
        source = getDataSource(credentials);
        return this;
    }

    @Override
    @SneakyThrows
    public boolean openAllConnections() {
        Connection connection = source.getConnection();
        final boolean isOpenedConnection = connection != null && !connection.isClosed();

        closeEntity(connection);
        return isOpenedConnection;
    }

    @Override
    public void closeAllConnections() {
        source.close();
    }

    @Override
    @SneakyThrows
    public <K> Optional<K> query(final String query, StarFunction<ResultSet, K> function, Object... objects) {
        final Connection connection = source.getConnection();
        final PreparedStatement statement = connection.prepareStatement(query);
        sync(statement, objects);

        final ResultSet set = statement.executeQuery();
        K result = set != null && set.next() ? function.apply(set) : null;

        closeEntity(set, statement, connection);
        return Optional.ofNullable(result);
    }

    @Override
    public void update(String query, Object... objects) {
        final StarRunnable runnable = () -> {
            final Connection connection = source.getConnection();
            final PreparedStatement statement = connection.prepareStatement(query);
            sync(statement, objects);

            statement.executeUpdate();
            closeEntity(statement, connection);
        };

        CompletableFuture.runAsync(runnable);
    }

    @Override
    @SneakyThrows
    public void closeEntity(AutoCloseable... closeable) {
        for (AutoCloseable autoCloseable : closeable) {
            autoCloseable.close();
        }
    }

    @SneakyThrows
    private void sync(PreparedStatement statement, Object... objects){
        int index = 1;
        for (Object object : objects) {
            statement.setObject(index++, object);
        }
    }
}
