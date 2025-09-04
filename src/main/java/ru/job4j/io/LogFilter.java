package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    private final String file;

    public LogFilter(String file) {
        this.file = file;
    }

    public List<String> filter() {
        try (BufferedReader input = new BufferedReader(new FileReader(file))) {
            return input.lines()
                    .filter(LogFilter::isSecondLast404)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return List.of();
        }
    }

    private static boolean isSecondLast404(String line) {
        String[] parts = line.split("\\s+");
        if (parts.length < 2) {
            return false;
        }
        return "404".equals(parts[parts.length - 2]);
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter("data/log.txt");
        List<String> filtered = logFilter.filter();
        filtered.forEach(System.out::println);
    }
}

