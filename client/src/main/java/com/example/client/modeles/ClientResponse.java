package com.example.client.modeles;

import com.example.client.entities.Car;
import com.example.client.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponse {
    private Client client;
}