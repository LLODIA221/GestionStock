package com.gstock.gstock.Service;

import com.gstock.gstock.Repository.DistroRepository;
import com.gstock.gstock.models.Distribution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistributionService {

    @Autowired
    private DistroRepository distributionRepository;

    public List<Distribution> getAllDistributions() {
        return distributionRepository.findAll();
    }

    public Optional<Distribution> getDistributionById(Long id) {
        return distributionRepository.findById(id);
    }

    public Distribution saveDistribution(Distribution distribution) {
        return distributionRepository.save(distribution);
    }

    public Distribution updateDistribution(Distribution distribution) {
        return distributionRepository.save(distribution);
    }

    public void deleteDistribution(Long id) {
        distributionRepository.deleteById(id);
    }
}