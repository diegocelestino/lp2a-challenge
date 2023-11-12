package com.challenge.services;

import com.challenge.mappers.ClientMapper;
import com.challenge.Repository;
import com.challenge.dtos.ClientDto;
import com.challenge.dtos.Page;
import com.challenge.dtos.Pageable;
import com.challenge.models.Client;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@Service
@AllArgsConstructor
public class ClientService {
    public final ClientMapper clientMapper;

    public List<ClientDto> getAllClients() {
        List<ClientDto> clients = new ArrayList<>();
        Repository.clients.forEach((key, value) -> clients.add(clientMapper.to(value)));
        return clients;
    }

    public Page getPage(Pageable pageable, String type, String region){
        List<ClientDto> clients = new ArrayList<>();
        if(type.equals("ALL") & region.equals("ALL")){
            Repository.clients.forEach((key, value) -> clients.add(clientMapper.to(value)));
        }
        else if (!type.equals("ALL") & region.equals("ALL")) {
            Repository.clients.forEach((key, value) -> {
                if (value.getType().toString().equals(type)){
                    clients.add(clientMapper.to(value));
                }
            });
        }
        else if (type.equals("ALL")) {
            Repository.clients.forEach((key, value) -> {
                if (value.getLocation().getRegion().equals(region)){
                    clients.add(clientMapper.to(value));
                }
            });
        } else {
            Repository.clients.forEach((key, value) -> {
                if (value.getType().toString().equals(type) & value.getLocation().getRegion().equals(region)){
                    clients.add(clientMapper.to(value));
                }
            });
        }
        return new Page(pageable, clients);
    }

    public ClientDto getClient(UUID id) {
        AtomicReference<Client> client = new AtomicReference<>();
        Repository.clients.forEach((key, value) -> {
            if (value.getId().equals(id)){
                client.set(value);
            }
        });
        return clientMapper.to(client.get());
    }

    public List<ClientDto> getClientsByName(String name) {
        List<ClientDto> clients = new ArrayList<>();
        Repository.clients.forEach((key, value) -> {
            if (value.getName().getFirst().equals(name)){
                clients.add(clientMapper.to(value));
            }
        });
        return clients;
    }
}
