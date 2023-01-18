package com.cars_api.api.models;

import com.cars_api.api.DTOs.CarDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "cars")
public class Car {

  public Car(CarDTO data) {
    this.modelo = data.modelo();
    this.fabricante = data.fabricante();
    this.dataFabricacao = data.dataFabricacao();
    this.valor = data.valor();
    this.anoModelo = data.anoModelo();
  } 

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long id;

  @Column(length = 40, nullable = false)
  public String modelo;

  @Column(length = 30, nullable = false)
  public String fabricante;

  @Column(length = 10, nullable = false)
  public String dataFabricacao;

  @Column(nullable = false)
  public Integer valor;

  @Column(length = 4, nullable = false)
  public Integer anoModelo; 
}
