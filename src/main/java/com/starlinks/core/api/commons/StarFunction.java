package com.starlinks.core.api.commons;

import java.util.function.Function;

public interface StarFunction<T, R> extends Function<T, R> {

    @Override
    default R apply(T t) {
        try {
            return catchApply(t);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    R catchApply(T t) throws Exception;
}
