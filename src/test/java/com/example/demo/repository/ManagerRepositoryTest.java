package com.example.demo.repository;

import com.example.demo.TestDemoApplication;
import com.example.demo.model.Manager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


public class ManagerRepositoryTest extends TestDemoApplication {

    private final ManagerRepository managerRepository;

    @Autowired
    public ManagerRepositoryTest(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Test
    public void ManagerRepository_FindById_ReturnSavedManager() {
        Manager manager = Manager.builder().firstname("Vasiliy").lastname("Glad").sale(2).experience(1).build();

        managerRepository.save(manager);

        Manager managerReturn = managerRepository.findById(manager.getId()).get();

        Assertions.assertThat(managerReturn).isNotNull();
    }

    @Test
    public void ManagerRepository_DeleteById_ReturnSavedManager() {
        Manager manager = Manager.builder().firstname("DFF").lastname("SSDE").sale(2).experience(1).build();

        managerRepository.save(manager);

        managerRepository.deleteById(manager.getId());
        Optional<Manager> managerReturn = managerRepository.findById(manager.getId());

        Assertions.assertThat(managerReturn).isEmpty();
    }
}
