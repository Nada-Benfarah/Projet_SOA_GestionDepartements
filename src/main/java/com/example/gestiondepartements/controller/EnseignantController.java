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

import com.example.gestiondepartements.entity.Enseignant;
import com.example.gestiondepartements.entity.dto.EnseignantDto;
import com.example.gestiondepartements.entity.dto.EnseignantUpdateDto;
import com.example.gestiondepartements.service.EnseignantService;
import com.example.gestiondepartements.utils.mapper.EnseignantMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("enseignants")
@PreAuthorize("hasAnyRole('SUPERADMIN', 'ADMIN')")
@RequiredArgsConstructor
public class EnseignantController {
    private final EnseignantService service;
    private final EnseignantMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity<List<Enseignant>> getAllEnseignants() {
        return ResponseEntity.ok(service.getAllEnseignants());
    }

    @PostMapping
    public ResponseEntity<Enseignant> createEnseignant(@RequestBody @Valid EnseignantDto enseignantDto) {
        if (enseignantDto.getPassword() != null)
            enseignantDto.setPassword(passwordEncoder.encode(enseignantDto.getPassword()));
        return ResponseEntity.ok(service.addEnseignant(mapper.toEnseignant(enseignantDto)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enseignant> getEnseignantById(@PathVariable Long id) {
        var etudiant = service.getEnseignant(id);
        if (etudiant.isPresent())
            return ResponseEntity.ok(etudiant.get());
        else
            return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Enseignant> updateEnseignant(@PathVariable Long id,
            @RequestBody @Valid EnseignantUpdateDto enseignantDto) {
        Optional<Enseignant> optional = service.getEnseignant(id);
        if (optional.isPresent()) {
            Enseignant etudiant = optional.get();
            if (enseignantDto.getPassword() != null)
                enseignantDto.setPassword(passwordEncoder.encode(enseignantDto.getPassword()));
            mapper.updateEnseignant(enseignantDto, etudiant);
            return ResponseEntity.ok(service.updateEnseignant(id, etudiant));
        } else
            return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEnseignant(@PathVariable Long id) {
        if (service.existsById(id)) {
            if (service.deleteEnseignant(id))
                return ResponseEntity.ok("Deleted successfully");
            else
                return ResponseEntity.internalServerError().body("Error while deleting");
        } else
            return ResponseEntity.notFound().build();
    }
}
