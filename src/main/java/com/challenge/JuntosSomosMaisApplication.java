package com.challenge;

import com.challenge.dataManager.CsvDataCatcher;
import com.challenge.dataManager.CsvDataConverter;
import com.challenge.dataManager.JsonDataConverter;
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

		String csvUrl = "https://storage.googleapis.com/juntossomosmais-code-challenge/input-backend.csv";
		String jsonUrl = "https://storage.googleapis.com/juntossomosmais-code-challenge/input-backend.json";
		String outputCsvFileName = "dados.csv";

//		convert data to a hashmap in memory
		HashMap<UUID, Client> clientsFromCsv = CsvDataConverter.toHashMap(csvUrl, outputCsvFileName);
		HashMap<UUID, Client> clientsFromJson = JsonDataConverter.toHashMap(jsonUrl);

//		make a single hashmap of clients with all clients data
		clientsFromJson.putAll(clientsFromCsv);
		Repository.clients = clientsFromJson;


	}

}
