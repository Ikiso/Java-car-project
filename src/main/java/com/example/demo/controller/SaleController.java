package com.example.demo.controller;

import com.example.demo.dto.SaleDto;
import com.example.demo.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;

    @PostMapping("/create/{carId}/{managerId}/{quantity}")
    @ResponseStatus(HttpStatus.CREATED)
    public SaleDto createSale(@PathVariable("carId") Long carId,
                              @PathVariable("managerId") Long managerId,
                              @PathVariable("quantity") int quantity) {
        SaleDto saleDto = saleService.createSale(carId, managerId, quantity);
        return saleDto;
    }
}
