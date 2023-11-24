package com.challenge;

import com.challenge.dataManager.csv.CsvDataConverter;
import com.challenge.dataManager.json.JsonDataConverter;
import com.challenge.models.Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.HashMap;

@SpringBootApplication
public class JuntosSomosMaisApplication {


	public static void main(String[] args) throws IOException {
		SpringApplication.run(JuntosSomosMaisApplication.class, args);

		String csvUrl = "https://storage.googleapis.com/juntossomosmais-code-challenge/input-backend.csv";
		String jsonUrl = "https://storage.googleapis.com/juntossomosmais-code-challenge/input-backend.json";

//		convert data to a hashmap in memory
		HashMap<Integer, Client> clientsFromCsv = CsvDataConverter.toHashMap(csvUrl);
		HashMap<Integer, Client> clientsFromJson = JsonDataConverter.toHashMap(jsonUrl);

//		make a single hashmap of clients with all clients data
		clientsFromJson.putAll(clientsFromCsv);
		Repository.clients = clientsFromJson;

		Repository.dropDuplicates();



	}

}
