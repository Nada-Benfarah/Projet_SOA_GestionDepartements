package com.example.gestiondepartements.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AbsentStaticsDto {
    private Long absentSessions;
    private Long totalSessions;
    private Double absentRate;
}
