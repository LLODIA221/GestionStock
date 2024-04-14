package com.gstock.gstock.Controller;
import com.gstock.gstock.Service.DistributionService;
import com.gstock.gstock.models.Distribution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/distributions")
public class DistroController{
@Autowired
private DistributionService distributionService;

@GetMapping
public ResponseEntity<List<Distribution>> getAllDistributions() {
    List<Distribution> distributions = distributionService.getAllDistributions();
    return ResponseEntity.ok(distributions);
}

@GetMapping("/{id}")
public ResponseEntity<Distribution> getDistributionById(@PathVariable Long id) {
    Optional<Distribution> distribution = distributionService.getDistributionById(id);
    return distribution.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
}

@PostMapping
public ResponseEntity<Distribution> saveDistribution(@RequestBody Distribution distribution) {
    Distribution savedDistribution = distributionService.saveDistribution(distribution);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedDistribution);
}

@PutMapping("/{id}")
public ResponseEntity<Distribution> updateDistribution(@PathVariable Long id, @RequestBody Distribution distribution) {
    Optional<Distribution> existingDistribution = distributionService.getDistributionById(id);
    if (existingDistribution.isPresent()) {
        Distribution updatedDistribution = distributionService.updateDistribution(distribution);
        return ResponseEntity.ok(updatedDistribution);
    } else {
        return ResponseEntity.notFound().build();
    }
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteDistribution(@PathVariable Long id) {
    Optional<Distribution> existingDistribution = distributionService.getDistributionById(id);
    if (existingDistribution.isPresent()) {
        distributionService.deleteDistribution(id);
        return ResponseEntity.noContent().build();
    } else {
        return ResponseEntity.notFound().build();
    }
}
}
