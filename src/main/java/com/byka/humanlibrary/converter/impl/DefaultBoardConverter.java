package com.byka.humanlibrary.converter.impl;

import com.byka.humanlibrary.converter.BoardConverter;
import com.byka.humanlibrary.data.BoardData;
import com.byka.humanlibrary.entity.Board;
import org.springframework.stereotype.Service;


@Service
public class DefaultBoardConverter extends DefaultAbstractConverter<Board, BoardData> implements BoardConverter {
    @Override
    public BoardData convert(Board board) {
        final BoardData result = new BoardData();
        result.setBookId(board.getBookId());
        result.setMaxUsers(board.getMaxUsers());
        result.setBoardNo(board.getBoardNo());
        result.setBookName(board.getBook().getName());
        return result;
    }
}
