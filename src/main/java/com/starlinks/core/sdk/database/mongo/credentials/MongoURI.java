package com.starlinks.core.sdk.database.mongo.credentials;

import com.starlinks.core.api.database.mongo.StarCollectionCredentials;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public final class MongoURI implements StarCollectionCredentials {
    private final String connectionURI;
}
