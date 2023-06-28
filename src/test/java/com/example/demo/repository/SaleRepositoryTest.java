//package com.example.demo.repository;
//
//import com.example.demo.model.Car;
//import com.example.demo.model.Manager;
//import com.example.demo.model.Sale;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
//public class SaleRepositoryTest {
//
//    private final SaleRepository saleRepository;
//
//    private final ManagerRepository managerRepository;
//
//    private final CarRepository carRepository;
//
//
//    @Autowired
//    public SaleRepositoryTest(SaleRepository saleRepository, ManagerRepository managerRepository, CarRepository carRepository) {
//        this.saleRepository = saleRepository;
//        this.managerRepository = managerRepository;
//        this.carRepository = carRepository;
//    }
//
//    @Test
//    public void SaleRepository_CreateSale_ReturnSavedSale() {
//        Car car = Car.builder().model("DFF").brand("SSDE").fuel("Gas").quantity(15).build();
//        Manager manager = Manager.builder().firstname("DFF").lastname("SSDE").sale(2).experience(1).build();
//
//        managerRepository.save(manager);
//        carRepository.save(car);
//
//        Sale sale = Sale.builder().car(car).manager(manager).quantity(2).build();
//
//        saleRepository.save(sale);
//
//        Sale saleResult = saleRepository.findById(sale.getId()).get();
//
//        Assertions.assertThat(saleResult).isNotNull();
//    }
//}
