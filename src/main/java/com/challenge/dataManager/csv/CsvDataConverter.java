package com.challenge.dataManager.csv;

import com.challenge.Repository;
import com.challenge.models.*;

import java.io.*;
import java.util.HashMap;


public class CsvDataConverter {

    public static HashMap<Integer, Client> toHashMap(String url, String filePath) {

        tryDownload(url, filePath);

        File file = new File(filePath);

        return readFileAndWriteClientsToRepository(file);
    }

    private static Boolean isNotTheFirstLine(String line){
        return !line.contains("gender");
    }

    private static String[] slices(String line){
        return (line.replace('"', ';')).split(";,;");
    }

    private static HashMap<Integer, Client> readFileAndWriteClientsToRepository(File file){
        HashMap<Integer, Client> clients = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
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

    private static void tryDownload(String url, String filePath){
        try {
            CsvDataCatcher.downloadCSV(url, filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
