package com.challenge.services;

import com.challenge.Repository;
import com.challenge.models.Client;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        Repository.clients.forEach((key, value) -> clients.add(value));
        return clients;
    }
}
