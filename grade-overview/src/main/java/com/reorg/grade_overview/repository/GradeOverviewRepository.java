package com.reorg.grade_overview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.reorg.grade_overview.models.GradeModel;

@Repository
public interface GradeOverviewRepository extends JpaRepository<GradeModel, Long> {
    @Query("SELECT u FROM GradeModel u WHERE u.email = :email and u.semester = :semester")
    List<GradeModel> findGradeByUser(@Param("email") String username,
                                   @Param("semester")String semester);

    @Query("SELECT SUM(g.credit) FROM GradeModel g WHERE g.email = :email")
    Double sumCreditsByEmail(@Param("email") String email);

    @Query("SELECT g FROM GradeModel g WHERE g.email = :email")
    List<GradeModel> findAllGradeByUser(@Param("email") String email);

    @Modifying
    @Query("UPDATE GradeModel g SET g.grade = :newGrade WHERE g.email = :email AND g.courseCode = :courseCode")
    void updateGrade(@Param("email") String email,
                    @Param("courseCode") String courseCode,
                    @Param("newGrade") String newGrade);

}
