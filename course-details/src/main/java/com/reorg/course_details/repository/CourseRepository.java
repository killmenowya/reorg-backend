package com.reorg.course_details.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.reorg.course_details.dto.CourseDetailDto;
import com.reorg.course_details.models.CourseDetailMod;

@Repository
public interface CourseRepository extends JpaRepository<CourseDetailMod, Long> {
    @SuppressWarnings("null")
    Page<CourseDetailMod> findAll(Pageable pageable);

    @Query("SELECT c FROM CourseDetailMod c WHERE c.moduleCode = :moduleCode")
    CourseDetailDto findByModuleCode(@Param("moduleCode") String moduleCode);
}
