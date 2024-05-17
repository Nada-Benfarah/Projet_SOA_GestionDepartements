package com.example.gestiondepartements.entity;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("Enseignant")
public class Enseignant extends Salaried {

    public String getRole() {
        return "ENSEIGNANT";
    }
}