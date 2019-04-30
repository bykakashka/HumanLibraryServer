package com.byka.humanlibrary.controller;

import com.byka.humanlibrary.data.BoardData;
import com.byka.humanlibrary.data.ListWrapper;
import com.byka.humanlibrary.data.UserData;
import com.byka.humanlibrary.data.UserRegistrationData;
import com.byka.humanlibrary.service.BoardService;
import com.byka.humanlibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private BoardService boardService;

    @GetMapping("/user")
    @ResponseBody
    public UserData auth() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        final String nickname = auth.getPrincipal().toString();
        return userService.getByNicknameOrAnon(nickname);
    }

    @GetMapping("/user/boards")
    @ResponseBody
    public ListWrapper<BoardData> getForCurrent() {
        return new ListWrapper<>(boardService.findBoardsForCurrent());
    }

    @PostMapping("/signin")
    @ResponseBody
    public UserData signIn(@RequestBody UserRegistrationData data) {
        return userService.createUser(data);
    }
}
