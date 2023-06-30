package com.example.demo.service.impl;

import com.example.demo.dto.CarDto;
import com.example.demo.mapper.CarMapper;
import com.example.demo.model.Car;
import com.example.demo.repository.CarSearchRepository;
import com.example.demo.service.CarSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RequiredArgsConstructor
public class CarSearchServiceImpl implements CarSearch {

    private final CarSearchRepository carSearchRepository;
    private final CarMapper carMapper;

    @Override
    public List<CarDto> searchByBrand(String text) {
        Page<Car> searchHits = carSearchRepository.searchByBrand(text, Pageable.ofSize(1));
        List<Car> cars = searchHits.stream()
                .toList();

        return carMapper.listCarToListCarDto(cars);
    }
}
