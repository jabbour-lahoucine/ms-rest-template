package com.example.client.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Float age;

    @Transient
    private List<Car> cars;


    public Client( Long id ,String nom, Float age) {
        this.id = id;
        this.nom = nom;
        this.age = age;
    }
}

