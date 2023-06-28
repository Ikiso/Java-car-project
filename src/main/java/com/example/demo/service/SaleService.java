package com.example.demo.service;

import com.example.demo.dto.SaleDto;

public interface SaleService {

    SaleDto createSale(Long carId, Long managerId, int quantity);
}
