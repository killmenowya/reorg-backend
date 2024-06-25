package com.reorg.calendar.models;

import lombok.Data;

@Data
public class LessonMod {
    private String classNo;
    private String startTime;
    private String endTime;
    private String venue;
    private String day;
    private String lessonType;
    private String size;
    private Object weeks;
}
