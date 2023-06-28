//package com.example.demo.repository;
//
//import com.example.demo.model.Car;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import java.util.Optional;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
//public class CarRepositoryTest {
//
//    private final CarRepository carRepository;
//
//    @Autowired
//    public CarRepositoryTest(CarRepository carRepository) {
//        this.carRepository = carRepository;
//    }
//
//    @Test
//    public void ManagerRepository_FindById_ReturnSavedManager() {
//        Car car = Car.builder().model("DFF").brand("SSDE").fuel("Gas").quantity(15).build();
//
//        carRepository.save(car);
//
//        Car managerReturn = carRepository.findById(car.getId()).get();
//
//        Assertions.assertThat(managerReturn).isNotNull();
//    }
//
//    @Test
//    public void ManagerRepository_DeleteById_ReturnSavedManager() {
//        Car car = Car.builder().model("DFF").brand("SSDE").fuel("Gas").quantity(15).build();
//
//        carRepository.save(car);
//
//        carRepository.deleteById(car.getId());
//        Optional<Car> managerReturn = carRepository.findById(car.getId());
//
//        Assertions.assertThat(managerReturn).isEmpty();
//    }
//}
