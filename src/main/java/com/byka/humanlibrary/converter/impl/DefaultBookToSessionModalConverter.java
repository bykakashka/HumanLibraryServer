package com.byka.humanlibrary.converter.impl;

import com.byka.humanlibrary.converter.BookToSessionModalConverter;
import com.byka.humanlibrary.data.BookToSessionData;
import com.byka.humanlibrary.entity.BookToSession;
import org.springframework.stereotype.Service;

@Service
public class DefaultBookToSessionModalConverter extends DefaultAbstractConverter<BookToSessionData, BookToSession> implements BookToSessionModalConverter {
    @Override
    public BookToSession convert(BookToSessionData data) {
        BookToSession bookToSession = new BookToSession();
        bookToSession.setBoardNo(data.getBoardNo());
        bookToSession.setBookId(data.getBookId());
        bookToSession.setMaxUsers(data.getMaxUsers());
        bookToSession.setSessionId(data.getSessionId());
        return bookToSession;
    }
}
