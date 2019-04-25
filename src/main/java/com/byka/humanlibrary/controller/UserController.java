package com.byka.humanlibrary.controller;

import com.byka.humanlibrary.data.BoardData;
import com.byka.humanlibrary.data.UserData;
import com.byka.humanlibrary.service.BoardService;
import com.byka.humanlibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private BoardService boardService;

    @GetMapping
    @ResponseBody
    public UserData auth() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        final String nickname = auth.getPrincipal().toString();
        return userService.getByNicknameOrAnon(nickname);
    }

    @GetMapping("/boards")
    @ResponseBody
    public List<BoardData> getForCurrent() {
        return boardService.findBoardForCurrent();
    }
}
