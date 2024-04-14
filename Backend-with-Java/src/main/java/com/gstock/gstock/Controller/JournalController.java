package com.gstock.gstock.Controller;

import com.gstock.gstock.Service.JournalService;
import com.gstock.gstock.Service.UserService;
import com.gstock.gstock.models.Journal;
import com.gstock.gstock.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/journaux")
public class JournalController {

    @Autowired
    private JournalService journalService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Journal>> getAllJournaux() {
        List<Journal> journaux = journalService.getAllJournaux();
        return ResponseEntity.ok(journaux);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Journal> getJournalById(@PathVariable Long id) {
        Optional<Journal> journal = journalService.getJournalById(id);
        return journal.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Journal> saveJournal(@RequestBody Journal journal) {
        Optional<User> user = userService.getUserById(journal.getUtilisateur().getId());
        if (user.isPresent()) {
            Journal savedJournal = journalService.saveJournal(user.get(), journal.getOperation());
            return ResponseEntity.status(HttpStatus.CREATED).body(savedJournal);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}