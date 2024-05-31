package com.reorg.journal.services;

import java.sql.Date;

import org.springframework.stereotype.Service;

import com.reorg.journal.models.JournalMod;
import com.reorg.journal.repository.JournalRepo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class JournalService {

    private final JournalRepo journalRepo;

    public JournalMod getJournalByDate(Date date) {
        return journalRepo.findByDate(date);
    }
 
}
