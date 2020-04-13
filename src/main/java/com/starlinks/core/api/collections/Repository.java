package com.starlinks.core.api.collections;

public interface Repository<K, T> {

    T find(K key);
    void set(T instance);
    void update();

}
