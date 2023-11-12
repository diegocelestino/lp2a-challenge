package com.challenge.controllers;

import com.challenge.dtos.ClientDto;
import com.challenge.dtos.Page;
import com.challenge.dtos.Pageable;
import com.challenge.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/client")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class ClientController {
    private final ClientService clientService;


    @GetMapping("/all")
    public ResponseEntity<List<ClientDto>> getAllClients(){
        List<ClientDto> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @GetMapping()
    public ResponseEntity<Page>getClientPage(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer size,
            @RequestParam(defaultValue = "ALL") String type,
            @RequestParam(defaultValue = "ALL") String region) {
        Page clientPage = clientService.getPage(new Pageable(page, size), type, region);
        return ResponseEntity.ok(clientPage);
    }

    @GetMapping("{id}")
    public ResponseEntity<ClientDto>getClientDetail(@PathVariable UUID id) {
        ClientDto clientDto = clientService.getClient(id);
        return ResponseEntity.ok(clientDto);
    }

    @GetMapping("/byName/{name}")
    public ResponseEntity<List<ClientDto>>getClientsByName(@PathVariable String name) {
        System.out.println(name);
        List<ClientDto> clientsDto = clientService.getClientsByName(name);
        return ResponseEntity.ok(clientsDto);
    }

}
