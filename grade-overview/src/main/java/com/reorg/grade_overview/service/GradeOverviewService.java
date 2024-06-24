package com.reorg.grade_overview.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.reorg.grade_overview.Utils.GradeConverter;
import com.reorg.grade_overview.dto.GradeInputDto;
import com.reorg.grade_overview.dto.GradeResponseDto;
import com.reorg.grade_overview.models.GradeModel;
import com.reorg.grade_overview.repository.GradeOverviewRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GradeOverviewService {
    private final GradeOverviewRepository gradeOverviewRepository;

    public List<GradeResponseDto> getGradeByUser(String email, String semester) {
        List<GradeModel> response =  gradeOverviewRepository.findGradeByUser(email, semester);

        return response.stream().map(grade -> GradeResponseDto.builder()
                                .credit(grade.getCredit())
                                .gradePoint(GradeConverter.gradeToPoints(grade.getGrade()))
                                .courseCode(grade.getCourseCode())
                                .title(grade.getTitle())
                                .gradeLetter(grade.getGrade())
                                .build()
        ).toList();
    }

    public void postGrade(GradeInputDto gradeInputDto) {
        GradeModel gradeModel = GradeModel.builder()
                                .credit(gradeInputDto.getCredit())
                                .email(gradeInputDto.getEmail())
                                .courseCode(gradeInputDto.getCourseCode())
                                .title(gradeInputDto.getTitle())
                                .grade(gradeInputDto.getGradeLetter())
                                .type(gradeInputDto.getType())
                                .semester(gradeInputDto.getSemester())
                                .build();

        gradeOverviewRepository.save(gradeModel);

    }
}
