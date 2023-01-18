package com.cars_api.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cars_api.api.models.Car;

public interface CarRepo extends JpaRepository<Car, Long> {  
}
