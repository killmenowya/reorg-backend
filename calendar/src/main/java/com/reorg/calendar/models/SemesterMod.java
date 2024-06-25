package com.reorg.calendar.models;

import lombok.Data;

@Data
public class SemesterMod {
    private int semester;
    private int examDuration;
    private String examDate;
    private LessonMod[] timetable;  
}
