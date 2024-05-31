package com.reorg.course_details.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reorg.course_details.models.CourseDetailMod;

public interface CourseRepository extends JpaRepository<CourseDetailMod, Long> {

}
