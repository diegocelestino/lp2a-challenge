package com.challenge.dataManager.json;

import com.challenge.Repository;
import com.challenge.models.Client;
import com.challenge.models.json.JsonClient;

import java.util.HashMap;
import java.util.List;

public class JsonDataConverter {

    public static HashMap<Integer, Client> toHashMap(String url){
        List<JsonClient> jsonClients = JsonDataCatcher.getClients(url);
        HashMap<Integer, Client> clientHashMap = new HashMap<>();

        assert jsonClients != null;
        for (JsonClient client: jsonClients) {
            clientHashMap.put(Repository.getIndex(), JsonClientBuilder.build(client));
        }

        return clientHashMap;
    }

}
