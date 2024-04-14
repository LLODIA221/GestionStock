package com.gstock.gstock.Controller;

import com.gstock.gstock.Service.SortieService;
import com.gstock.gstock.models.Sortie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sorties")
public class SortieController {

    @Autowired
    private SortieService sortieService;

    @GetMapping
    public ResponseEntity<List<Sortie>> getAllSorties() {
        List<Sortie> sorties = sortieService.getAllSorties();
        return ResponseEntity.ok(sorties);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sortie> getSortieById(@PathVariable Long id) {
        Optional<Sortie> sortie = sortieService.getSortieById(id);
        return sortie.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Sortie> saveSortie(@RequestBody Sortie sortie) {
        Sortie savedSortie = sortieService.saveSortie(sortie);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSortie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sortie> updateSortie(@PathVariable Long id, @RequestBody Sortie sortie) {
        Optional<Sortie> existingSortie = sortieService.getSortieById(id);
        if (existingSortie.isPresent()) {
            Sortie updatedSortie = sortieService.updateSortie(sortie);
            return ResponseEntity.ok(updatedSortie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSortie(@PathVariable Long id) {
        Optional<Sortie> existingSortie = sortieService.getSortieById(id);
        if (existingSortie.isPresent()) {
            sortieService.deleteSortie(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}