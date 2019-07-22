package com.byka.humanlibrary.converter.impl;

import com.byka.humanlibrary.converter.BookToSessionConverter;
import com.byka.humanlibrary.converter.SessionConverter;
import com.byka.humanlibrary.data.SessionData;
import com.byka.humanlibrary.entity.Session;
import com.byka.humanlibrary.helper.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultSessionConverter extends DefaultAbstractConverter<Session, SessionData> implements SessionConverter {
    @Autowired
    private BookToSessionConverter bookToSessionConverter;

    @Override
    public SessionData convert(Session session) {
        final SessionData result = new SessionData();
        result.setStartDate(DateHelper.convertToString(session.getStartDate()));
        result.setEndDate(DateHelper.convertToString(session.getEndDate()));
        result.setSequence(session.getSequence());
        result.setBooksToSession(bookToSessionConverter.convert(session.getBooksToSession()));
        result.setId(session.getId());
        result.setRegistrationAvailable(session.getRegistrationAvailable());
        return result;
    }
}
