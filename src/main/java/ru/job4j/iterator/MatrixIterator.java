package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator<Integer> {
    private final int[][] data;
    private int row;
    private int column;

    public MatrixIterator(int[][] data) {
        this.data = data;
        moveToNextEven();
    }

    private void moveToNextEven() {
        while (row < data.length && column == data[row].length) {
            row++;
            column = 0;
        }
    }

    @Override
    public boolean hasNext() {
        return row < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int result = data[row][column++];
        moveToNextEven();
        return result;
    }
}