package com.reorg.course_details.services;

import java.util.Arrays;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.reorg.course_details.dto.CourseDetailDto;
import com.reorg.course_details.models.CourseDetailMod;
import com.reorg.course_details.repository.CourseRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CourseService {
    private final WebClient webClient;
    private final CourseRepository courseRepository;


    public CourseDetailMod[] downloadCourse(String acadYear) {
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

    public Page<CourseDetailDto> getCourse(Pageable pageable) {

        Page<CourseDetailMod> coursePage = courseRepository.findAll(pageable);
        
        return coursePage.map(course -> CourseDetailDto.builder()
                                .moduleCode(course.getModuleCode())
                                .title(course.getTitle())
                                .description(course.getDescription())
                                .moduleCredit(course.getModuleCredit())
                                .department(course.getDepartment())
                                .faculty(course.getFaculty())
                                .workload(course.getWorkload())
                                .build()
            );
    }
    
    public CourseDetailDto[] searchCourse(String moduleCode) {
        CourseDetailMod course = courseRepository.findByModuleCode(moduleCode);
        CourseDetailDto res =  CourseDetailDto.builder()
                            .moduleCode(course.getModuleCode())
                            .title(course.getTitle())
                            .description(course.getDescription())
                            .moduleCredit(course.getModuleCredit())
                            .department(course.getDepartment())
                            .faculty(course.getFaculty())
                            .workload(course.getWorkload())
                            .build();
        CourseDetailDto[] arr = new CourseDetailDto[1];
        arr[0] = res;
        return arr;

    }
}

