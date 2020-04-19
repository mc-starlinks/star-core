package com.starlinks.core.sdk.database.mysql;

import com.starlinks.core.api.database.StarDatabaseCredentials;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;
import lombok.SneakyThrows;

@Getter
public abstract class MysqlConnectionPool {

    @SneakyThrows
    public HikariDataSource getDataSource(final StarDatabaseCredentials credentials){
        final HikariDataSource dataSource = new HikariDataSource();

        final String uriHost = "jdbc:mysql://" +
                credentials.getHost() + "/" + credentials.getDatabase();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl(uriHost);
        dataSource.setUsername(credentials.getUser());
        dataSource.setPassword(credentials.getPassword());

        dataSource.setMinimumIdle(100);
        dataSource.setMaximumPoolSize(1000);

        dataSource.setAutoCommit(false);
        dataSource.setLoginTimeout(3);

        return dataSource;
    }
}
