package com.challenge;

import com.challenge.dataManager.CsvDataCatcher;
import com.challenge.dataManager.CsvDataConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class JuntosSomosMaisApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(JuntosSomosMaisApplication.class, args);

		String url = "https://storage.googleapis.com/juntossomosmais-code-challenge/input-backend.csv";
		String outputFileName = "dados.csv";

		try {
			CsvDataCatcher.downloadCSV(url, outputFileName);
			System.out.println("CSV baixado com sucesso.");
		} catch (IOException e) {
			e.printStackTrace();
		}

		CsvDataConverter.readAndPrintFileLines(outputFileName);

	}

}
