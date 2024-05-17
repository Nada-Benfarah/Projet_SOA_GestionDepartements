package com.example.gestiondepartements.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public abstract class Salaried extends Person {
    private Double salary;
}