package com.example.gestiondepartements.entity;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("Admin")
public class Admin extends Salaried {

    public String getRole() {
        return "ADMIN";
    }
}