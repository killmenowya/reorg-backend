package com.reorg.course_details.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.annotation.Generated;
import jakarta.persistence.Access;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Mod_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDetailMod {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String acadYear; // AY22/23
    private String moduleCode; // cs1101s
    private String title; // computing methodlogy 1
    private String description; // shitty mod
    private int modCredit; // 4
    private String department; // computing
    private String faculty; // computing
    private int[] workload; // [4,4,1,4,4]
    private LocalDateTime currDate; // the date today??
    private Boolean required; // user input req or not
    private String preReq; // preReq Tree
    private String coReq; // coreqs
    private String preclusion; // preclusion
    private DateTimeFormatter examDate; // yyyy-mm-ddThh:mm:ss:mssZ
    private DateTimeFormatter examDuration; // in minutes eg 120min == 2 hr

}
