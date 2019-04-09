package com.byka.humanlibrary.controller;

import com.byka.humanlibrary.data.BoardData;
import com.byka.humanlibrary.data.BookData;
import com.byka.humanlibrary.data.EventData;
import com.byka.humanlibrary.data.SessionData;
import com.byka.humanlibrary.service.BoardService;
import com.byka.humanlibrary.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @Autowired
    private BoardService boardService;

    @GetMapping(value = "/nearest")
    @ResponseBody
    public List<EventData> getNearest() {
        return eventService.getLatest();
    }

    @GetMapping(value = "/catalog/{eventId}")
    @ResponseBody
    public List<BookData> getCatalog(@PathVariable Long eventId) {
        return eventService.getCatalog(eventId);
    }

    @GetMapping(value = "/sessions/{eventId}")
    @ResponseBody
    public List<SessionData> getSessions(@PathVariable Long eventId) {
        return eventService.getSessions(eventId);
    }

    @GetMapping(value = "/boards/{sessionId}")
    @ResponseBody
    public List<BoardData> getBoards(@PathVariable Long sessionId) {
        return boardService.getBySessionId(sessionId);
    }
}
