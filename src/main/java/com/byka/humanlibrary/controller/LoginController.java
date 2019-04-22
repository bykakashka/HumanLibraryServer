package com.byka.humanlibrary.controller;

import com.byka.humanlibrary.data.UserData;
import com.byka.humanlibrary.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("/user")
public class LoginController {
    @Autowired
    private UserAuthService userAuthService;

    @GetMapping
    @ResponseBody
    public UserData auth() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        final String nickname = auth.getPrincipal().toString();
        return userAuthService.getByNickname(nickname);
    }
}
