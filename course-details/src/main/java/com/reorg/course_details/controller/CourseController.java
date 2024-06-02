package com.reorg.course_details.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    @ResponseStatus(HttpStatus.OK)
    public CourseDetailMod[] getAllCourses(@RequestParam String acadYear) {
        return courseService.getCourse(acadYear);
    }
}
 