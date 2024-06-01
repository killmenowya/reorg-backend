package com.reorg.course_details.services;

import java.util.Arrays;

import org.hibernate.mapping.Array;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.reorg.course_details.models.CourseDetailMod;
import com.reorg.course_details.repository.CourseRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CourseService {
    private final WebClient webClient;
    private final CourseRepository courseRepository;


    public CourseDetailMod[] getCourse(String acadYear) {
        // TODO: Periodic timer to pull data from third party

        CourseDetailMod[] apiResponse = webClient.get()
        .uri("https://api.nusmods.com/v2/2023-2024/moduleInfo.json")
        .retrieve()
        .bodyToMono(CourseDetailMod[].class)
        .block();

        Arrays.stream(apiResponse)
            .forEach(course -> {
                courseRepository.save(course);
            });


        return apiResponse;
    }

}
