package com.example.demo.controller;

import com.example.demo.dto.CarDto;
import com.example.demo.dto.UpdateCarDto;
import com.example.demo.service.CarSearch;
import com.example.demo.service.CarService;
import com.example.demo.validator.CarValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/cars")
public class CarController {

    private final CarValidator carValidator;
    private final CarService carService;
    private final CarSearch carSearch;


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<CarDto> getAll() {
        return carService.getAllCars();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarDto create(@Valid @RequestBody CarDto carDto, Errors errors) {
        carValidator.validate(carDto, errors);
        CarDto createdCarDto = carService.createCar(carDto);
        return createdCarDto;
    }

    @GetMapping("{id}")
    public  CarDto getCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        carService.deleteCar(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdateCarDto update(@PathVariable Long id,
                               @Valid @RequestBody UpdateCarDto updateCarDto) {
        UpdateCarDto resultUpdate = carService.fullUpdateCar(id, updateCarDto);
        return resultUpdate;
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdateCarDto updatePartially(@PathVariable Long id,
                                           @RequestBody UpdateCarDto updateCarDto) {
        UpdateCarDto resultUpdate = carService.partialUpdateCar(id, updateCarDto);
        return resultUpdate;
    }

    @PostMapping("/search")
    public List<CarDto> searchCars(@RequestBody String query) {
        return carSearch.searchCars(query);
    }


}
