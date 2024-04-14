package com.gstock.gstock.Repository;

import com.gstock.gstock.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository  extends JpaRepository<Produit, Long> {
}
