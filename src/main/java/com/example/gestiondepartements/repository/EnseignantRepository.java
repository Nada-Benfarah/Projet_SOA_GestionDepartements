package com.example.gestiondepartements.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import com.example.gestiondepartements.entity.Enseignant;

public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
    public boolean existsById(@NonNull Long id);
}
