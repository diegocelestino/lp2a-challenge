package com.challenge.dataManager;

import com.challenge.Repository;
import com.challenge.models.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class CsvDataConverter {

    public static HashMap<Integer, Client> toHashMap(String url, String filePath) throws IOException {
        try {
            CsvDataCatcher.downloadCSV(url, filePath);
            System.out.println("CSV baixado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File(filePath);
        HashMap<Integer, Client> clients = new HashMap<>();

        if (!file.exists()) {
            System.out.println("O arquivo não existe.");
            return null;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (isNotTheFirstLine(line)){
                    String[] array = slices(line);
                    clients.put(Repository.getIndex(), CsvClientBuilder.build(array));
                }
            }
        }
        return clients;
    }

    private static Boolean isNotTheFirstLine(String line){
        return !line.contains("gender");
    }

    private static String[] slices(String line){
        return (line.replace('"', ';')).split(";,;");
    }
}
