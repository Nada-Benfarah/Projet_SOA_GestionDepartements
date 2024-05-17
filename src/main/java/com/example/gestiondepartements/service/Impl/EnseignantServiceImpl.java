package com.example.gestiondepartements.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.gestiondepartements.entity.Enseignant;
import com.example.gestiondepartements.repository.EnseignantRepository;
import com.example.gestiondepartements.service.EnseignantService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnseignantServiceImpl implements EnseignantService {
    private final EnseignantRepository repository;

    @Override
    public List<Enseignant> getAllEnseignants() {
        return repository.findAll();
    }

    @Override
    public Optional<Enseignant> getEnseignant(Long id) {
        return repository.findById(id);
    }

    @Override
    public Enseignant addEnseignant(Enseignant enseignant) {
        return repository.save(enseignant);
    }

    @Override
    public Enseignant updateEnseignant(Long id, Enseignant etudiant) {
        etudiant.setId(id);
        return repository.save(etudiant);
    }

    @Override
    public boolean deleteEnseignant(Long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
}