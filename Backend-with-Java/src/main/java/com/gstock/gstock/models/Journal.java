package com.gstock.gstock.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
public class Journal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private LocalTime heure;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private User utilisateur;

    private String operation;

    public Journal() {
    }

    public Journal(LocalDate date, LocalTime heure, User utilisateur, String operation) {
        this.date = date;
        this.heure = heure;
        this.utilisateur = utilisateur;
        this.operation = operation;
    }
}
