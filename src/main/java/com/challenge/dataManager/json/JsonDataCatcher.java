package com.challenge.dataManager.json;

import com.challenge.models.json.JsonClient;
import com.challenge.models.json.Results;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class JsonDataCatcher {

    public static List<JsonClient> getClients(String url){
        try {
            URL apiUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) apiUrl.openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() == 200) {
                ObjectMapper objectMapper = new ObjectMapper();

                Results results = objectMapper.readValue(conn.getInputStream(), Results.class);
                return results.getResults();

            } else {
                System.out.println("Falha na requisição HTTP. Código de resposta: " + conn.getResponseCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
