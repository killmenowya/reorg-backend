package com.reorg.grade_overview.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "grade_overview")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GradeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int credit; 
    private String email;
    private String courseCode;
    private String title;
    private String grade;
    private String type; // type of mod, GE? UE? Core?
    private String semester;

}
