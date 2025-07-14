package ru.job4j.collection;

public interface SimpleList<T> extends Iterable<T> {
    default void add(T value) {

    }

    default T set(int index, T newValue) {
        return null;
    }

    T remove(int index);

    default T get(int index) {
        return null;
    }

    default int size() {
        return 0;
    }
}