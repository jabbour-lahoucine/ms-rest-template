package com.example.client.services;

import com.example.client.entities.Car;
import com.example.client.entities.Client;
import com.example.client.modeles.ClientResponse;
import com.example.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RestTemplate restTemplate;

    public ClientResponse getClientById(Long id) throws Exception {
        Client client = clientRepository.findById(id).orElseThrow(() -> new Exception("Invalid Client ID"));
        Car[] carArray = restTemplate.getForObject("http://localhost:8888/SERVICE-CAR/api/car/client/" + id, Car[].class);
        List<Car> cars = (carArray != null) ? Arrays.asList(carArray) : Collections.emptyList();
        client.setCars(cars);
        return new ClientResponse(client);
    }
}
