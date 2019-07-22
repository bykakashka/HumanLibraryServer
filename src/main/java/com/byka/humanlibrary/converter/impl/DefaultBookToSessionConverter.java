package com.byka.humanlibrary.converter.impl;

import com.byka.humanlibrary.converter.BookToSessionConverter;
import com.byka.humanlibrary.data.BookToSessionData;
import com.byka.humanlibrary.entity.BookToSession;
import com.byka.humanlibrary.entity.User;
import com.byka.humanlibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultBookToSessionConverter extends DefaultAbstractConverter<BookToSession, BookToSessionData> implements BookToSessionConverter {
    @Autowired
    private UserService userService;

    @Override
    public BookToSessionData convert(BookToSession bookToSession) {
        BookToSessionData data = new BookToSessionData();
        data.setBoardNo(bookToSession.getBoardNo());
        data.setBookId(bookToSession.getBookId());
        data.setMaxUsers(bookToSession.getMaxUsers());
        data.setRegisteredCount(bookToSession.getUsers().size());
        data.setBookName(bookToSession.getBook().getName());
        data.setSessionId(bookToSession.getSessionId());
        data.setIsCurrentRegistered(false);

        User currentUser = userService.getCurrent();
        if (currentUser != null && currentUser.getId() != null) {
            final Long currentUserId = currentUser.getId();
            bookToSession.getUsers().forEach(user -> {
                if (currentUserId.equals(user.getId())) {
                    data.setIsCurrentRegistered(true);
                }
            });
        }
        return data;
    }
}
