package com.gstock.gstock.Service;

import com.gstock.gstock.Repository.ApproRepository;
import com.gstock.gstock.models.Approvisionnement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApproService {

    @Autowired
    private ApproRepository approvisionnementRepository;

    public List<Approvisionnement> getAllApprovisionnements() {
        return approvisionnementRepository.findAll();
    }

    public Optional<Approvisionnement> getApprovisionnementById(Long id) {
        return approvisionnementRepository.findById(id);
    }

    public Approvisionnement saveApprovisionnement(Approvisionnement approvisionnement) {
        return approvisionnementRepository.save(approvisionnement);
    }

    public Approvisionnement updateApprovisionnement(Approvisionnement approvisionnement) {
        return approvisionnementRepository.save(approvisionnement);
    }

    public void deleteApprovisionnement(Long id) {
        approvisionnementRepository.deleteById(id);
    }
}
