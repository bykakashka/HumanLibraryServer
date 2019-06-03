package com.byka.humanlibrary.service;

import com.byka.humanlibrary.data.BoardData;
import com.byka.humanlibrary.data.RegistrationEvent;

import java.util.List;

public interface BoardService {
    List<BoardData> getBySessionId(Long sessionId);

    List<BoardData> findBoardsForCurrent();

    void createBoards(Long sessionId, List<BoardData> boardData);

    List<BoardData> findBoardsForBookAndEvent(Long bookId, Long eventId);

    void updateBoardDataForBook(Long eventId, Long bookId, List<BoardData> newBoards);
}
