package com.example.gestiondepartements.entity.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class AuthenticationRequestDto {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
