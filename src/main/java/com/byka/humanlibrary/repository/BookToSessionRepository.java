package com.byka.humanlibrary.repository;

import com.byka.humanlibrary.entity.BookToSession;
import com.byka.humanlibrary.entity.BookToSessionPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookToSessionRepository extends CrudRepository<BookToSession, BookToSessionPK> {
    @Query("SELECT b FROM BookToSession as b WHERE b.bookId = :bookId AND b.session.eventId = :eventId")
    List<BookToSession> getBookToSessionsByBookAndEventId(@Param("bookId") Long bookId, @Param("eventId") Long eventId);

    List<BookToSession> getBookToSessionsBySessionId(@Param("sessionId") Long sessionId);
}
