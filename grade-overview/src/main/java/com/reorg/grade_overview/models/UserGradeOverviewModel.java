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
@Table(name = "user_grade_overview")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserGradeOverviewModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private double totalCredit;
    private double totalGPA;
}
