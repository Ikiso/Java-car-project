package com.example.demo.service;

import com.example.demo.dto.CarDto;
import com.example.demo.dto.UpdateCarDto;

import java.util.List;

public interface CarService {
    List<CarDto> getAllCars();

    CarDto getCarById(Long id);

    CarDto createCar(CarDto carDTO);

    void deleteCarById(Long id);

    UpdateCarDto fullUpdateCar(Long id, UpdateCarDto fullUpdateCarDto);

    UpdateCarDto partialUpdateCar(Long id, UpdateCarDto partialUpdateCarDto);
}
