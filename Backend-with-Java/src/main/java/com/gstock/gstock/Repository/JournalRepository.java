package com.gstock.gstock.Repository;

import com.gstock.gstock.models.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository  extends JpaRepository<Journal, Long> {

}
