package com.example.demo.service.impl;

import com.example.demo.config.MessageConfig;
import com.example.demo.dto.CarDto;
import com.example.demo.dto.UpdateCarDto;
import com.example.demo.mapper.CarMapper;
import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;
import com.example.demo.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional(readOnly = true)
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;
    private final MessageConfig messageConfig;

    @Override
    public List<CarDto> getAllCars() {
        List<Car> carList = carRepository.findAll();

        List<CarDto> carDtoList = carMapper.listCarToListCarDto(carList);

        log.info("Был получен список всех машин" );


        return carDtoList;
    }

    @Override
    public CarDto getCarById(Long id) {
        Car car = getCar(id);


        CarDto carDto = carMapper.carToCarDTO(car);

        log.info(messageConfig
                .getMessage("car.get.car.by.id"));

        LocaleContextHolder.setLocale(new Locale("eu"));
        log.info(messageConfig
                .getMessage("car.get.car.by.id"));

        return carDto;
    }

    @Override
    @Transactional
    public CarDto createCar(CarDto carDto) {
        Car car = carMapper.carDtoToCar(carDto);

        Car savedCar = carRepository.save(car);

        LocaleContextHolder.setLocale(new Locale("eu"));
        log.info(messageConfig
                .getMessage("car.create"));
        return carMapper.carToCarDTO(savedCar);
    }

    @Transactional
    public void deleteCar(Long id) {
        carRepository.deleteById(id);

        LocaleContextHolder.setLocale(new Locale("eu"));
        log.info(messageConfig
                .getMessage("car.delete"));
    }

    @Override
    @Transactional
    public UpdateCarDto fullUpdateCar(Long id, UpdateCarDto fullUpdateCarDto) {
        if(fullUpdateCarDto == null) {
            return null;
        }

        Car car = getCar(id);

        carMapper.fullUpdateCar(fullUpdateCarDto, car);

        carRepository.save(car);

        UpdateCarDto updateCarDto = carMapper.carToUpdateCarDto(car);
        log.info("Была обновлена машина полностью");

        return updateCarDto;
    }

    @Override
    @Transactional
    public UpdateCarDto partialUpdateCar(Long id, UpdateCarDto partialUpdateCarDto) {
        if(partialUpdateCarDto == null) {
            return null;
        }

        Car car = getCar(id);

        carMapper.partialUpdateCar(partialUpdateCarDto, car);

        carRepository.save(car);

        UpdateCarDto updateCarDto = carMapper.carToUpdateCarDto(car);
        log.info("машина была обновлена частично");



        return updateCarDto;
    }

    private Car getCar(Long id) {
        LocaleContextHolder.setLocale(new Locale("ru"));
        log.info(messageConfig
                .getMessage("car.search"));
        return carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не была найдена машина по id " + id));
    }
}
