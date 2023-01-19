package com.cars_api.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cars_api.api.DTOs.CarDTO;
import com.cars_api.api.models.Car;
import com.cars_api.api.repositories.CarRepo;

import jakarta.validation.Valid;

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
  public void postCar(@RequestBody @Valid CarDTO car) {
    repo.save(new Car(car));
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    repo.deleteById(id);
  }

  @PutMapping("/{id}")
  public void update(@PathVariable Long id, @RequestBody @Valid CarDTO req) {
    repo.findById(id).map(car -> {
      car.setModelo(req.modelo());
      car.setFabricante(req.fabricante());
      car.setDataFabricacao(req.dataFabricacao());
      car.setValor(req.valor());
      car.setAnoModelo(req.anoModelo());
      return repo.save(car);
    });
  }
}
