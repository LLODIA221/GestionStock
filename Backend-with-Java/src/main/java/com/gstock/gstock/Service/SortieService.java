package com.gstock.gstock.Service;

import com.gstock.gstock.Repository.SortieRepository;
import com.gstock.gstock.models.Sortie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SortieService {

    @Autowired
    private SortieRepository sortieRepository;

    public List<Sortie> getAllSorties() {
        return sortieRepository.findAll();
    }

    public Optional<Sortie> getSortieById(Long id) {
        return sortieRepository.findById(id);
    }

    public Sortie saveSortie(Sortie sortie) {
        return sortieRepository.save(sortie);
    }

    public Sortie updateSortie(Sortie sortie) {
        return sortieRepository.save(sortie);
    }

    public void deleteSortie(Long id) {
        sortieRepository.deleteById(id);
    }
}