package com.gstock.gstock.Service;

import com.gstock.gstock.Repository.ProduitRepository;
import com.gstock.gstock.models.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public Optional<Produit> getProduitByCode(String codeProduit) {
        return produitRepository.findById(Long.valueOf(codeProduit));
    }

    public Produit saveProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public Produit updateProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public void deleteProduit(String codeProduit) {
        produitRepository.deleteById(Long.valueOf(codeProduit));
    }
}