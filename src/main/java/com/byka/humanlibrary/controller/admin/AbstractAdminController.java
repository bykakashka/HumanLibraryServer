package com.byka.humanlibrary.controller.admin;

import org.springframework.ui.Model;

public class AbstractAdminController {
    public String setContentIntoPage(Model model, String page) {
        model.addAttribute("page", page);
        model.addAttribute("title", "Живая библиотека");
        return "pageTemplate";
    }
}
