package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ManagerDto {

    private Long id;

    private String firstname;

    private String lastname;

    private String  passportId;

    private int experience;

    private int sale;
}
