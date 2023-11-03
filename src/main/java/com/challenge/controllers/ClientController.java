package com.challenge.controllers;

import com.challenge.Repository;
import com.challenge.dtos.ClientDto;
import com.challenge.dtos.Page;
import com.challenge.dtos.Pageable;
import com.challenge.models.Client;
import com.challenge.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/client")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class ClientController {
    private final ClientService clientService;

//    @GetMapping()
//    public ResponseEntity<List<ClientDto>>getAllClients() {
//        List<ClientDto> clients = clientService.getAllClients();
//        return ResponseEntity.ok(clients);
//    }

    @GetMapping()
    public ResponseEntity<Page>getClientPage(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer size) {
        Page clientPage = clientService.getPage(new Pageable(page, size));
        return ResponseEntity.ok(clientPage);
    }


}
