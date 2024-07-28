package com.reorg.journal.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reorg.journal.dto.JournalDto;
import com.reorg.journal.models.JournalMod;
import com.reorg.journal.repository.JournalRepo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class JournalService {

    private final JournalRepo journalRepo;

    
    public List<JournalDto> getAllJournal(String userEmail) {
        List<JournalMod> list = journalRepo.findAllByUserEmail(userEmail);
        return list.stream().map(data -> JournalDto.builder()
                                    .userEmail(data.getUserEmail())
                                    .title(data.getTitle())
                                    .body(data.getBody())
                                    .date(data.getDate().toString())
                                    .build()).toList();
    }

    public JournalDto getJournalByDate(String date) {
        Date var = Date.valueOf(date);
        JournalMod data = journalRepo.findByDate(var);
        return JournalDto.builder()
                            .userEmail(data.getUserEmail())
                            .title(data.getTitle())
                            .body(data.getBody())
                            .build();
    }

    public JournalDto postJournal(JournalDto journalDto) {
        JournalMod journalMod = JournalMod.builder()
                                .userEmail(journalDto.getUserEmail())
                                .title(journalDto.getTitle())
                                .body(journalDto.getBody())
                                .date(Date.valueOf(journalDto.getDate()))
                                .build();
        journalRepo.save(journalMod);
        return journalDto;
    }

    public void deleteJournal(String date, String userEmail) {
        Date var = Date.valueOf(date);
        journalRepo.deleteByDateAndUserEmail(var, userEmail);
    }

    @Transactional
    public JournalDto updateJournal(JournalDto journalDto) {
        journalRepo.updateJournalByDateAndUserEmail(Date.valueOf(journalDto.getDate()), journalDto.getTitle(), journalDto.getBody(), journalDto.getUserEmail());
        return journalDto;
    }

    public JournalDto postOrPutJournal(JournalDto journalDto) {
        Date journalDate = Date.valueOf(journalDto.getDate());
        Optional<JournalMod> existingEntry = journalRepo.findByUserEmailAndDate(journalDto.getUserEmail(), journalDate);

        if (existingEntry.isPresent()) {
            return updateJournal(journalDto); // Update if entry exists
        } else {
            return postJournal(journalDto); // Create if no entry exists
        }
    }

 
}
