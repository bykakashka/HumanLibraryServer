package com.byka.humanlibrary.service;

import com.byka.humanlibrary.converter.BoardConverter;
import com.byka.humanlibrary.data.BoardData;
import com.byka.humanlibrary.data.RegistrationEvent;
import com.byka.humanlibrary.entity.Board;
import com.byka.humanlibrary.entity.BoardPK;
import com.byka.humanlibrary.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultBoardService implements BoardService {
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardConverter boardConverter;

    @Autowired
    private UserAuthService userAuthService;

    @Override
    public List<BoardData> getBySessionId(Long sessionId) {
        return boardConverter.convert(boardRepository.getBySessionId(sessionId));
    }

    @Override
    public RegistrationEvent register(Long sessionId, Integer boardNo) {
        RegistrationEvent event = new RegistrationEvent();

        BoardPK pk = new BoardPK();
        pk.setBoardNo(boardNo);
        pk.setSessionId(sessionId);

        Optional<Board> boardOptional = boardRepository.findById(pk);
        if (boardOptional.isPresent()) {
            Board board = boardOptional.get();
            Integer maxUsers = board.getMaxUsers();
            if (maxUsers > board.getRegisteredUsers().size()) {
                board.getRegisteredUsers().add(userAuthService.getCurrent());
                boardRepository.save(board);
                event.setSuccess(true);
            } else {
                event.setSuccess(false);
            }
        } else {
            event.setSuccess(false);
        }

        return event;
    }
}
