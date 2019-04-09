package com.byka.humanlibrary.service;

import com.byka.humanlibrary.data.BoardData;

import java.util.List;

public interface BoardService {
    List<BoardData> getBySessionId(Long sessionId);
}
