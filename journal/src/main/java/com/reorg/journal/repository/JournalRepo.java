package com.reorg.journal.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.reorg.journal.models.JournalMod;


@Repository
public interface JournalRepo extends JpaRepository<JournalMod, Long> {
    JournalMod findByDate(Date date);

    List<JournalMod> findAllByUserEmail(String userEmail);

    @Modifying
    @Transactional
    @Query("DELETE FROM JournalMod j WHERE j.date = :date AND j.userEmail = :userEmail")
    void deleteByDateAndUserEmail(@Param("date") Date date, @Param("userEmail") String userEmail);

    @Modifying
    @Transactional
    @Query("UPDATE JournalMod j SET j.title = :title, j.body = :body WHERE j.date = :date AND j.userEmail = :userEmail")
    void updateJournalByDateAndUserEmail(@Param("date") Date date, @Param("title") String title, @Param("body") String body, @Param("userEmail") String userEmail);
}
