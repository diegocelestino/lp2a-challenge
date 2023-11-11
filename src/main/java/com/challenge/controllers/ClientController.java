package com.challenge.controllers;

import com.challenge.dtos.ClientDto;
import com.challenge.dtos.Page;
import com.challenge.dtos.Pageable;
import com.challenge.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/client")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class ClientController {
    private final ClientService clientService;

    @GetMapping()
    public ResponseEntity<Page>getClientPage(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer size) {
        Page clientPage = clientService.getPage(new Pageable(page, size));
        return ResponseEntity.ok(clientPage);
    }

    @GetMapping("{id}")
    public ResponseEntity<ClientDto>getClientDetail(@PathVariable UUID id) {
        ClientDto clientDto = clientService.getClient(id);
        return ResponseEntity.ok(clientDto);
    }


}
