package com.challenge.services;

import com.challenge.ClientMapper;
import com.challenge.Repository;
import com.challenge.dtos.ClientDto;
import com.challenge.dtos.Page;
import com.challenge.dtos.Pageable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {
    public final ClientMapper clientMapper;

    public List<ClientDto> getAllClients() {
        List<ClientDto> clients = new ArrayList<>();
        Repository.clients.forEach((key, value) -> clients.add(clientMapper.to(value)));
        return clients;
    }

    public Page getPage(Pageable pageable){
        List<ClientDto> clients = new ArrayList<>();
        Repository.clients.forEach((key, value) -> clients.add(clientMapper.to(value)));
        return new Page(pageable, clients);
    }
}
