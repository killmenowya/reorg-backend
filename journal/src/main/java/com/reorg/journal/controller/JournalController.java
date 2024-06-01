package com.reorg.journal.controller;

import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reorg.journal.models.JournalMod;
import com.reorg.journal.services.JournalService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/journal")
@RequiredArgsConstructor
public class JournalController {

    private final JournalService journalService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public JournalMod getJournalByDate(@RequestParam Date date) {
        return journalService.getJournalByDate(date);
    }

}
