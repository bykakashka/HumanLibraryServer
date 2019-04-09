package com.byka.humanlibrary.repository;

import com.byka.humanlibrary.entity.InfoPage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoPageRepository extends CrudRepository<InfoPage, String> {
}
