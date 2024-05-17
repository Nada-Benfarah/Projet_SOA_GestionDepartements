package com.example.gestiondepartements.service;

import com.example.gestiondepartements.entity.dto.AuthenticationResponseDto;

public interface AuthenticationService {
    public AuthenticationResponseDto authenticate(String username, String password);
}
