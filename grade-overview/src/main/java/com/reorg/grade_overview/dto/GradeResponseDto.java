package com.reorg.grade_overview.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GradeResponseDto {

    private double credit;
    private double gradePoint;
    private String courseCode;
    private String title;
    private String gradeLetter;
}