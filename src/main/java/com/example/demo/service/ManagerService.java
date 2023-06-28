package com.example.demo.service;

import com.example.demo.dto.ManagerDto;
import com.example.demo.dto.UpdateManagerDto;

import java.util.List;

public interface ManagerService {
    List<ManagerDto> getAllManager();

    ManagerDto getManagerById(Long id);

    ManagerDto createManager(ManagerDto manager);

    void deleteManagerById(Long id);

    UpdateManagerDto fullUpdateManager(Long id, UpdateManagerDto fullUpdateManagerDto);

    UpdateManagerDto partialUpdateManager(Long id, UpdateManagerDto partialUpdateManagerDto);
}
