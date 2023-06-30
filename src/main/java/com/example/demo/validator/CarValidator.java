package com.example.demo.validator;

import com.example.demo.dto.CarDto;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Component
public class CarValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return CarDto.class.equals(clazz);
    }
    @SneakyThrows
    @Override
    public void validate(Object target, Errors errors) {
        CarDto carDto = (CarDto) target;
        if (StringUtils.isBlank(carDto.getBrand())) {
            errors.rejectValue("brand", "brand.empty", "Brand empty");
        }
        if (StringUtils.isBlank(carDto.getModel())) {
            errors.rejectValue("model", "model.empty", "Model empty");
        }
        if (StringUtils.isBlank(carDto.getFuel())) {
            errors.rejectValue("fuel", "fuel.empty", "Fuel empty");
        }
        if (carDto.getCount() < 0) {
            errors.rejectValue("count", "count.notPositive", "Count not positive");
        }

        if(errors.hasErrors()) {
            BindingResult bindingResult = new BeanPropertyBindingResult(errors.getFieldError(), errors.getObjectName());
            for (FieldError fieldError : errors.getFieldErrors()) {
                bindingResult.addError(fieldError);
            }
            throw new MethodArgumentNotValidException(new MethodParameter(this.getClass().getDeclaredMethod("validate", Object.class, Errors.class), 0), bindingResult);
        }
    }
}
