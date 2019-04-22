package com.byka.humanlibrary.service;

import com.byka.humanlibrary.data.BoardData;
import com.byka.humanlibrary.data.RegistrationEvent;

import java.util.List;

public interface BoardService {
    List<BoardData> getBySessionId(Long sessionId);

    RegistrationEvent register(Long sessionId, Integer boardNo);
}
