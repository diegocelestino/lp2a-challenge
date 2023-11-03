package com.challenge.services;

import com.challenge.ClientMapper;
import com.challenge.Repository;
import com.challenge.dtos.ClientDto;
import com.challenge.models.Client;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientMapper clientMapper;

    public List<ClientDto> getAllClients() {
        List<ClientDto> clients = new ArrayList<>();
        Repository.clients.forEach((key, value) -> clients.add(clientMapper.to(value)));
        return clients;
    }
}
