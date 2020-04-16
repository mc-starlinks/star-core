package com.starlinks.core.sdk.entity.properties;

import com.starlinks.core.api.entity.properties.PropFile;
import com.starlinks.core.sdk.StarGear;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.io.InputStream;
import java.util.Properties;

@Getter
@RequiredArgsConstructor
public final class PropFileImpl implements PropFile {

    private final String fileName;
    private final Properties properties = new Properties();

    @SneakyThrows
    public PropFileImpl loadInto(){
        InputStream input = PropFileImpl.class
                .getClassLoader()
                .getResourceAsStream(fileName);

        assert input != null : "The properties file shouldn't be null";

        properties.load(input);
        input.close(); //needs to close

        return this;
    }

    public String get(String key) {
        final String content = properties.getProperty(key);
        return StarGear.colourText(content);
    }
}
