package com.reorg.journal.services;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

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

    public JournalMod getJournalByDate(String date) {
        Date var = Date.valueOf(date);
        return journalRepo.findByDate(var);
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

    public JournalDto updateJournal(JournalDto journalDto) {
        journalRepo.updateJournalByDateAndUserEmail(Date.valueOf(journalDto.getDate()), journalDto.getTitle(), journalDto.getBody(), journalDto.getUserEmail());
        return journalDto;
    }

 
}
