package com.example.demo.controller;

import com.example.demo.dto.CarDto;
import com.example.demo.dto.UpdateCarDto;
import com.example.demo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/all")
    public List<CarDto> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public  CarDto createCar(@RequestBody CarDto carDto) {
        CarDto createdCarDto = carService.createCar(carDto);
        return createdCarDto;
    }

    @GetMapping("/{id}")
    public  CarDto getCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCarById(@PathVariable Long id) {
        carService.deleteCarById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdateCarDto updateCar(@PathVariable Long id,
                                  @RequestBody UpdateCarDto updateCarDto) {
        UpdateCarDto resultUpdate = carService.fullUpdateCar(id, updateCarDto);
        return resultUpdate;
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdateCarDto updateCarPartially(@PathVariable Long id,
                                           @RequestBody UpdateCarDto updateCarDto) {
        UpdateCarDto resultUpdate = carService.partialUpdateCar(id, updateCarDto);
        return resultUpdate;
    }
}
