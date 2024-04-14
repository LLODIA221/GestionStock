package com.gstock.gstock.Repository;

import com.gstock.gstock.models.Approvisionnement;
import jakarta.persistence.TypedQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApproRepository extends JpaRepository<Approvisionnement,Long> {
    //TypedQuery<Approvisionnement> createQuery(String requete, Class<Approvisionnement> approvisionnementClass);
}
