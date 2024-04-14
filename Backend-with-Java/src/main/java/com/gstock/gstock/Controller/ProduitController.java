package com.gstock.gstock.Controller;

import com.gstock.gstock.Service.ProduitService;
import com.gstock.gstock.models.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @GetMapping
    public ResponseEntity<List<Produit>> getAllProduits() {
        List<Produit> produits = produitService.getAllProduits();
        return ResponseEntity.ok(produits);
    }

    @GetMapping("/{codeProduit}")
    public ResponseEntity<Produit> getProduitByCode(@PathVariable String codeProduit) {
        Optional<Produit> produit = produitService.getProduitByCode(codeProduit);
        return produit.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Produit> saveProduit(@RequestBody Produit produit) {
        Produit savedProduit = produitService.saveProduit(produit);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduit);
    }

    @PutMapping("/{codeProduit}")
    public ResponseEntity<Produit> updateProduit(@PathVariable String codeProduit, @RequestBody Produit produit) {
        Optional<Produit> existingProduit = produitService.getProduitByCode(codeProduit);
        if (existingProduit.isPresent()) {
            Produit updatedProduit = produitService.updateProduit(produit);
            return ResponseEntity.ok(updatedProduit);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codeProduit}")
    public ResponseEntity<Void> deleteProduit(@PathVariable String codeProduit) {
        Optional<Produit> existingProduit = produitService.getProduitByCode(codeProduit);
        if (existingProduit.isPresent()) {
            produitService.deleteProduit(codeProduit);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
