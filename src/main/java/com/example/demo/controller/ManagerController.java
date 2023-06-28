package com.example.demo.controller;

import com.example.demo.dto.ManagerDto;
import com.example.demo.dto.UpdateManagerDto;
import com.example.demo.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/managers")
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ManagerDto> getAllManager() {
        return managerService.getAllManager();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ManagerDto createManager(@RequestBody ManagerDto managerDto) {
        return managerService.createManager(managerDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ManagerDto getManagerById(@PathVariable Long id) {
        return managerService.getManagerById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  deleteManagerById(@PathVariable Long id) {
        managerService.deleteManagerById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdateManagerDto updateManager(@PathVariable Long id,
                                                          @RequestBody UpdateManagerDto updateManagerDto) {
        UpdateManagerDto resultUpdate = managerService.fullUpdateManager(id, updateManagerDto);
        return resultUpdate;
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdateManagerDto updateManagerPartial(@PathVariable Long id,
                                                                 @RequestBody UpdateManagerDto updateManagerDto) {
        UpdateManagerDto resultUpdate = managerService.partialUpdateManager(id, updateManagerDto);
        return resultUpdate;
    }
}
