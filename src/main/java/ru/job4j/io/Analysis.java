package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileWriter(target))) {

            boolean serverDown = false;
            String start = null;

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String status = parts[0];
                String time = parts[1];

                if ((status.equals("400") || status.equals("500")) && !serverDown) {
                    serverDown = true;
                    start = time;
                } else if (!(status.equals("400") || status.equals("500")) && serverDown) {
                    serverDown = false;
                    out.println(start + ";" + time);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}