package com.byka.humanlibrary.converter.impl;

import com.byka.humanlibrary.converter.SessionModelConverter;
import com.byka.humanlibrary.data.SessionData;
import com.byka.humanlibrary.entity.Session;
import com.byka.humanlibrary.exceptions.ConvertException;
import com.byka.humanlibrary.helper.DateHelper;
import org.springframework.stereotype.Service;

@Service
public class DefaultSessionModelConverter extends DefaultAbstractConverter<SessionData, Session> implements SessionModelConverter {
    @Override
    public Session convert(SessionData sessionData) {
        Session session = new Session();
        session.setSequence(sessionData.getSequence());
        session.setId(sessionData.getId());
        try {
            session.setEndDate(DateHelper.convertFromStringWithTime(sessionData.getEndDate()));
            session.setStartDate(DateHelper.convertFromStringWithTime(sessionData.getStartDate()));
        } catch (Exception e) {
            throw new ConvertException(e);
        }
        return session;

    }
}
