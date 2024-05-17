package com.example.gestiondepartements.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SuccessStaticsDto {
    private Long successStudentNumber;
    private Long totalStudentNumber;
    private Double successRate;
}
