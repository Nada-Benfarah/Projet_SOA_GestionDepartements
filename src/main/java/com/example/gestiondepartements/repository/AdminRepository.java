package com.example.gestiondepartements.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import com.example.gestiondepartements.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    public boolean existsById(@NonNull Long id);
}