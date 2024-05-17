package com.example.gestiondepartements.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestiondepartements.entity.Admin;
import com.example.gestiondepartements.entity.dto.AdminDto;
import com.example.gestiondepartements.entity.dto.AdminUpdateDto;
import com.example.gestiondepartements.service.AdminService;
import com.example.gestiondepartements.utils.mapper.AdminMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("admins")
@RequiredArgsConstructor
@PreAuthorize("hasRole('SUPERADMIN')")
public class AdminController {
    private final AdminService service;
    private final AdminMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity<List<Admin>> getAllAdmins() {
        return ResponseEntity.ok(service.getAllAdmins());
    }

    @PostMapping
    public ResponseEntity<Admin> createAdmin(@RequestBody @Valid AdminDto adminDto) {
        if (adminDto.getPassword() != null)
            adminDto.setPassword(passwordEncoder.encode(adminDto.getPassword()));
        return ResponseEntity.ok(service.addAdmin(mapper.toAdmin(adminDto)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
        var admin = service.getAdmin(id);
        if (admin.isPresent())
            return ResponseEntity.ok(admin.get());
        else
            return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id,
            @RequestBody @Valid AdminUpdateDto adminDto) {
        if (adminDto.getPassword() != null)
            adminDto.setPassword(passwordEncoder.encode(adminDto.getPassword()));

        Optional<Admin> optional = service.getAdmin(id);
        if (optional.isPresent()) {
            Admin admin = optional.get();
            mapper.updateAdmin(adminDto, admin);
            return ResponseEntity.ok(service.updateAdmin(id, admin));
        } else
            return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable Long id) {
        if (service.existsById(id)) {
            if (service.deleteAdmin(id))
                return ResponseEntity.ok("Deleted successfully");
            else
                return ResponseEntity.internalServerError().body("Error while deleting");
        } else
            return ResponseEntity.notFound().build();
    }
}
