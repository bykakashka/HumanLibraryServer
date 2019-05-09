package com.byka.humanlibrary.controller;

import com.byka.humanlibrary.data.RegistrationEvent;
import com.byka.humanlibrary.service.BoardService;
import com.byka.humanlibrary.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/session")
public class SessionController {
    @Autowired
    private SessionService sessionService;

    @GetMapping(value = "/registrate/{sessionId}/{boardId}")
    @ResponseBody
    public RegistrationEvent registration(@PathVariable Integer boardId, @PathVariable Long sessionId) {
        return sessionService.register(sessionId, boardId);
    }

    @GetMapping(value = "/unregistrate/{sessionId}")
    @ResponseBody
    public RegistrationEvent closeRegistration(@PathVariable Long sessionId) {
        return sessionService.unregister(sessionId);
    }
}
