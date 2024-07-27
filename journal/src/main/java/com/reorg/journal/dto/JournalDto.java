package com.reorg.journal.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JournalDto {
    private String userEmail; //idetifier to see which user own this entry
    private String title;
    private String body;
    private String date;
}
