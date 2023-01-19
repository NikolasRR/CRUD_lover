package com.cars_api.api.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CarDTO(
  @NotBlank String modelo, 
  @NotBlank String fabricante, 
  @NotBlank @Pattern(regexp = "^(0[1-9]|1[012])/(0[1-9]|[12][0-9]|[3][01])/\\d{4}$") String dataFabricacao, 
  @NotNull Integer valor, 
  @NotNull Integer anoModelo
  ) {
}
