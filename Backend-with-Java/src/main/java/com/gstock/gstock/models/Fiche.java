package com.gstock.gstock.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class Fiche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroFiche;

    public Fiche() {
    }

    public Fiche(String numeroFiche) {
        this.numeroFiche = numeroFiche;
    }
}
