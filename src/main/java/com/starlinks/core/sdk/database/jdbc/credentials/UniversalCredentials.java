package com.starlinks.core.sdk.database.jdbc.credentials;

import com.starlinks.core.api.database.jdbc.StarDatabaseCredentials;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public final class UniversalCredentials implements StarDatabaseCredentials {
    private final String host, database, user, password;
}