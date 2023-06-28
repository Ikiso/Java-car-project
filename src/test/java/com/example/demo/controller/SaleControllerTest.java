//package com.example.demo.controller;
//
//import com.example.demo.model.Car;
//import com.example.demo.model.Manager;
//import com.example.demo.model.Sale;
//import com.example.demo.service.SaleService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentMatchers;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(controllers = SaleController.class)
//@AutoConfigureMockMvc(addFilters = false)
//@ExtendWith(MockitoExtension.class)
//public class SaleControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private SaleService saleService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    private Sale sale;
//
//    @BeforeEach
//    public void init() {
//        Car car = Car.builder().brand("dgfd").model("sdfd").fuel("Gas").quantity(5).build();
//        Manager manager = Manager.builder().firstname("DFF").lastname("SSDE").sale(2).experience(1).build();
//        sale = Sale.builder().car(car).manager(manager).quantity(5).build();
//    }
//
//
//    @Test
//    public void SaleService_CreateSale_ReturnSavedSale() throws Exception {
//        when(saleService.createSale(ArgumentMatchers.anyLong(),ArgumentMatchers.anyLong(), ArgumentMatchers.anyInt()))
//                .thenReturn(sale);
//
//        ResultActions resultActions = mockMvc.perform(post("/sale/create/1/1/3")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(sale)));
//
//        resultActions.andExpect(status().isOk());
//    }
//}
