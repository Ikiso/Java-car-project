//package com.example.demo.service;
//
//import com.example.demo.model.Car;
//import com.example.demo.repository.CarRepository;
//import com.example.demo.service.impl.CarServiceImpl;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertAll;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class CarServiceTest {
//
//    @Mock
//    private CarRepository carRepository;
//
//    @InjectMocks
//    private CarServiceImpl carService;
//
//    @Test
//    public void CarService_CreateCar_ReturnSavedCar() {
//        Car car = Car.builder().brand("dgfd").model("sdfd").fuel("Gas").quantity(5).build();
//
//        when(carRepository.save(Mockito.any(Car.class))).thenReturn(car);
//
//        Car carReturn = carService.createCar(car);
//
//        Assertions.assertThat(carReturn).isNotNull();
//
//    }
//
//    @Test
//    public void  CarService_FindById_ReturnSavedCar() {
//        long carId = 1;
//        Car car = Car.builder().id(carId).brand("dgfd").model("sdfd").fuel("Gas").quantity(5).build();
//
//        when(carRepository.findById(carId)).thenReturn(Optional.ofNullable(car));
//
//        Car carReturn = carService.getCarById(carId);
//
//        Assertions.assertThat(carReturn).isNotNull();
//    }
//
//    @Test
//    public void CarService_DeleteCarById_ReturnVoid() {
//        long carId = 1;
//        Car.builder().id(carId).brand("dgfd").model("sdfd").fuel("Gas").quantity(5).build();
//
//        assertAll(() ->  carService.deleteCarById(carId));
//    }
//
//}
