package com.reorg.course_details.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reorg.course_details.models.CourseDetailMod;
import com.reorg.course_details.services.CourseService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/mod")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public CourseDetailMod[] getAllCourses(String acadYear) {
        return courseService.getCourse(acadYear);
    }
}
 