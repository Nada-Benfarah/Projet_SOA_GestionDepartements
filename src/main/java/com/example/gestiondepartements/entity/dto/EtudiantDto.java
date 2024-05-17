package com.example.gestiondepartements.entity.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class EtudiantDto {
    @NotBlank(message = "First name is mandatory")
    private String firstName;
    @NotBlank(message = "Last name is mandatory")
    private String lastName;
    @Email(message = "Email is mandatory")
    private String email;
    @NotBlank(message = "Password is mandatory")
    @Length(min = 8,  message = "Password must be at least 8 characters long")
    private String password;
    @NotNull
    @DecimalMin("0")
    @DecimalMax("20")
    private Double note;
    @NotNull
    @Positive
    private Integer absentSessions;
    @NotNull
    @Positive
    private Integer totalSessions;
}
