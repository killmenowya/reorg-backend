package com.reorg.grade_overview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.reorg.grade_overview.models.GradeModel;

@Repository
public interface GradeOverviewRepository {
    @Query("SELECT u FROM User u WHERE u.email = :email and u.semester = :semester")
    List<GradeModel> findGradeByUser(@Param("email") String username,
                                   @Param("semester")String semester);

}
