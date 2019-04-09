package com.byka.humanlibrary.repository;

import com.byka.humanlibrary.entity.Board;
import com.byka.humanlibrary.entity.BoardPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, BoardPK> {
    @Query(value = "SELECT b FROM Board b WHERE b.sessionId = :sessionId")
    List<Board> getBySessionId(@Param("sessionId") Long sessionId);
}
