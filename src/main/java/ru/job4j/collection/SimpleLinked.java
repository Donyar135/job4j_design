package ru.job4j.collection;

public interface SimpleLinked<E> extends Iterable<E> {
    void add(E value);

    default E get(int index) {
        return null;
    }
}