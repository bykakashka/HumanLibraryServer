package com.byka.humanlibrary.service.impl;

import com.byka.humanlibrary.constants.RegistrationEventMassages;
import com.byka.humanlibrary.converter.SessionModelConverter;
import com.byka.humanlibrary.data.RegistrationEvent;
import com.byka.humanlibrary.data.SessionData;
import com.byka.humanlibrary.entity.*;
import com.byka.humanlibrary.exceptions.ValidationException;
import com.byka.humanlibrary.repository.BookToSessionRepository;
import com.byka.humanlibrary.repository.SessionRepository;
import com.byka.humanlibrary.repository.UserToBoardRepository;
import com.byka.humanlibrary.service.SessionService;
import com.byka.humanlibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultSessionService implements SessionService {
    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private SessionModelConverter sessionModelConverter;

    @Autowired
    private UserToBoardRepository userToBoardRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private BookToSessionRepository bookToSessionRepository;

    @Override
    public void createSessions(Long eventId, List<SessionData> sessionData) throws ValidationException {
        List<Session> sessions = sessionModelConverter.convert(sessionData);
        sessions.sort(Comparator.comparing(Session::getStartDate));
        validate(sessions);
        int seq = 1;
        for (Session session : sessions) {
            session.setEventId(eventId);
            session.setSequence(seq++);
        }

        sessionRepository.saveAll(sessions);
    }

    @Override
    public RegistrationEvent register(Long sessionId, Long bookId) {
        return register(userService.getCurrent().getId(), sessionId, bookId);
    }

    @Override
    public RegistrationEvent register(Long userId, Long sessionId, Long bookId) {
        Optional<Session> sessionOptional = sessionRepository.findById(sessionId);
        RegistrationEvent registrationEvent = isRegisterAvailable(userId, sessionId, sessionOptional);

        if (!sessionOptional.isPresent()) {
            registrationEvent.setSuccess(false);
            registrationEvent.setMessage(RegistrationEventMassages.SESSION_IS_NOT_EXIST);
            return registrationEvent;
        }

        if (!Boolean.FALSE.equals(registrationEvent.getSuccess())) {
            Session session = sessionOptional.get();

            BookToSessionPK pk = new BookToSessionPK();
            pk.setBookId(bookId);
            pk.setSessionId(sessionId);
            Optional<BookToSession> bookToSession = bookToSessionRepository.findById(pk);

            if (!bookToSession.isPresent()) {
                registrationEvent.setSuccess(false);
                registrationEvent.setMessage(RegistrationEventMassages.SESSION_IS_NOT_EXIST);
            } else {
                BookToSession board = bookToSession.get();
                Integer maxUsers = board.getMaxUsers();

                synchronized (session) {
                    UserToBook userToBook = new UserToBook();
                    userToBook.setBookId(bookId);
                    userToBook.setSessionId(sessionId);
                    Example<UserToBook> userToBoardExample = Example.of(userToBook);
                    Long registeredUsers = userToBoardRepository.count(userToBoardExample);
                    if (registeredUsers < maxUsers) {
                        userToBook.setUserId(userId);
                        userToBoardRepository.save(userToBook);
                        registrationEvent.setSuccess(true);
                    } else {
                        registrationEvent.setSuccess(false);
                        registrationEvent.setMessage(RegistrationEventMassages.OVERLIMIT);
                    }
                }
            }
        }
        return registrationEvent;
    }

    @Override
    public RegistrationEvent unregister(Long sessionId) {
        return this.unregister(userService.getCurrent().getId(), sessionId);
    }

    @Override
    public RegistrationEvent unregister(Long userId, Long sessionId) {
        final UserToBookPK pk = new UserToBookPK();
        pk.setSessionId(sessionId);
        pk.setUserId(userService.getCurrent().getId());
        userToBoardRepository.deleteById(pk);

        final RegistrationEvent event = new RegistrationEvent();
        event.setSuccess(true);
        event.setMessage("You was unregistered.");
        return event;
    }

    @Override
    public void startRegistration(Long sessionId) {
        Session session = sessionRepository.getOne(sessionId);
        session.setRegistrationAvailable(true);
        sessionRepository.save(session);
    }

    @Override
    public void closeRegistration(Long sessionId) {
        Session session = sessionRepository.getOne(sessionId);
        session.setRegistrationAvailable(false);
        sessionRepository.save(session);
    }

    private RegistrationEvent isRegisterAvailable(Long userId, Long sessionId, Optional<Session> sessionOptional) {
        RegistrationEvent registrationEvent = new RegistrationEvent();
        if (!sessionOptional.isPresent()) {
            registrationEvent.setSuccess(false);
            registrationEvent.setMessage(RegistrationEventMassages.SESSION_IS_NOT_EXIST);
            return registrationEvent;
        }

        if (sessionOptional.get().getRegistrationAvailable()) {
            if (alreadyRegistered(userId, sessionId)) {
                registrationEvent.setSuccess(false);
                registrationEvent.setMessage(RegistrationEventMassages.ALREADY_REGISTERED);
                return registrationEvent;
            } else {
                return registrationEvent;
            }
        } else {
            registrationEvent.setSuccess(false);
            registrationEvent.setMessage(RegistrationEventMassages.REGISTRATION_IS_NOT_OPEN);
            return registrationEvent;
        }
    }

    private boolean alreadyRegistered(Long userId, Long sessionId) {
        UserToBookPK pk = new UserToBookPK();
        pk.setUserId(userId);
        pk.setSessionId(sessionId);
        return userToBoardRepository.findById(pk).isPresent();
    }

    private void validate(final List<Session> sessions) throws ValidationException {
        List<Session> copySessions = new ArrayList<>(sessions);
        copySessions.sort(Comparator.comparing(Session::getStartDate));
        if (copySessions.size() > 1) {
            for (int i = 0; i < copySessions.size(); i++) {
                Session current = copySessions.get(i);
                if (current.getEndDate() == null || current.getStartDate() == null) {
                    throw new ValidationException("End or start date cannot be null");
                }

                if (!current.getStartDate().before(current.getEndDate())) {
                    throw new ValidationException("End date should be after start date");
                }

                if (i > 0) {
                    Session prev = copySessions.get(i - 1);
                    if (!current.getStartDate().after(prev.getEndDate())) {
                        throw new ValidationException("New session should start after prev ending");
                    }
                }
            }
        }
    }
}
