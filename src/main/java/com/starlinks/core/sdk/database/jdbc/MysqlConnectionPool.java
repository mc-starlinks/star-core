package com.starlinks.core.sdk.database.jdbc;

import com.starlinks.core.api.database.jdbc.StarDatabaseCredentials;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;
import lombok.SneakyThrows;

@Getter
public abstract class MysqlConnectionPool {

    @SneakyThrows
    public HikariDataSource getDataSource(final StarDatabaseCredentials credentials){
        final HikariDataSource dataSource = new HikariDataSource();

        final String uriHost = "jdbc:jdbc://" +
                credentials.getHost() + "/" + credentials.getDatabase();

        dataSource.setDriverClassName("com.jdbc.jdbc.Driver");
        dataSource.setJdbcUrl(uriHost);
        dataSource.setUsername(credentials.getUser());
        dataSource.setPassword(credentials.getPassword());

        dataSource.setMinimumIdle(3);
        dataSource.setMaximumPoolSize(20);

        dataSource.setAutoCommit(false);
        dataSource.setLoginTimeout(3);

        return dataSource;
    }
}
