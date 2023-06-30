package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateCarDto {

    @NotBlank(message = "{car.brand.notBlank}")
    private String brand;

    @NotBlank(message = "{car.model.notBlank}")
    private String model;

    @NotBlank(message = "{car.fuel.notBlank}")
    private String fuel;
}
