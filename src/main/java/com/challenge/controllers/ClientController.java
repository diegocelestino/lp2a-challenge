package com.challenge.controllers;

import com.challenge.Repository;
import com.challenge.models.Client;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/client")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class ClientController {

    @GetMapping()
    public ResponseEntity<HashMap<Integer, Client>> getAllClients() {
        HashMap<Integer, Client> clientHashMap = Repository.clients;
        return ResponseEntity.ok(clientHashMap);
    };
}
