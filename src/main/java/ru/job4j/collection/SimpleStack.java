package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleStack<T> {

    private ForwardLinked<T> linked = new ForwardLinked<>();

    public void push(T value) {
        linked.addFirst(value);
    }

    public T pop() {
        if (linked.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return linked.deleteFirst();
    }

    public boolean isEmpty() {
        return linked.isEmpty();
    }

}
