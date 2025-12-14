package ru.job4j.io;

import java.io.*;
import java.util.List;

public class Analysis {
    public static void unavailable(String source, String target, List<String> words) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileWriter(target))) {

            boolean serverDown = false;
            String start = null;

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String status = parts[0];
                String time = parts[1];

                if (("400".equals(status) || "500".equals(status)) && !serverDown) {
                    serverDown = true;
                    start = time;
                } else if (!("400".equals(status) || "500".equals(status)) && serverDown) {
                    serverDown = false;
                    out.println(start + ";" + time);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}