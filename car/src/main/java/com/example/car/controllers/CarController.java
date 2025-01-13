package com.example.car.controllers;

import com.example.car.entities.Car;
import com.example.car.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/car")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/client/{id}")
    public List<Car> getCarsByClientId( @PathVariable Long  id) {
        return carService.getCarsByClientId(id);
    }

}