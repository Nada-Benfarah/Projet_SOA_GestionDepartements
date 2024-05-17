package com.example.gestiondepartements.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("Etudiant")
@Getter
@Setter
public class Etudiant extends Person {
    private Double note;
    private Integer absentSessions;
    private Integer totalSessions;

    public String getRole() {
        return "ETUDIANT";
    }
}