package com.challenge.dataManager;

import com.challenge.models.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

public class CsvDataConverter {

    public static HashMap<UUID, Client> getClientsFromCsv(String filePath) throws IOException {
        File file = new File(filePath);
        HashMap<UUID, Client> clients = new HashMap<>();

        if (!file.exists()) {
            System.out.println("O arquivo não existe.");
            return null;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (isNotTheFirstLine(line)){
                    String[] array = slices(line);
                    clients.put(UUID.randomUUID(), CsvClientBuilder.build(array));
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
