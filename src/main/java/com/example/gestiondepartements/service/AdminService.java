package com.example.gestiondepartements.service;

import java.util.List;
import java.util.Optional;

import com.example.gestiondepartements.entity.Admin;

public interface AdminService {
    public Admin addAdmin(Admin admin);

    public Admin updateAdmin(Long id, Admin admin);

    public boolean deleteAdmin(Long id);

    public Optional<Admin> getAdmin(Long id);

    public List<Admin> getAllAdmins();

    public boolean existsById(Long id);
}
