package com.starlinks.test.database.pojo;

import com.starlinks.core.api.database.mongo.CollectionPojo;
import lombok.Data;

import java.util.UUID;

@Data
public class TestPojo implements CollectionPojo {

    private UUID uuid;
    private Integer money;
}
