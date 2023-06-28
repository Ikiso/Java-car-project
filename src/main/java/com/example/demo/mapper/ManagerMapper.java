package com.example.demo.mapper;

import com.example.demo.dto.ManagerDto;
import com.example.demo.dto.UpdateManagerDto;
import com.example.demo.model.Manager;
import org.mapstruct.*;

import java.util.List;


@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ManagerMapper {
    ManagerDto managerToManagerDto(Manager manager);

    Manager managerDtoToManager(ManagerDto managerDto);

    List<ManagerDto> listCarToListCarDto(List<Manager> managers);

    UpdateManagerDto managerToUpdateManagerDto(Manager manager);

    void fullUpdateCar(UpdateManagerDto updateManagerDto, @MappingTarget Manager manager);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    void partialUpdateCar(UpdateManagerDto updateManagerDto, @MappingTarget Manager manager);

}
