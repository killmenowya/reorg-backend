package com.reorg.course_details.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reorg.course_details.models.CourseDetailMod;

@Repository
public interface CourseRepository extends JpaRepository<CourseDetailMod, Long> {
    List<CourseDetailMod> findAll();
}
