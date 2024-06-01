package com.reorg.journal.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reorg.journal.models.JournalMod;

public interface JournalRepo extends JpaRepository<JournalMod, Long> {
    JournalMod findByDate(Date date);
}
