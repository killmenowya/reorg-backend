package com.reorg.journal.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "journal")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JournalMod {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String userEmail; //idetifier to see which user own this entry
    private String title;
    private String body;
    private Date date;

}
