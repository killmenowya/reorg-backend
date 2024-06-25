package com.reorg.calendar.controller;

import java.util.Date;
import java.util.List;

import com.reorg.calendar.models.CourseDetailsMod;
import com.reorg.calendar.models.Event;
import com.reorg.calendar.models.LessonMod;
import com.reorg.calendar.services.CalendarService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/calendar")
public class CalendarController {
    private CalendarService calendarService;

    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @PostMapping
    public Event addEvent(@RequestBody Event event) {
        return calendarService.addEvent(event);
    }

    @GetMapping("/all")
    public List<Event> getAllEventByDate(Date date) {
        return calendarService.getEventByDate(date);
    }


    @PutMapping("/{email}")
    public Event updateEvent(@PathVariable Integer id, @RequestBody Event event) {
        return calendarService.updateEvent(id, event);
    }

    @DeleteMapping("/email/{email}")
    public void deleteEvent(@PathVariable Integer id) {
        calendarService.deleteEvent(id);
    }

    // Thaddeus Methods
    @GetMapping("/NUSMod")
    public LessonMod[] getCourseTimetable(@RequestParam String courseCode,
                                            @RequestParam int semester) {
        return calendarService.getCourseTimetable(courseCode, semester);
    }
    
}