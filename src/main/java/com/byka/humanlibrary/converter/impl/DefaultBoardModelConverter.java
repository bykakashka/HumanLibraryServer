package com.byka.humanlibrary.converter.impl;

import com.byka.humanlibrary.converter.BoardModelConverter;
import com.byka.humanlibrary.data.BoardData;
import com.byka.humanlibrary.entity.Board;
import org.springframework.stereotype.Service;

@Service
public class DefaultBoardModelConverter extends DefaultAbstractConverter<BoardData, Board> implements BoardModelConverter {
    @Override
    public Board convert(BoardData boardData) {
        Board board = new Board();
        board.setBoardNo(boardData.getBoardNo());
        board.setSessionId(boardData.getSessionId());
        board.setBookId(boardData.getBookId());
        board.setMaxUsers(boardData.getMaxUsers());
        return board;
    }
}
