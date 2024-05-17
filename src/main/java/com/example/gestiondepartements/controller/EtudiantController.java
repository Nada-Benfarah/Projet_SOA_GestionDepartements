package com.example.gestiondepartements.controller;

import com.example.gestiondepartements.entity.Etudiant;
import com.example.gestiondepartements.entity.dto.AbsentStaticsDto;
import com.example.gestiondepartements.entity.dto.EtudiantDto;
import com.example.gestiondepartements.entity.dto.EtudiantUpdateDto;
import com.example.gestiondepartements.entity.dto.SuccessStaticsDto;
import com.example.gestiondepartements.service.EtudiantService;
import com.example.gestiondepartements.utils.mapper.EtudiantMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("etudiants")
@PreAuthorize("hasAnyRole('SUPERADMIN', 'ADMIN')")
@RequiredArgsConstructor
public class EtudiantController {

    private final EtudiantService service;
    private final EtudiantMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity<List<Etudiant>> getAllEtudiants() {
        return ResponseEntity.ok(service.getAllEtudiants());
    }

    @PostMapping
    public ResponseEntity<Etudiant> createEtudiant(@RequestBody @Valid EtudiantDto etudiantDto) {
        if (etudiantDto.getPassword() != null)
            etudiantDto.setPassword(passwordEncoder.encode(etudiantDto.getPassword()));
        return ResponseEntity.ok(service.addEtudiant(mapper.toEtudiant(etudiantDto)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable Long id) {
        var etudiant = service.getEtudiant(id);
        if (etudiant.isPresent())
            return ResponseEntity.ok(etudiant.get());
        else
            return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable Long id,
            @RequestBody @Valid EtudiantUpdateDto etudiantDto) {
        Optional<Etudiant> optional = service.getEtudiant(id);
        if (optional.isPresent()) {

            Etudiant etudiant = optional.get();
            if (etudiantDto.getPassword() != null)
                etudiantDto.setPassword(passwordEncoder.encode(etudiantDto.getPassword()));
            mapper.updateEtudiant(etudiantDto, etudiant);
            return ResponseEntity.ok(service.updateEtudiant(id, etudiant));
        } else
            return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEtudiant(@PathVariable Long id) {
        if (service.existsById(id)) {
            if (service.deleteEtudiant(id))
                return ResponseEntity.ok("Deleted successfully");
            else
                return ResponseEntity.internalServerError().body("Error while deleting");
        } else
            return ResponseEntity.notFound().build();
    }

    @GetMapping("/absent-statistics")
    public ResponseEntity<AbsentStaticsDto> adsentStatistics() {
        return ResponseEntity.ok(service.absentStatics());
    }

    @GetMapping("/success-statistics")
    public ResponseEntity<SuccessStaticsDto> successStatistics() {
        return ResponseEntity.ok(service.successStatics());
    }

}
