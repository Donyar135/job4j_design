package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {

    private int[] data;
    private int index;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
        moveToNextEven();
    }

    private void moveToNextEven() {
        while (index < data.length && data[index] % 2 != 0) {
            index++;
        }
    }

    @Override
    public boolean hasNext() {
        return index < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int result = data[index++];
        moveToNextEven(); // Подготовить индекс к следующему вызову
        return result;
    }

}