package com.gstock.gstock.models;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Distribution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeDistro;
    private String libelle;
    private int quantite;
    private double prixUnitaire;
    private double prixTotal;
    private LocalDate dateDistro;

    public Distribution() {
    }

    public Distribution(String libelle, int quantite, double prixUnitaire, double prixTotal, LocalDate dateDistro) {
        this.libelle = libelle;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.prixTotal = prixTotal;
        this.dateDistro = dateDistro;
    }
}
