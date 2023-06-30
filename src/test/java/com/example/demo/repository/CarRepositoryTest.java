package com.example.demo.repository;

import com.example.demo.TestDemoApplication;
import com.example.demo.model.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

class CarRepositoryTest extends TestDemoApplication {

    private final CarRepository carRepository;

    @Autowired
    CarRepositoryTest(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Test
    void ManagerRepository_FindById_ReturnSavedManager() {
        Car car = Car.builder().model("DFF").brand("SSDE").fuel("Gas").quantity(15).build();

        carRepository.save(car);

        Car managerReturn = carRepository.findById(car.getId()).get();

        Assertions.assertThat(managerReturn).isNotNull();
    }

    @Test
    void ManagerRepository_DeleteById_ReturnSavedManager() {
        Car car = Car.builder().model("DFF").brand("SSDE").fuel("Gas").quantity(15).build();

        carRepository.save(car);

        carRepository.deleteById(car.getId());
        Optional<Car> managerReturn = carRepository.findById(car.getId());

        Assertions.assertThat(managerReturn).isEmpty();
    }
}
