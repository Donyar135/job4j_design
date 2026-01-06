package ru.job4j.io;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        File file = new File("c:\\projects/file.txt");
        System.out.println(String.format("Имя файла: %s, Длина файла (в байтах): %d",
                file.getName(), file.length()));
    }
}
