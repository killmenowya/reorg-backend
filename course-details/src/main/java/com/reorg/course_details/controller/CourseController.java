package com.reorg.course_details.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reorg.course_details.dto.CourseDetailDto;
import com.reorg.course_details.models.CourseDetailMod;
import com.reorg.course_details.services.CourseService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/mod")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CourseDetailMod[] downloadAllMod(@RequestParam String acadYear) {
        return courseService.downloadCourse(acadYear);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<CourseDetailDto> getAllMod(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return courseService.getCourse(PageRequest.of(page, size));
    }
}
 