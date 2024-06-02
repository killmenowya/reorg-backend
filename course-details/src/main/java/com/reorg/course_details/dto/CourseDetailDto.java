package com.reorg.course_details.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDetailDto {
    private String moduleCode; //cs1101
    private String title; //computing methodlogy 1
    private String description; //shitty mod
    private String moduleCredit; //4
    private String department; //computing
    private String faculty; //computing
    // private int[] workload; //[4,4,4,4,4]
    // private String preclusion; //must pass a lvl math
    // private String SU; //no SU
    // private Date examDate; //yyyy-mm-ddThh:mm:ss:mssZ
    // private int examDuration; //120min == 2 hr
    // private boolean required; //user input
}

