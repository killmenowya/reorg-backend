package com.reorg.course_details.models;

import java.sql.Date;

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
    private String moduleCode; //cs1101
    private String title; //computing methodlogy 1
    private String description; //shitty mod
    private String moduleCredit; //4
    private String department; //computing
    private String faculty; //computing
    // private String workload; //[4,4,4,4,4]
    // private String preclusion; //must pass a lvl math
    // private String SU; //no SU
    // private Date examDate; //yyyy-mm-ddThh:mm:ss:mssZ
    // private int examDuration; //120min == 2 hr
    // private boolean required; //user input
}
