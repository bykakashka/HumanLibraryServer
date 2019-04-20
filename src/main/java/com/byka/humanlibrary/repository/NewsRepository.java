package com.byka.humanlibrary.repository;

import com.byka.humanlibrary.entity.News;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface NewsRepository extends CrudRepository<News, Long> {
    @Query(value = "SELECT s FROM News s WHERE s.creationDate <= :date order by s.creationDate, s.id")
    List<News> getBeforeDate(@Param("date") final Date date);
}
