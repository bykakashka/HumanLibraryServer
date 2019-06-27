package com.byka.humanlibrary.service;

import com.byka.humanlibrary.data.BookToSessionData;

import java.util.List;

public interface BookToSessionService {
    List<BookToSessionData> getByBookAndEvent(Long sessionId, Long bookId);

    List<BookToSessionData> getBySession(Long sessionId);

    void updateBookForEvent(Long eventId, Long bookId, List<BookToSessionData> booksToSession);
}
