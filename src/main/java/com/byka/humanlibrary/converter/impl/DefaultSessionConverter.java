package com.byka.humanlibrary.converter.impl;

import com.byka.humanlibrary.converter.SessionConverter;
import com.byka.humanlibrary.converter.BoardConverter;
import com.byka.humanlibrary.data.SessionData;
import com.byka.humanlibrary.entity.Session;
import com.byka.humanlibrary.helper.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultSessionConverter extends DefaultAbstractConverter<Session, SessionData> implements SessionConverter {
    @Autowired
    private BoardConverter boardConverter;

    @Override
    public SessionData convert(Session session) {
        final SessionData result = new SessionData();
        result.setStartDate(DateHelper.convertToString(session.getStartDate()));
        result.setEndDate(DateHelper.convertToString(session.getEndDate()));
        result.setSequence(session.getSequence());
        result.setBoards(boardConverter.convert(session.getBoards()));
        result.setId(session.getId());
        return result;
    }
}
