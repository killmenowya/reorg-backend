package com.reorg.journal.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reorg.journal.dto.JournalDto;
import com.reorg.journal.models.JournalMod;
import com.reorg.journal.services.JournalService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/journal")
@RequiredArgsConstructor
public class JournalController {

    private final JournalService journalService;

    @GetMapping
    public List<JournalDto> getAllJournal(@RequestParam String userEmail) {
        return journalService.getAllJournal(userEmail);
    }
    

    @GetMapping("{date}")
    @ResponseStatus(HttpStatus.OK)
    public JournalDto getJournalByDate(@PathVariable String date) {
        return journalService.getJournalByDate(date);
    }

    @PostMapping
    public JournalDto postJournal(@RequestBody JournalDto journalDto) {
        return journalService.postOrPutJournal(journalDto);
    }
    
    @DeleteMapping("{date}")
    public void deleteJournal(@PathVariable String date, @RequestBody String userEmail) {
        journalService.deleteJournal(date, userEmail);
    }

    @PutMapping("/update")
    public JournalDto updateJournal(@RequestBody JournalDto journalDto) {
        return journalService.updateJournal(journalDto);
    }


}
