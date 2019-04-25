package com.byka.humanlibrary.controller;

import com.byka.humanlibrary.data.RegistrationEvent;
import com.byka.humanlibrary.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    private BoardService boardService;

    @GetMapping(value = "/board/{sessionId}/{boardId}")
    @ResponseBody
    public RegistrationEvent registration(@PathVariable Integer boardId, @PathVariable Long sessionId) {
        return boardService.register(sessionId, boardId); // TODO refresh board
    }
}
