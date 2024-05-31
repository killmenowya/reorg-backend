package com.reorg.course_details.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.reorg.course_details.models.CourseDetailMod;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/mod")
@RequiredArgsConstructor
public class CourseController {
    private final WebClient webClient;

    @GetMapping
    public CourseDetailMod[] getAllCourses(String acadYear) {

        CourseDetailMod[] apiResponse = webClient.get()
                .uri("https://api.nusmods.com/v2/2018-2019/moduleInfo.json")
                .retrieve()
                .bodyToMono(CourseDetailMod[].class)
                .block();

        return apiResponse;
    }
}
 