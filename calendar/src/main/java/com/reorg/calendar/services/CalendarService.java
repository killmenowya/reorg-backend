package com.reorg.calendar.services;

import com.reorg.calendar.models.Event;
import com.reorg.calendar.repository.CalendarRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CalendarService {
    private CalendarRepository calendarRepository;

    public CalendarService(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

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
}