package com.gstock.gstock.Service;

import com.gstock.gstock.Repository.JournalRepository;
import com.gstock.gstock.models.Journal;
import com.gstock.gstock.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.*;


@Service
public class JournalService {

    @Autowired
    private JournalRepository journalRepository;

    public List<Journal> getAllJournaux() {
        return journalRepository.findAll();
    }

    public Optional<Journal> getJournalById(Long id) {
        return journalRepository.findById(id);
    }

    public Journal saveJournal(User user, String operation) {
        Journal journal = new Journal();
        journal.setDate(LocalDate.now());
        journal.setHeure(LocalTime.now());
        journal.setUtilisateur(user);
        journal.setOperation(operation);
        return journalRepository.save(journal);
    }
}
