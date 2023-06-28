package com.example.demo.mapper;

import com.example.demo.dto.SaleDto;
import com.example.demo.model.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface SaleMapper {

    @Mapping(target = "car.count", source = "sale.car.quantity")
    SaleDto saleToSaleDto(Sale sale);
}
