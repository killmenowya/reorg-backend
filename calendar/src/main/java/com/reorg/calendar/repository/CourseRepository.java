package com.reorg.calendar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.reorg.calendar.models.UserCourses;

@Repository
@CrossOrigin
public interface CourseRepository extends JpaRepository<UserCourses, Integer>{
    List<UserCourses> findByEmailAndSemesterAndAcadYear(String email, String semester, String acadYear);
}
