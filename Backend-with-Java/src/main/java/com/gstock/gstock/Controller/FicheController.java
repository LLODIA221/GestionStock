package com.gstock.gstock.Controller;

import com.gstock.gstock.Service.FicheService;
import com.gstock.gstock.models.Fiche;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fiches")
public class FicheController {

    @Autowired
    private FicheService ficheService;

    @GetMapping
    public ResponseEntity<List<Fiche>> getAllFiches() {
        List<Fiche> fiches = ficheService.getAllFiches();
        return ResponseEntity.ok(fiches);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fiche> getFicheById(@PathVariable Long id) {
        Optional<Fiche> fiche = ficheService.getFicheById(id);
        return fiche.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Fiche> createFiche() {
        Fiche nouvelleFiche = ficheService.createFiche();
        return ResponseEntity.status(HttpStatus.CREATED).body(nouvelleFiche);
    }
}
