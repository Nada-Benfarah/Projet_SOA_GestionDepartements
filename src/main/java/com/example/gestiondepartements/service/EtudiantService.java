package com.example.gestiondepartements.service;

import java.util.List;
import java.util.Optional;

import com.example.gestiondepartements.entity.Etudiant;
import com.example.gestiondepartements.entity.dto.AbsentStaticsDto;
import com.example.gestiondepartements.entity.dto.SuccessStaticsDto;

public interface EtudiantService {
    public Etudiant addEtudiant(Etudiant etudiant);

    public Etudiant updateEtudiant(Long id, Etudiant etudiant);

    public boolean deleteEtudiant(Long id);

    public Optional<Etudiant> getEtudiant(Long id);

    public List<Etudiant> getAllEtudiants();

    public boolean existsById(Long id);

    public AbsentStaticsDto absentStatics();

    public SuccessStaticsDto successStatics();
}
