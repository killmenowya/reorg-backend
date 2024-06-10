package com.reorg.calendar.repository;

import com.reorg.calendar.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin
public interface CalendarRepository extends JpaRepository<Event, Integer> {

}