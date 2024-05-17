package com.example.gestiondepartements.service;

import java.util.List;
import java.util.Optional;

import com.example.gestiondepartements.entity.Enseignant;

public interface EnseignantService {
    public Enseignant addEnseignant(Enseignant enseignant);

    public Enseignant updateEnseignant(Long id, Enseignant enseignant);

    public boolean deleteEnseignant(Long id);

    public Optional<Enseignant> getEnseignant(Long id);

    public List<Enseignant> getAllEnseignants();

    public boolean existsById(Long id);

}
