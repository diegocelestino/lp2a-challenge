package com.challenge.dataManager.csv;

import com.challenge.Repository;
import com.challenge.models.Client;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;


public class CsvDataConverter {

    public static HashMap<Integer, Client> toHashMap(String url) throws IOException {
        URL csvUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) csvUrl.openConnection();
        return saveClientsToRepository(connection);
    }

    private static Boolean isNotTheFirstLine(String line){
        return !line.contains("gender");
    }

    private static String[] slices(String line){
        return (line.replace('"', ';')).split(";,;");
    }

    private static HashMap<Integer, Client> saveClientsToRepository(HttpURLConnection connection){
        HashMap<Integer, Client> clients = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (isNotTheFirstLine(line)){
                    String[] array = slices(line);
                    clients.put(Repository.getIndex(), CsvClientBuilder.build(array));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return clients;
    }
}
