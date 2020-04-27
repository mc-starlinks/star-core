package com.starlinks.core.sdk.database.jdbc;

import com.starlinks.core.api.database.jdbc.StarDatabaseCredentials;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;
import lombok.SneakyThrows;

@Getter
public abstract class MysqlConnectionPool {

    @SneakyThrows
    public HikariDataSource getDataSource(final StarDatabaseCredentials credentials) {
        final HikariDataSource dataSource = new HikariDataSource();

        final String uriHost = "jdbc:mysql://" +
                credentials.getHost() + "/" + credentials.getDatabase();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl(uriHost);
        dataSource.setUsername(credentials.getUser());
        dataSource.setPassword(credentials.getPassword());

        dataSource.setMinimumIdle(3);
        dataSource.setMaximumPoolSize(20);

        dataSource.setAutoCommit(true);
        dataSource.setLoginTimeout(3);

        return dataSource;
    }
}
