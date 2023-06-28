package com.example.demo.mapper;

import com.example.demo.dto.CarDto;
import com.example.demo.dto.UpdateCarDto;
import com.example.demo.model.Car;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface CarMapper {

    @Mapping(target = "count", source = "quantity")
    CarDto carToCarDTO(Car car);

    @Mapping(target = "quantity", source = "count")
    Car carDtoToCar(CarDto carDTO);

    List<CarDto> listCarToListCarDto(List<Car> cars);

    UpdateCarDto carToUpdateCarDto(Car car);

    void fullUpdateCar(UpdateCarDto updateCarDto, @MappingTarget Car car);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    void partialUpdateCar(UpdateCarDto updateCarDto, @MappingTarget Car car);

}
