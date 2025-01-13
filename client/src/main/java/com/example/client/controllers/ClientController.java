package com.example.client.controllers;

import com.example.client.entities.Client;
import com.example.client.modeles.ClientResponse;
import com.example.client.repositories.ClientRepository;
import com.example.client.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientService clientService;


    @GetMapping
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Client> findById(@PathVariable Long id) throws Exception {
        return clientRepository.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Client client) {
        clientRepository.save(client);
    }

    @GetMapping("/rest-template/{id}")
    public ClientResponse getClientByIdWithCarsRestTemplate(@PathVariable Long id) throws Exception {
        return clientService.getClientById(id);
    }
}