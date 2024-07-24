package com.reorg.calendar.services;

import com.reorg.calendar.models.CourseDetailsMod;
import com.reorg.calendar.models.Event;
import com.reorg.calendar.models.LessonMod;
import com.reorg.calendar.models.UserCourses;
import com.reorg.calendar.repository.CalendarRepository;
import com.reorg.calendar.repository.CourseRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CalendarService {
    private final WebClient webClient;
    private final CalendarRepository calendarRepository;
    private final CourseRepository courseRepository;

    public Event addEvent(Event event) {
        return calendarRepository.save(event);
    }

    public List<Event> getAllEvents() {
        Iterable<Event> events = calendarRepository.findAll();
        List<Event> eventList = new ArrayList<>();
        for (Event event : events) {
            eventList.add(event);
        }
        return eventList;
    }

    public Event getEventById(Integer id) {
        return calendarRepository.findById(id).orElse(null);
    }

    public List<Event> getEventByDate(Date date) {
        return null;
    }

    public Event updateEvent(Integer id, Event event) {
        event.setId(id);
        return calendarRepository.save(event);
    }

    public void deleteEvent(Integer id) {
        calendarRepository.deleteById(id);
    }

    // thaddy methods
    public LessonMod[] getCourseTimetable(String courseCode, int semester, String acadYear) {
        CourseDetailsMod apiResponse = webClient.get()
        .uri("https://api.nusmods.com/v2/"+acadYear+"/modules/"+courseCode+".json")
        .retrieve()
        .bodyToMono(CourseDetailsMod.class)
        .block();

        //TODO: semester bug. expected behavior need to minus 1 from semester
        return apiResponse.getSemesterData()[semester].getTimetable();
    }

    public UserCourses addCourse(UserCourses userCourses) {
        return courseRepository.save(userCourses);
    }

    public List<String> getUserCourses(String email, String semester, String acadYear) {
        List<UserCourses> data = courseRepository.
                                    findByEmailAndSemesterAndAcadYear(email, semester, acadYear);
        return data.stream().map(userCourse -> userCourse.getCourseCode()).toList();
    }
}