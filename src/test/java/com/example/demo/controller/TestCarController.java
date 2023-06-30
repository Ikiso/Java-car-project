package com.example.demo.controller;

import com.example.demo.TestDemoApplication;
import com.example.demo.dto.CarDto;
import com.example.demo.service.CarService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
@RequiredArgsConstructor
class TestCarController extends TestDemoApplication {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void CarController_CreateCar_ReturnSavedCarDto() throws Exception {
        CarDto carDto = CarDto.builder().brand("MWV").model("BV34").fuel("Gas").count(5).build();

        when(carService.createCar(ArgumentMatchers.any()))
                .thenReturn(carDto);

        ResultActions resultActions = mockMvc.perform(post("/api/cars")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(carDto)));

        resultActions.andExpect(status().isCreated());
    }

    @Test
    void CarController_GetByIdCar_ReturnFindCarDto() throws Exception {
        CarDto carDto = CarDto.builder().brand("MWV").model("BV34").fuel("Gas").count(5).build();

        when(carService.createCar(ArgumentMatchers.any()))
                .thenReturn(carDto);

        ResultActions resultActions = mockMvc.perform(get("/api/cars/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(carDto)));

        resultActions.andExpect(status().isOk());
    }



}
