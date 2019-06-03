package com.byka.humanlibrary.repository;

import com.byka.humanlibrary.entity.EventBook;
import com.byka.humanlibrary.entity.EventBookPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventBookRepository extends JpaRepository<EventBook, EventBookPK> {
}
