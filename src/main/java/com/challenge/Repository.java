package com.challenge;

import com.challenge.models.Client;

import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;


public class Repository {
    public static Integer index = 0;
    public static HashMap<Integer, Client> clients;

    public static Integer getIndex(){
        index++;
        return index;
    }

    public static void dropDuplicates(){
        ConcurrentHashMap<Integer, Client> clientsDropped = new ConcurrentHashMap<>(clients);
        clientsDropped.forEach((key, value) -> {
            clientsDropped.forEach((innerKey, innerValue) -> {
                if(clientsDropped.get(key).getEmail().equals(clientsDropped.get(innerKey).getEmail()) && !key.equals(innerKey)){
                    clientsDropped.remove(innerKey);
                }
            });
        });
        clients.clear();
        clients.putAll(clientsDropped);
    }
}
