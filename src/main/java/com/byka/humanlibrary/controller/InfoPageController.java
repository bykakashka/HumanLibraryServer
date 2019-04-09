package com.byka.humanlibrary.controller;

import com.byka.humanlibrary.constants.InfoTypeEnum;
import com.byka.humanlibrary.entity.InfoPage;
import com.byka.humanlibrary.service.InfoPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/info")
public class InfoPageController {
    @Autowired
    private InfoPageService infoPageService;

    @GetMapping(value = "/{type}")
    @ResponseBody
    public InfoPage getByType(@PathVariable(name = "type") String type) {
        return infoPageService.getByType(InfoTypeEnum.valueOf(type));
    }
}
