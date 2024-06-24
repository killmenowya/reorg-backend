package com.reorg.grade_overview.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GradeInputDto {

    private double credit;
    private String courseCode;
    private String title;
    private String gradeLetter;
    private String type; // type of mod, GE? UE? Core?
    private String semester;
}
