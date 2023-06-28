//package com.example.demo.service;
//
//import com.example.demo.model.Car;
//import com.example.demo.model.Manager;
//import com.example.demo.model.Sale;
//import com.example.demo.repository.SaleRepository;
//import com.example.demo.service.impl.CarServiceImpl;
//import com.example.demo.service.impl.ManagerServiceImpl;
//import com.example.demo.service.impl.SaleServiceImpl;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class SaleServiceTest {
//
//    @Mock
//    private CarServiceImpl carService;
//    @Mock
//    private ManagerServiceImpl managerService;
//
//    @Mock
//    private SaleRepository saleRepository;
//
//    @InjectMocks
//    private SaleServiceImpl saleService;
//
//    private Car car;
//    private Manager manager;
//    private Sale sale;
//
//    @BeforeEach
//    public void init() {
//        car = Car.builder().id(1L).brand("dgfd").model("sdfd").fuel("Gas").quantity(5).build();
//        manager = Manager.builder().id(1L).firstname("DFF").lastname("SSDE").sale(2).experience(1).build();
//        sale = Sale.builder().car(car).manager(manager).quantity(5).build();
//    }
//
//    @Test
//    public void SaleService_CreateSale_ReturnSavedSale() {
//        when(carService.getCarById(car.getId())).thenReturn(car);
//        when(managerService.getManagerById(manager.getId())).thenReturn(manager);
//        when(saleRepository.save(Mockito.any(Sale.class))).thenReturn(sale);
//
//        Sale saleReturn = saleService.createSale(car.getId(), manager.getId(), sale.getQuantity());
//
//        Assertions.assertThat(saleReturn).isNotNull();
//
//    }
//
//
//}
