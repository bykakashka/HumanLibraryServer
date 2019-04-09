package com.byka.humanlibrary.repository;

import com.byka.humanlibrary.entity.Event;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    @Query(value = "SELECT e from Event e where e.date >= :date ORDER BY e.date asc ")
    List<Event> getNearest(final @Param("date") Date date, final Pageable pageable);
}
