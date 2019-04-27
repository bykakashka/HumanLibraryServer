package com.byka.humanlibrary.service.impl;

import com.byka.humanlibrary.converter.BoardConverter;
import com.byka.humanlibrary.data.BoardData;
import com.byka.humanlibrary.data.RegistrationEvent;
import com.byka.humanlibrary.entity.*;
import com.byka.humanlibrary.repository.BoardRepository;
import com.byka.humanlibrary.repository.UserToBoardRepository;
import com.byka.humanlibrary.service.BoardService;
import com.byka.humanlibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private UserToBoardRepository userToBoardRepository;

    @Override
    public List<BoardData> getBySessionId(Long sessionId) {
        return boardConverter.convert(boardRepository.getBySessionId(sessionId));
    }

    @Override
    public RegistrationEvent register(Long sessionId, Integer boardNo) {
        RegistrationEvent event = new RegistrationEvent();
        event.setSessionId(sessionId);
        event.setBoardNo(boardNo);
        BoardPK pk = new BoardPK();
        pk.setBoardNo(boardNo);
        pk.setSessionId(sessionId);

        Optional<Board> boardOptional = boardRepository.findById(pk);
        if (boardOptional.isPresent()) {
            Board board = boardOptional.get();
            Integer maxUsers = board.getMaxUsers();
            Long userId = userService.getCurrent().getId();
            if (!alreadyRegistered(board.getSessionId(), userId) && maxUsers > board.getRegisteredUsers().size()) {
                UserToBoard userToBoard = new UserToBoard();
                userToBoard.setBoardNo(board.getBoardNo());
                userToBoard.setSessionId(board.getSessionId());
                userToBoard.setUserId(userId);
                userToBoardRepository.saveAndFlush(userToBoard);
                event.setSuccess(true);
            } else {
                event.setSuccess(false);
                event.setErrorMessage("Already registered for this session.");
            }
        } else {
            event.setSuccess(false);
            event.setErrorMessage("Cannot find board to register. Please try again.");
        }

        return event;
    }

    private boolean alreadyRegistered(Long sessionId, Long userId) {
        UserToBoardPK pk = new UserToBoardPK();
        pk.setSessionId(sessionId);
        pk.setUserId(userId);

        return userToBoardRepository.findById(pk).isPresent();
    }

    @Override
    public List<BoardData> findBoardForCurrent() {
        User user = userService.getCurrent();
        if (user == null) {
            return Collections.emptyList();
        } else {
            return boardConverter.convert(user.getBoards());
        }
    }
}
