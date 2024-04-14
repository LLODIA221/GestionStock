package com.gstock.gstock.Service;

import com.gstock.gstock.Repository.FicheRepository;
import com.gstock.gstock.models.Fiche;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FicheService {

    @Autowired
    private FicheRepository ficheRepository;

    public List<Fiche> getAllFiches() {
        return ficheRepository.findAll();
    }

    public Optional<Fiche> getFicheById(Long id) {
        return ficheRepository.findById(id);
    }

    public Fiche createFiche() {
        String nouveauNumeroFiche = generateNouveauNumeroFiche();
        Fiche nouvelleFiche = new Fiche(nouveauNumeroFiche);
        return ficheRepository.save(nouvelleFiche);
    }

    private String generateNouveauNumeroFiche() {
        // Logique pour générer un nouveau numéro de fiche unique
        // Par exemple, utiliser un compteur ou une séquence
        return "FICHE-" + System.currentTimeMillis();
    }
}
