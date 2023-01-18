package com.cars_api.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cars_api.api.DTOs.CarDTO;
import com.cars_api.api.models.Car;
import com.cars_api.api.repositories.CarRepo;

@RestController
@RequestMapping("/cars")
public class CarsController {
  
  @Autowired
  private CarRepo repo;

  @GetMapping
  public List<Car> getCars() {
    return repo.findAll();
  }

  @PostMapping
  public void PostCar(@RequestBody CarDTO car) {
    repo.save(new Car(car));
  }
}
