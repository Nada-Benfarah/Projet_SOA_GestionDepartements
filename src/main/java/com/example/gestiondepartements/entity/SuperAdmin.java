package com.example.gestiondepartements.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SuperAdmin")
public class SuperAdmin extends Person {

    public String getRole() {
        return "SUPERADMIN";
    }

}
