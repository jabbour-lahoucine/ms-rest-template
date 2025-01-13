package com.example.car;

import com.example.car.entities.Car;
import com.example.car.repositories.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableDiscoveryClient
public class CarApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarApplication.class, args);
    }

    @Bean
    CommandLineRunner testDataLoader(CarRepository voitureRepository) {
        return args -> {
            voitureRepository.save(new Car(null, "BMW", "D 12 1234", "X5", 2L));
            voitureRepository.save(new Car(null, "Audi", "E 23 5678", "A4", 3L));
            voitureRepository.save(new Car(null, "Mercedes", "F 34 9012", "C-Class", 2L));
            voitureRepository.save(new Car(null, "Volkswagen", "G 45 3456", "Golf", 3L));

            System.out.println("Test data for Voiture successfully loaded!");
        };
    }

}
