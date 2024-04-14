package com.gstock.gstock.Repository;

import com.gstock.gstock.models.Fiche;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FicheRepository  extends JpaRepository<Fiche, Long> {
}
