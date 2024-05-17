package com.example.gestiondepartements.service.Impl;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.gestiondepartements.entity.Person;
import com.example.gestiondepartements.entity.dto.AuthenticationResponseDto;
import com.example.gestiondepartements.repository.PersonRepository;
import com.example.gestiondepartements.service.AuthenticationService;
import com.example.gestiondepartements.service.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final PersonRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public AuthenticationResponseDto authenticate(String username, String password) {
        Person p = repository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (passwordEncoder.matches(password, p.getPassword())) {
            AuthenticationResponseDto response = new AuthenticationResponseDto();
            response.setToken(jwtService.generateToken(p));
            return response;
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }

}
