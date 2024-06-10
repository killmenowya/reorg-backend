package com.reorg.calendar.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "calendar_events")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userEmail;
    private String title;
    private String eventType;
    private String description;
    @DateTimeFormat(pattern="yyyy-mm-dd hh:mm:ss")
    private Date startDateTime;
    @DateTimeFormat(pattern="yyyy-mm-dd hh:mm:ss")
    private Date endDateTime;

}