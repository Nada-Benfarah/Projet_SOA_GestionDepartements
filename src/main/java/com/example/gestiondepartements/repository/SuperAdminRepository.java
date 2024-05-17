package com.example.gestiondepartements.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestiondepartements.entity.SuperAdmin;

public interface SuperAdminRepository extends JpaRepository<SuperAdmin, Long> {
    public boolean existsByEmail(String email);
}
