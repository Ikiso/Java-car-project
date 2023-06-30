package com.example.demo.controller;

import com.example.demo.dto.ManagerDto;
import com.example.demo.dto.UpdateManagerDto;
import com.example.demo.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/managers")
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ManagerDto> getAll() {
        return managerService.getAllManager();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ManagerDto create(@RequestBody ManagerDto managerDto) {
        return managerService.createManager(managerDto);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ManagerDto getManagerById(@PathVariable Long id) {
        return managerService.getManagerById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  delete(@PathVariable Long id) {
        managerService.deleteManagerById(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdateManagerDto update(@PathVariable Long id,
                                                          @RequestBody UpdateManagerDto updateManagerDto) {
        UpdateManagerDto resultUpdate = managerService.fullUpdateManager(id, updateManagerDto);
        return resultUpdate;
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdateManagerDto updatePartial(@PathVariable Long id,
                                                                 @RequestBody UpdateManagerDto updateManagerDto) {
        UpdateManagerDto resultUpdate = managerService.partialUpdateManager(id, updateManagerDto);
        return resultUpdate;
    }
}
