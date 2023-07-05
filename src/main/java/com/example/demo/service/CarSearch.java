package com.example.demo.service;

import com.example.demo.dto.CarDto;

import java.util.List;

public interface CarSearch {
    List<CarDto> searchCars(String text);

}
