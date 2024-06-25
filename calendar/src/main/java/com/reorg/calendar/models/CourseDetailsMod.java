package com.reorg.calendar.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.reorg.calendar.utils.WorkloadDeserializer;

import jakarta.persistence.Lob;
import lombok.Data;

@Data
public class CourseDetailsMod {
    private String acadYear;
    private String preclusion;
    @Lob
    private String description;
    private String title;
    private String depeartment;
    private String faculty;
    @JsonDeserialize(using = WorkloadDeserializer.class)
    private String workload;
    private String moduleCredit;
    private SemesterMod[] semesterData;

}
