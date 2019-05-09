package com.byka.humanlibrary.service;

import com.byka.humanlibrary.data.RegistrationEvent;
import com.byka.humanlibrary.data.SessionData;
import com.byka.humanlibrary.exceptions.ValidationException;

import java.util.List;

public interface SessionService {
    void createSessions(Long eventId, List<SessionData> sessionData) throws ValidationException;

    RegistrationEvent register(Long sessionId, Integer boardNo);

    RegistrationEvent register(Long userId, Long sessionId, Integer boardNo);

    RegistrationEvent unregister(Long sessionId);

    RegistrationEvent unregister(Long userId, Long sessionId);

    void startRegistration(Long sessionId);

    void closeRegistration(Long sessionId);
}
