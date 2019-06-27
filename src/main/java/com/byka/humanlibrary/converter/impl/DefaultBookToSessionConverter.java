package com.byka.humanlibrary.converter.impl;

import com.byka.humanlibrary.converter.BookToSessionConverter;
import com.byka.humanlibrary.data.BookToSessionData;
import com.byka.humanlibrary.entity.BookToSession;
import org.springframework.stereotype.Service;

@Service
public class DefaultBookToSessionConverter extends DefaultAbstractConverter<BookToSession, BookToSessionData> implements BookToSessionConverter {
    @Override
    public BookToSessionData convert(BookToSession bookToSession) {
        BookToSessionData data = new BookToSessionData();
        data.setBoardNo(bookToSession.getBoardNo());
        data.setBookId(bookToSession.getBookId());
        data.setMaxUsers(bookToSession.getMaxUsers());
        data.setRegisteredCount(bookToSession.getUsers().size());
        data.setBookName(bookToSession.getBook().getName());
        data.setSessionId(bookToSession.getSessionId());
        return data;
    }
}
