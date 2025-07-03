package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NonNullIterator implements Iterator<Integer> {

    private Integer[] data;
    private int index;

    public NonNullIterator(Integer[] data) {
        this.data = data;
        moveToNextEven();
    }

    private void moveToNextEven() {
        while (index < data.length && data[index] == null) {
            index++;
        }
    }

    @Override
    public boolean hasNext() {
        moveToNextEven();
        return index < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        moveToNextEven();
        return data[index++];
    }
}
