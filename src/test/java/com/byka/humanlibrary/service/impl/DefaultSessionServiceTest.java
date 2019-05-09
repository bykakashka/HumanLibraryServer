package com.byka.humanlibrary.service.impl;

import com.byka.humanlibrary.constants.RegistrationEventMassages;
import com.byka.humanlibrary.data.RegistrationEvent;
import com.byka.humanlibrary.entity.*;
import com.byka.humanlibrary.repository.BoardRepository;
import com.byka.humanlibrary.repository.SessionRepository;
import com.byka.humanlibrary.repository.UserToBoardRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Example;
import org.springframework.scheduling.annotation.Async;

import java.util.Optional;

import static com.byka.humanlibrary.constants.RegistrationEventMassages.ALREADY_REGISTERED;
import static com.byka.humanlibrary.constants.RegistrationEventMassages.REGISTRATION_IS_NOT_OPEN;

@RunWith(MockitoJUnitRunner.class)
public class DefaultSessionServiceTest {
    private static final Integer BOARD_NO = 1;
    private static final Long SESSION_ID = 1L;
    private static final Long USER_ID = 10L;

    @InjectMocks
    private DefaultSessionService classUnderTest;

    @Mock
    private SessionRepository sessionRepository;

    @Mock
    private UserToBoardRepository userToBoardRepository;

    @Mock
    private BoardRepository boardRepository;

    @Test
    public void register_not_allowed() {
        Session session = new Session();
        session.setRegistrationAvailable(false);
        Mockito.when(sessionRepository.findById(1L)).thenReturn(Optional.of(session));

        RegistrationEvent result = classUnderTest.register(USER_ID, SESSION_ID, BOARD_NO);

        Assert.assertNotNull(result);
        Assert.assertFalse(result.getSuccess());
        Assert.assertEquals(REGISTRATION_IS_NOT_OPEN, result.getMessage());
    }

    @Test
    public void register_already_registered() {
        Session session = new Session();
        session.setRegistrationAvailable(true);
        Mockito.when(sessionRepository.findById(1L)).thenReturn(Optional.of(session));

        ArgumentCaptor<UserToBoardPK> userToBoardPK = ArgumentCaptor.forClass(UserToBoardPK.class);
        Mockito.when(userToBoardRepository.findById(userToBoardPK.capture())).thenReturn(Optional.of(new UserToBoard()));

        RegistrationEvent result = classUnderTest.register(USER_ID, SESSION_ID, BOARD_NO);

        Assert.assertNotNull(result);
        Assert.assertEquals(SESSION_ID, userToBoardPK.getValue().getSessionId());
        Assert.assertEquals(USER_ID, userToBoardPK.getValue().getUserId());
        Assert.assertFalse(result.getSuccess());
        Assert.assertEquals(ALREADY_REGISTERED, result.getMessage());
    }

    @Test
    public void register_ok() {
        Session session = new Session();
        session.setRegistrationAvailable(true);
        Mockito.when(sessionRepository.findById(1L)).thenReturn(Optional.of(session));

        ArgumentCaptor<UserToBoardPK> userToBoardPK = ArgumentCaptor.forClass(UserToBoardPK.class);
        Mockito.when(userToBoardRepository.findById(userToBoardPK.capture())).thenReturn(Optional.empty());

        Board board = new Board();
        board.setMaxUsers(10);
        Mockito.when(boardRepository.getOne(Mockito.any(BoardPK.class))).thenReturn(board);

        Mockito.when(userToBoardRepository.count(Mockito.any(Example.class))).thenReturn(9L);

        RegistrationEvent result = classUnderTest.register(USER_ID, SESSION_ID, BOARD_NO);

        ArgumentCaptor<UserToBoard> argument = ArgumentCaptor.forClass(UserToBoard.class);
        Mockito.verify(userToBoardRepository, Mockito.times(1)).save(argument.capture());
        Assert.assertEquals(BOARD_NO, argument.getValue().getBoardNo());
        Assert.assertEquals(SESSION_ID, argument.getValue().getSessionId());
        Assert.assertEquals(USER_ID, argument.getValue().getUserId());

        Assert.assertEquals(USER_ID, userToBoardPK.getValue().getUserId());
        Assert.assertEquals(SESSION_ID, userToBoardPK.getValue().getSessionId());
        Assert.assertNotNull(result);
        Assert.assertTrue(result.getSuccess());
    }

    @Test
    public void register_overlimit() {
        Session session = new Session();
        session.setRegistrationAvailable(true);
        Mockito.when(sessionRepository.findById(1L)).thenReturn(Optional.of(session));

        ArgumentCaptor<UserToBoardPK> userToBoardPK = ArgumentCaptor.forClass(UserToBoardPK.class);
        Mockito.when(userToBoardRepository.findById(userToBoardPK.capture())).thenReturn(Optional.empty());

        Board board = new Board();
        board.setMaxUsers(10);
        Mockito.when(boardRepository.getOne(Mockito.any(BoardPK.class))).thenReturn(board);

        Mockito.when(userToBoardRepository.count(Mockito.any(Example.class))).thenReturn(10L);

        RegistrationEvent result = classUnderTest.register(USER_ID, SESSION_ID, BOARD_NO);
        Assert.assertNotNull(result);
        Assert.assertFalse(result.getSuccess());
        Assert.assertEquals(RegistrationEventMassages.OVERLIMIT, result.getMessage());
    }
}
