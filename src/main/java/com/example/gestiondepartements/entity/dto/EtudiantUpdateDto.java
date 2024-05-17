package com.example.gestiondepartements.entity.dto;

import com.example.gestiondepartements.utils.validators.NullOrEmail;
import com.example.gestiondepartements.utils.validators.NullOrNumberSize;
import com.example.gestiondepartements.utils.validators.NullOrPositive;
import com.example.gestiondepartements.utils.validators.NullOrWithSize;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EtudiantUpdateDto {
    private String firstName;
    private String lastName;
    @NullOrEmail(message = "Email is not valid")
    private String email;
    @NullOrWithSize(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    @NullOrNumberSize(min = "0", max = "20", message = "Salary must be a valid number")
    private Double note;
    @NullOrPositive
    private Integer absentSessions;
    @NullOrPositive
    private Integer totalSessions;
}
