package com.challenge;

import com.challenge.dataManager.CsvDataCatcher;
import com.challenge.dataManager.CsvDataConverter;
import com.challenge.models.Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

@SpringBootApplication
public class JuntosSomosMaisApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(JuntosSomosMaisApplication.class, args);
		HashMap<UUID, Client> clients;

		String url = "https://storage.googleapis.com/juntossomosmais-code-challenge/input-backend.csv";
		String outputFileName = "dados.csv";

		try {
			CsvDataCatcher.downloadCSV(url, outputFileName);
			System.out.println("CSV baixado com sucesso.");
		} catch (IOException e) {
			e.printStackTrace();
		}

		clients = CsvDataConverter.toHashMap(outputFileName);
		for (Client client: clients.values()) {
			System.out.println(client.getTelephoneNumbers());
		}

	}

}
