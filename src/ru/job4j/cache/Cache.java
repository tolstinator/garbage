package ru.job4j.cache;

public interface Cache<K, V> {
    V read(K key);
}
