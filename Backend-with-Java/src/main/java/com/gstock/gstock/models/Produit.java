package com.gstock.gstock.models;

import jakarta.persistence.*;

import lombok.*;


@Getter
@Setter
@Entity
public class Produit {
    @Id
    private String codeProduit;
    private String libelle;
    private int quantite;
    private double prixUnitaire;

    public Produit() {
    }

    public Produit(String codeProduit, String libelle, int quantite, double prixUnitaire) {
        this.codeProduit = codeProduit;
        this.libelle = libelle;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
    }
}
