package com.example.gestiondepartements.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.gestiondepartements.entity.Admin;
import com.example.gestiondepartements.repository.AdminRepository;
import com.example.gestiondepartements.service.AdminService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository repository;

    @Override
    public List<Admin> getAllAdmins() {
        return repository.findAll();
    }

    @Override
    public Optional<Admin> getAdmin(Long id) {
        return repository.findById(id);
    }

    @Override
    public Admin addAdmin(Admin admin) {
        return repository.save(admin);
    }

    @Override
    public Admin updateAdmin(Long id, Admin admin) {
        admin.setId(id);
        return repository.save(admin);
    }

    @Override
    public boolean deleteAdmin(Long id) {
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
