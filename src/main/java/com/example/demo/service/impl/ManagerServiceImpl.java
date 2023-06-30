package com.example.demo.service.impl;

import com.example.demo.dto.ManagerDto;
import com.example.demo.dto.UpdateManagerDto;
import com.example.demo.mapper.ManagerMapper;
import com.example.demo.model.Manager;
import com.example.demo.repository.ManagerRepository;
import com.example.demo.service.ManagerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;

    private final ManagerMapper managerMapper;


    @Override
    public List<ManagerDto> getAllManager() {
        List<Manager> managerList = managerRepository.findAll();

        List<ManagerDto> managerDtoList = managerMapper.listCarToListCarDto(managerList);
        log.info("Менеджеры были получены");

        return managerDtoList;
    }

    @Override
    public ManagerDto getManagerById(Long id) {
        Manager manager = getManager(id);

        ManagerDto managerDto = managerMapper.managerToManagerDto(manager);
        log.info("был получен менеджер по id {}", manager);

        return managerDto;
    }

    @Override
    @Transactional
    public ManagerDto createManager(ManagerDto managerDto) {

        Manager manager = managerMapper.managerDtoToManager(managerDto);

        Manager savedManager = managerRepository.save(manager);

        log.info("Менеджер был создан");

        return managerMapper.managerToManagerDto(savedManager);
    }

    @Override
    @Transactional
    public void deleteManagerById(Long id) {
        managerRepository.deleteById(id);
    }

    @Override
    @Transactional
    public UpdateManagerDto fullUpdateManager(Long id, UpdateManagerDto fullUpdateManagerDto) {
        if(fullUpdateManagerDto == null) {
            return null;
        }

        Manager manager = getManager(id);

        managerMapper.fullUpdateCar(fullUpdateManagerDto, manager);

        managerRepository.save(manager);

        UpdateManagerDto updateManagerDto = managerMapper.managerToUpdateManagerDto(manager);
        log.info("Менеджер был обновлён");

        return updateManagerDto;
    }

    @Override
    @Transactional
    public UpdateManagerDto partialUpdateManager(Long id, UpdateManagerDto partialUpdateManagerDto) {
        if(partialUpdateManagerDto == null) {
            return null;
        }

        Manager manager = getManager(id);

        managerMapper.partialUpdateCar(partialUpdateManagerDto, manager);

        managerRepository.save(manager);

        UpdateManagerDto updateManagerDto = managerMapper.managerToUpdateManagerDto(manager);
        log.info("Менеджер был обновлён");

        return updateManagerDto;
    }


    private Manager getManager(Long id) {
        return managerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не был найден манаджер по id " + id));
    }

}
