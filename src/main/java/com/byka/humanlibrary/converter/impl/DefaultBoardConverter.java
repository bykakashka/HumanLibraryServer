package com.byka.humanlibrary.converter.impl;

import com.byka.humanlibrary.converter.BoardConverter;
import com.byka.humanlibrary.data.BoardData;
import com.byka.humanlibrary.entity.Board;
import com.byka.humanlibrary.entity.User;
import com.byka.humanlibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DefaultBoardConverter extends DefaultAbstractConverter<Board, BoardData> implements BoardConverter {
    @Autowired
    private UserService userService;

    @Override
    public BoardData convert(Board board) {
        User currentUser = userService.getCurrent();

        final BoardData result = new BoardData();
        result.setBookId(board.getBookId());
        result.setMaxUsers(board.getMaxUsers() - board.getRegisteredUsers().size());
        result.setBoardNo(board.getBoardNo());
        result.setBookName(board.getBook().getName());
        result.setSessionId(board.getSessionId());
        if (currentUser != null && board.getRegisteredUsers().contains(currentUser)) {
            result.setCurrentRegistered(true);
        }
        return result;
    }
}
