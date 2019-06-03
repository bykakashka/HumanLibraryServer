package com.byka.humanlibrary.service.impl;

import com.byka.humanlibrary.converter.BoardConverter;
import com.byka.humanlibrary.converter.BoardModelConverter;
import com.byka.humanlibrary.data.BoardData;
import com.byka.humanlibrary.data.RegistrationEvent;
import com.byka.humanlibrary.entity.*;
import com.byka.humanlibrary.repository.BoardRepository;
import com.byka.humanlibrary.repository.SessionRepository;
import com.byka.humanlibrary.repository.UserToBoardRepository;
import com.byka.humanlibrary.service.BoardService;
import com.byka.humanlibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DefaultBoardService implements BoardService {
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardConverter boardConverter;

    @Autowired
    private UserService userService;

    @Autowired
    private BoardModelConverter boardModelConverter;

    @Override
    public List<BoardData> getBySessionId(Long sessionId) {
        return boardConverter.convert(boardRepository.getBySessionId(sessionId));
    }

    @Override
    public List<BoardData> findBoardsForCurrent() {
        User user = userService.getCurrent();
        if (user == null) {
            return Collections.emptyList();
        } else {
            return boardConverter.convert(user.getBoards());
        }
    }

    @Override
    public void createBoards(Long sessionId, List<BoardData> boardData) {
        List<Board> boards = boardModelConverter.convert(boardData);
        Board boardExample = new Board();
        boardExample.setSessionId(sessionId);

        int maxId = getMaxSavedId(sessionId);
        maxId++;

        for (Board board: boards) {
            board.setSessionId(sessionId);
            if (board.getBoardNo() == null) {
                board.setBoardNo(maxId++);
            }
        }

        boardRepository.saveAll(boards);
    }

    @Override
    public List<BoardData> findBoardsForBookAndEvent(Long bookId, Long eventId) {
        List<Board> boards = boardRepository.findBoardsForBookAndEvent(bookId, eventId);
        return boardConverter.convert(boards);
    }

    @Override
    public void updateBoardDataForBook(Long eventId, Long bookId, List<BoardData> boardDataList) {
        List<Board> oldBoards = boardRepository.findBoardsForBookAndEvent(bookId, eventId);
        List<Board> newBoards = boardModelConverter.convert(boardDataList);
        List<Board> result = new ArrayList<>();

        newBoards.forEach(board -> {
            Integer boardNo = board.getBoardNo();

            Optional<Board> dbBoardOptional = oldBoards.stream().filter(b -> b.getBoardNo().equals(boardNo)).findAny();
            if (dbBoardOptional.isPresent()) {
                Board dbBoard = dbBoardOptional.get();
                dbBoard.setMaxUsers(board.getMaxUsers());
                oldBoards.remove(dbBoard);
                result.add(dbBoard);
            } else {
                result.add(board);
            }
        });

        boardRepository.deleteAll(oldBoards);
        boardRepository.saveAll(result);
    }

    private int getMaxSavedId(Long sessionId) {
        List<Board> savedBoards = boardRepository.getBySessionId(sessionId);
        int maxId = 0;
        for (Board b: savedBoards) {
            if (b.getBoardNo() > maxId) {
                maxId = b.getBoardNo();
            }
        }
        return maxId;
    }
}
