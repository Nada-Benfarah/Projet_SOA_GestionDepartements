package com.example.gestiondepartements;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.gestiondepartements.entity.SuperAdmin;
import com.example.gestiondepartements.repository.SuperAdminRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class GestionDepartementsApplication implements CommandLineRunner {
    private final SuperAdminRepository superAdminRepository;
    private final PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(GestionDepartementsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (superAdminRepository.existsByEmail("admin@email.com"))
            return;

        SuperAdmin superAdmin = new SuperAdmin();
        superAdmin.setEmail("admin@email.com");
        superAdmin.setFirstName("admin");
        superAdmin.setLastName("admin");
        superAdmin.setPassword(passwordEncoder.encode("admin123456"));
        superAdminRepository.save(superAdmin);
    }

}
