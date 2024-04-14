package com.gstock.gstock.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@Entity
public class Approvisionnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeAppro;
    private String libelle;
    private int quantite;
    private LocalDate dateAppro;


    public Approvisionnement() {
    }

    public Approvisionnement(String libelle, int quantite, LocalDate dateAppro) {
        this.libelle = libelle;
        this.quantite = quantite;
        this.dateAppro = dateAppro;
    }
}
