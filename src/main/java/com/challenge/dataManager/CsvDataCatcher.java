package com.challenge.dataManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;


public class CsvDataCatcher {

    public static void downloadCSV(String url, String outputFileName) throws IOException {
        URL csvUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) csvUrl.openConnection();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
             PrintWriter writer = new PrintWriter(outputFileName)) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Escreve cada linha no arquivo de saída
                writer.println(line);
            }
        } finally {
            connection.disconnect();
        }
    }
}
