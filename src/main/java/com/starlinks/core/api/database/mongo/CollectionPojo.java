package com.starlinks.core.api.database.mongo;

import org.bson.types.ObjectId;

public interface CollectionPojo {

    default ObjectId getId(){
        return ObjectId.get();
    }
}