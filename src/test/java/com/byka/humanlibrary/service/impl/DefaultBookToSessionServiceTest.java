package com.byka.humanlibrary.service.impl;

import com.byka.humanlibrary.converter.BookToSessionModalConverter;
import com.byka.humanlibrary.entity.BookToSession;
import com.byka.humanlibrary.repository.BookToSessionRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Matchers.anyCollection;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DefaultBookToSessionServiceTest {
    private static final Long BOOK_ID = 1L;
    private static final Long EVENT_ID = 2L;

    @InjectMocks
    private DefaultBookToSessionService classUnderTest;

    @Mock
    private BookToSessionModalConverter bookToSessionModalConverter;

    @Mock
    private BookToSessionRepository bookToSessionRepository;

    @Captor
    private ArgumentCaptor<ArrayList<BookToSession>> captorDelete;

    @Captor
    private ArgumentCaptor<ArrayList<BookToSession>> captorUpdate;

    private BookToSession toRemove;

    @Before
    public void init() {
        doNothing().when(bookToSessionRepository).deleteAll(anyCollection());
        doReturn(Collections.emptySet()).when(bookToSessionRepository).saveAll(anyCollection());
    }

    @Test
    public void updateBookForEvent() {
        List<BookToSession> newList = buildNewList();
        doReturn(newList).when(bookToSessionModalConverter).convert(anyList());

        List<BookToSession> oldList = buildOldList();
        doReturn(oldList).when(bookToSessionRepository).getBookToSessionsByBookAndEventId(BOOK_ID, EVENT_ID);

        classUnderTest.updateBookForEvent(EVENT_ID, BOOK_ID, Collections.emptyList());

        Mockito.verify(bookToSessionRepository, times(1)).deleteAll(captorDelete.capture());
        Assert.assertEquals(1, captorDelete.getValue().size());
        Assert.assertEquals(toRemove, captorDelete.getValue().get(0));

        Mockito.verify(bookToSessionRepository, times(1)).saveAll(captorUpdate.capture());
        Assert.assertEquals(3, captorUpdate.getValue().size());
    }

    private List<BookToSession> buildNewList() {
        List<BookToSession> newList = new ArrayList<>();
        BookToSession toUpdateUsers = new BookToSession();
        toUpdateUsers.setSessionId(1L);
        toUpdateUsers.setMaxUsers(20);
        toUpdateUsers.setBookId(BOOK_ID);
        toUpdateUsers.setBoardNo(10);

        newList.add(toUpdateUsers);

        BookToSession toUpdateBoard = new BookToSession();
        toUpdateBoard.setSessionId(2L);
        toUpdateBoard.setMaxUsers(10);
        toUpdateBoard.setBookId(BOOK_ID);
        toUpdateBoard.setBoardNo(5);

        newList.add(toUpdateBoard);

        BookToSession newBookToSession = new BookToSession();
        newBookToSession.setSessionId(3L);
        newBookToSession.setMaxUsers(10);
        newBookToSession.setBookId(BOOK_ID);
        newBookToSession.setBoardNo(10);

        newList.add(newBookToSession);

        return newList;
    }

    private List<BookToSession> buildOldList() {
        List<BookToSession> oldList = new ArrayList<>();
        BookToSession toUpdateUsers = new BookToSession();
        toUpdateUsers.setSessionId(1L);
        toUpdateUsers.setMaxUsers(10);
        toUpdateUsers.setBookId(BOOK_ID);
        toUpdateUsers.setBoardNo(10);

        oldList.add(toUpdateUsers);

        BookToSession toUpdateBoard = new BookToSession();
        toUpdateBoard.setSessionId(2L);
        toUpdateBoard.setMaxUsers(10);
        toUpdateBoard.setBookId(BOOK_ID);
        toUpdateBoard.setBoardNo(10);

        oldList.add(toUpdateBoard);

        toRemove = new BookToSession();
        toRemove.setSessionId(4L);
        toRemove.setMaxUsers(10);
        toRemove.setBookId(BOOK_ID);
        toRemove.setBoardNo(10);

        oldList.add(toRemove);

        return oldList;
    }
}