//package com.example.demo.service;
//
//import com.example.demo.model.Manager;
//import com.example.demo.repository.ManagerRepository;
//import com.example.demo.service.impl.ManagerServiceImpl;
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
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class ManagerServiceTest {
//    @Mock
//    private ManagerRepository managerRepository;
//
//    @InjectMocks
//    private ManagerServiceImpl managerService;
//
//    @Test
//    public void CarService_CreateCar_ReturnSavedCar() {
//        Manager manager = Manager.builder().firstname("DFF").lastname("SSDE").sale(2).experience(1).build();
//
//        when(managerRepository.save(Mockito.any(Manager.class))).thenReturn(manager);
//
//        Manager managerReturn = managerService.createManager(manager);
//
//        Assertions.assertThat(managerReturn).isNotNull();
//
//    }
//
//    @Test
//    public void  CarService_FindById_ReturnSavedCar() {
//        long managerId = 1;
//        Manager manager = Manager.builder().
//                id(managerId).
//                firstname("DFF").
//                lastname("SSDE").
//                sale(2).
//                experience(1).build();
//
//        when(managerRepository.findById(managerId)).thenReturn(Optional.ofNullable(manager));
//
//        Manager managerReturn = managerService.getManagerById(managerId);
//
//        Assertions.assertThat(managerReturn).isNotNull();
//    }
//
//    @Test
//    public void CarService_DeleteCarById_ReturnVoid() {
//        long managerId = 1;
//        Manager.builder().
//                id(managerId).
//                firstname("DFF").
//                lastname("SSDE").
//                sale(2).
//                experience(1).build();
//
//        assertAll(() ->  managerService.deleteManagerById(managerId));
//    }
//}
