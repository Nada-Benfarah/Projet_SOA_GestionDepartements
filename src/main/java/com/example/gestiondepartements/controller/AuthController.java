package com.example.gestiondepartements.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.gestiondepartements.entity.dto.AuthenticationRequestDto;
import com.example.gestiondepartements.entity.dto.AuthenticationResponseDto;
import com.example.gestiondepartements.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService service;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDto> login(@RequestBody AuthenticationRequestDto auth) {
        try {
            return ResponseEntity.ok(service.authenticate(auth.getEmail(), auth.getPassword()));
        } catch (UsernameNotFoundException e) {

            return ResponseEntity.status(403).build();
        }
    }

}
