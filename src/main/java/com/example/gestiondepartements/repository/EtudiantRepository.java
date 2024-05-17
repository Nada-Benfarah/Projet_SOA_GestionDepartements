package com.example.gestiondepartements.repository;

import com.example.gestiondepartements.entity.Etudiant;
import com.example.gestiondepartements.entity.dto.AbsentStaticsDto;
import com.example.gestiondepartements.entity.dto.SuccessStaticsDto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    public boolean existsById(@NonNull Long id);

    @Query("""
            SELECT
            new com.example.gestiondepartements.entity.dto.AbsentStaticsDto(
                SUM(e.absentSessions),
                SUM(e.totalSessions),
                SUM(e.absentSessions) * 1.0 / SUM(e.totalSessions) * 100
                )
                FROM Etudiant e
            """)
    public AbsentStaticsDto absentStatics();

    @Query("""
            SELECT
            new com.example.gestiondepartements.entity.dto.SuccessStaticsDto(
                COUNT(case when e.note >= 10 THEN 1 else null end),
                COUNT(e.note),
                COUNT(case when e.note >= 10 THEN 1 else null end) * 1.0 / COUNT(e.note) * 100
                )
                FROM Etudiant e
            """)
    public SuccessStaticsDto successStatics();
}