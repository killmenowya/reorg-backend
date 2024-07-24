package com.reorg.calendar.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "calendar_courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCourses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String semester;
    private String email;
    private String courseCode;
    private String acadYear;

}
