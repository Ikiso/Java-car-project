//package com.example.demo.repository;
//
//import com.example.demo.model.Manager;
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
//public class ManagerRepositoryTest {
//
//    private final ManagerRepository managerRepository;
//
//    @Autowired
//    public ManagerRepositoryTest(ManagerRepository managerRepository) {
//        this.managerRepository = managerRepository;
//    }
//
//    @Test
//    public void ManagerRepository_FindById_ReturnSavedManager() {
//        Manager manager = Manager.builder().firstname("Vasiliy").lastname("Glad").sale(2).experience(1).build();
//
//        managerRepository.save(manager);
//
//        Manager managerReturn = managerRepository.findById(manager.getId()).get();
//
//        Assertions.assertThat(managerReturn).isNotNull();
//    }
//
//    @Test
//    public void ManagerRepository_DeleteById_ReturnSavedManager() {
//        Manager manager = Manager.builder().firstname("DFF").lastname("SSDE").sale(2).experience(1).build();
//
//        managerRepository.save(manager);
//
//        managerRepository.deleteById(manager.getId());
//        Optional<Manager> managerReturn = managerRepository.findById(manager.getId());
//
//        Assertions.assertThat(managerReturn).isEmpty();
//    }
//}
