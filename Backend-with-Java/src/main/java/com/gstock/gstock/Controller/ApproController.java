package com.gstock.gstock.Controller;
import com.gstock.gstock.Service.ApproService;
import com.gstock.gstock.models.Approvisionnement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/approvisionnements")
public class ApproController {
    @Autowired
    private ApproService approvisionnementService;

    @GetMapping
    public ResponseEntity<List<Approvisionnement>> getAllApprovisionnements() {
        List<Approvisionnement> approvisionnements = approvisionnementService.getAllApprovisionnements();
        return ResponseEntity.ok(approvisionnements);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Approvisionnement> getApprovisionnementById(@PathVariable Long id) {
        Optional<Approvisionnement> approvisionnement = approvisionnementService.getApprovisionnementById(id);
        return approvisionnement.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Approvisionnement> saveApprovisionnement(@RequestBody Approvisionnement approvisionnement) {
        Approvisionnement savedApprovisionnement = approvisionnementService.saveApprovisionnement(approvisionnement);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedApprovisionnement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Approvisionnement> updateApprovisionnement(@PathVariable Long id, @RequestBody Approvisionnement approvisionnement) {
        Optional<Approvisionnement> existingApprovisionnement = approvisionnementService.getApprovisionnementById(id);
        if (existingApprovisionnement.isPresent()) {
            Approvisionnement updatedApprovisionnement = approvisionnementService.updateApprovisionnement(approvisionnement);
            return ResponseEntity.ok(updatedApprovisionnement);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApprovisionnement(@PathVariable Long id) {
        Optional<Approvisionnement> existingApprovisionnement = approvisionnementService.getApprovisionnementById(id);
        if (existingApprovisionnement.isPresent()) {
            approvisionnementService.deleteApprovisionnement(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
