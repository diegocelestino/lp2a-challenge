package com.challenge.dataManager;

import com.challenge.models.Client;
import com.challenge.models.Name;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

public class CsvDataConverter {

    public static void readAndPrintFileLines(String filePath) throws IOException {
        File file = new File(filePath);
        HashMap<UUID, Client> clients;

        if (!file.exists()) {
            System.out.println("O arquivo não existe.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] array = (line.replace('"', ';')).split(";,;");
                Name name = new Name(array[1], array[2], array[3]);

                System.out.println(name.getTitle() + " " + name.getFirst() + " " + name.getLast());
            }
        }
    }
}
