package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> input = new SimpleStack<>();
    private final SimpleStack<T> output = new SimpleStack<>();

    public void push(T value) {
        input.push(value);
    }

    public T poll() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        if (output.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return output.pop();
    }


    private boolean outputIsEmpty() {
        try {
            output.pop();
            throw new IllegalStateException("pop should not change state during empty check");
        } catch (NoSuchElementException e) {
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    private void transferInputToOutput() {
        while (true) {
            try {
                T value = input.pop();
                output.push(value);
            } catch (NoSuchElementException e) {
                break;
            }
        }
    }
}
