package com.reorg.grade_overview.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reorg.grade_overview.dto.GradeInputDto;
import com.reorg.grade_overview.dto.GradeResponseDto;
import com.reorg.grade_overview.service.GradeOverviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/grade")
@RequiredArgsConstructor
public class gradeOverviewController {

    private final GradeOverviewService gradeOverviewService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private List<GradeResponseDto> getGradeByUser(@RequestParam String email,
                                                    @RequestParam String sem) {
        return gradeOverviewService.getGradeByUser(email, sem);
    }//WTF WAS I WRITNG???

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void postGrade(@RequestBody GradeInputDto gradeInputDto) {
        gradeOverviewService.postGrade(gradeInputDto);
    }
    


}
