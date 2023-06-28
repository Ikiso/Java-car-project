package com.example.demo.service.impl;

import com.example.demo.dto.CarDto;
import com.example.demo.dto.ManagerDto;
import com.example.demo.dto.SaleDto;
import com.example.demo.mapper.CarMapper;
import com.example.demo.mapper.ManagerMapper;
import com.example.demo.mapper.SaleMapper;
import com.example.demo.model.Car;
import com.example.demo.model.Manager;
import com.example.demo.model.Sale;
import com.example.demo.repository.SaleRepository;
import com.example.demo.service.CarService;
import com.example.demo.service.ManagerService;
import com.example.demo.service.SaleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClientException;

@Service
@RequiredArgsConstructor
@Slf4j
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;

    private final ManagerService managerService;

    private final CarService carService;

    private final CarMapper carMapper;

    private final ManagerMapper managerMapper;

    private final SaleMapper saleMapper;

    @Override
    @Transactional
    public SaleDto createSale(Long carId, Long managerId, int quantity) {
        CarDto carDto = carService.getCarById(carId);

        Car car = carMapper.carDtoToCar(carDto);

        ManagerDto managerDto = managerService.getManagerById(managerId);

        Manager manager = managerMapper.managerDtoToManager(managerDto);

        Sale sale = new Sale();

        if(car.getQuantity() - quantity < 0) {
            log.error("проверка условия на отрицательное значение");

            throw new RestClientException("Количество машин не может быть меньше 0");
        }

        if(quantity < car.getQuantity()) {
            car.setQuantity(car.getQuantity() - quantity);
            manager.setSale(manager.getSale() + quantity);

            CarDto updateCarDto = carMapper.carToCarDTO(car);
            ManagerDto updateManagerDto = managerMapper.managerToManagerDto(manager);

            carService.createCar(updateCarDto);
            managerService.createManager(updateManagerDto);
        }

        sale.setCar(car);
        sale.setManager(manager);
        sale.setQuantity(quantity);

        Sale saveSale = saleRepository.save(sale);

        SaleDto saleDto = saleMapper.saleToSaleDto(saveSale);
        log.info("Место: SaleServiceImpl; метод: createSale; Сущность: " + saleDto);

        return saleDto;
    }
}
