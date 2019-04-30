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
        final RegistrationEvent event = new RegistrationEvent();
        final BoardPK pk = new BoardPK();
        pk.setBoardNo(boardNo);
        pk.setSessionId(sessionId);

        Optional<Board> boardOptional = boardRepository.findById(pk);
        if (boardOptional.isPresent()) {
            Board board = boardOptional.get();
            Integer maxUsers = board.getMaxUsers();
            Long userId = userService.getCurrent().getId();
            if (registrationAvailable(board, maxUsers, userId)) {
                createUserToBoard(board, userId);
                event.setSuccess(true);
                event.setMessage("Registered successful.");
            } else {
                event.setSuccess(false);
                event.setMessage("Already registered for this session.");
            }
        } else {
            event.setSuccess(false);
            event.setMessage("Cannot find board to register. Please try again.");
        }

        return event;
    }

    @Override
    public RegistrationEvent unregister(Long sessionId) {
        final UserToBoardPK pk = new UserToBoardPK();
        pk.setSessionId(sessionId);
        pk.setUserId(userService.getCurrent().getId());
        userToBoardRepository.deleteById(pk);

        final RegistrationEvent event = new RegistrationEvent();
        event.setSuccess(true);
        event.setMessage("You was unregistered.");
        return event;
    }

    private boolean registrationAvailable(Board board, Integer maxUsers, Long userId) {
        return !alreadyRegistered(board.getSessionId(), userId) && maxUsers > board.getRegisteredUsers().size();
    }

    private void createUserToBoard(Board board, Long userId) {
        UserToBoard userToBoard = new UserToBoard();
        userToBoard.setBoardNo(board.getBoardNo());
        userToBoard.setSessionId(board.getSessionId());
        userToBoard.setUserId(userId);
        userToBoardRepository.saveAndFlush(userToBoard);
    }

    private boolean alreadyRegistered(Long sessionId, Long userId) {
        UserToBoardPK pk = new UserToBoardPK();
        pk.setSessionId(sessionId);
        pk.setUserId(userId);

        return userToBoardRepository.findById(pk).isPresent();
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
}
