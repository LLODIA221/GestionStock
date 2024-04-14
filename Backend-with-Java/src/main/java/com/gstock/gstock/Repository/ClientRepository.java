package com.gstock.gstock.Repository;

import com.gstock.gstock.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {
    List<Client> findByNomContaining(String nom);
}
