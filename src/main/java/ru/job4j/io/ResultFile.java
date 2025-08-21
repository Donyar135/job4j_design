package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream output = new FileOutputStream("data/dataresult.txt")) {
            output.write("9 * 1 = 9".getBytes());
            output.write(System.lineSeparator().getBytes());
            output.write("9 * 2 = 18".getBytes());
            output.write(System.lineSeparator().getBytes());
            output.write("9 * 3 = 27".getBytes());
            output.write(System.lineSeparator().getBytes());
            output.write("9 * 4 = 36".getBytes());
            output.write(System.lineSeparator().getBytes());
            output.write("9 * 5 = 45".getBytes());
            output.write(System.lineSeparator().getBytes());
            output.write("9 * 6 = 54".getBytes());
            output.write(System.lineSeparator().getBytes());
            output.write("9 * 7 = 63".getBytes());
            output.write(System.lineSeparator().getBytes());
            output.write("9 * 8 = 72".getBytes());
            output.write(System.lineSeparator().getBytes());
            output.write("9 * 9 = 81".getBytes());
            output.write(System.lineSeparator().getBytes());
            output.write("9 * 10 = 90".getBytes());
            output.write(System.lineSeparator().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}