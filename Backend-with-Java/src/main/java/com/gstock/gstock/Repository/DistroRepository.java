package com.gstock.gstock.Repository;

import com.gstock.gstock.models.Distribution;
import jakarta.persistence.TypedQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistroRepository  extends JpaRepository<Distribution, Long> {
  //  TypedQuery<Distribution> createQuery(String requete, Class<Distribution> distributionClass);
}
