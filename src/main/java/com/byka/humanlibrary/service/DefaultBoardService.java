package com.byka.humanlibrary.service;

import com.byka.humanlibrary.converter.BoardConverter;
import com.byka.humanlibrary.data.BoardData;
import com.byka.humanlibrary.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultBoardService implements BoardService {
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardConverter boardConverter;

    @Override
    public List<BoardData> getBySessionId(Long sessionId) {
        return boardConverter.convert(boardRepository.getBySessionId(sessionId));
    }
}
