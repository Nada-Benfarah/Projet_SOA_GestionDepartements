package com.example.gestiondepartements.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestiondepartements.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    public Optional<Person> findByEmail(String email);
}
