package com.byka.humanlibrary.service.impl;

import com.byka.humanlibrary.converter.BookToSessionConverter;
import com.byka.humanlibrary.converter.BookToSessionModalConverter;
import com.byka.humanlibrary.data.BookToSessionData;
import com.byka.humanlibrary.entity.BookToSession;
import com.byka.humanlibrary.repository.BookToSessionRepository;
import com.byka.humanlibrary.service.BookToSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultBookToSessionService implements BookToSessionService {
    @Autowired
    private BookToSessionConverter bookToSessionConverter;

    @Autowired
    private BookToSessionRepository bookToSessionRepository;

    @Autowired
    private BookToSessionModalConverter bookToSessionModalConverter;

    @Override
    public List<BookToSessionData> getByBookAndEvent(Long bookId, Long eventId) {
        return bookToSessionConverter.convert(bookToSessionRepository.getBookToSessionsByBookAndEventId(bookId, eventId));
    }

    @Override
    public List<BookToSessionData> getBySession(Long sessionId) {
        return bookToSessionConverter.convert(bookToSessionRepository.getBookToSessionsBySessionId(sessionId));
    }

    @Override
    public void updateBookForEvent(Long eventId, Long bookId, List<BookToSessionData> booksToSession) {
        List<BookToSession> newBooksToSessions = bookToSessionModalConverter.convert(booksToSession);
        List<BookToSession> oldBookToSessions = bookToSessionRepository.getBookToSessionsByBookAndEventId(bookId, eventId);

        List<BookToSession> toDelete = new ArrayList<>();

        oldBookToSessions.forEach(o -> {
            boolean isExist = false;
            for (BookToSession n: newBooksToSessions) {
                if (o.getSessionId().equals(n.getSessionId())) {
                    isExist = true;
                }
            }

            if (!isExist) {
                toDelete.add(o);
            }
        });
        bookToSessionRepository.deleteAll(toDelete);
        bookToSessionRepository.saveAll(newBooksToSessions);
    }
}
