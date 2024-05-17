package com.example.gestiondepartements.service.Impl;

import com.example.gestiondepartements.entity.Etudiant;
import com.example.gestiondepartements.entity.dto.AbsentStaticsDto;
import com.example.gestiondepartements.entity.dto.SuccessStaticsDto;
import com.example.gestiondepartements.repository.EtudiantRepository;
import com.example.gestiondepartements.service.EtudiantService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EtudiantServiceImpl implements EtudiantService {
    private final EtudiantRepository repository;

    @Override
    public List<Etudiant> getAllEtudiants() {
        return repository.findAll();
    }

    @Override
    public Optional<Etudiant> getEtudiant(Long id) {
        return repository.findById(id);
    }

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return repository.save(etudiant);
    }

    @Override
    public Etudiant updateEtudiant(Long id, Etudiant etudiant) {
        etudiant.setId(id);
        return repository.save(etudiant);
    }

    @Override
    public boolean deleteEtudiant(Long id) {
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

    @Override
    public AbsentStaticsDto absentStatics() {
        return repository.absentStatics();
    }

    @Override
    public SuccessStaticsDto successStatics() {
        return repository.successStatics();
    }
}