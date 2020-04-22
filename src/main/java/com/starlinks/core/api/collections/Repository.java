package com.starlinks.core.api.collections;

import com.starlinks.core.api.database.jdbc.StarDatabaseProvider;

import java.util.Collection;
import java.util.function.Supplier;

public interface Repository<K, T> {

    StarDatabaseProvider getProvider();

    void createProcedures(StarDatabaseProvider provider);

    Collection<T> findAll();

    T find(K key);
    void insert(T instance);
    void update(T instance);

    void insertOrUpdate(T instance);
    void findOrInsert(K key, Supplier<T> supplier);

    void findAndDelete(K key);
}