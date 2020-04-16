package com.starlinks.core.api.entity.properties;

import java.util.Properties;

public interface PropFile {
    Properties getProperties();
    PropFile loadInto();
    String get(String key);
}
