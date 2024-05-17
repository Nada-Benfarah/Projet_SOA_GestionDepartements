package com.example.gestiondepartements.entity.dto;

import com.example.gestiondepartements.utils.validators.NullOrEmail;
import com.example.gestiondepartements.utils.validators.NullOrPositive;
import com.example.gestiondepartements.utils.validators.NullOrWithSize;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminUpdateDto {
    private String firstName;
    private String lastName;
    @NullOrEmail(message = "Email is not valid")
    private String email;
    @NullOrWithSize(min = 8, message = "Password must be at least 8 characters long")
    private String password;
    @NullOrPositive(message = "Salary must be positive")
    private Double salary;
}
