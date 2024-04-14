package com.gstock.gstock.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Sortie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    @OneToOne
    @JoinColumn(name = "fiche_id")
    private Fiche fiche;

    private int quantite;
    private double prixUnitaire;
    private double prixTotal;
    private LocalDate dateSortie;

    public Sortie() {
    }

    public Sortie(Fiche fiche, int quantite, double prixUnitaire, double prixTotal, LocalDate dateSortie) {
        this.fiche = fiche;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.prixTotal = prixTotal;
        this.dateSortie = dateSortie;
    }
}
