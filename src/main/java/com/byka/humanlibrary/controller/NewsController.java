package com.byka.humanlibrary.controller;

import com.byka.humanlibrary.data.ListWrapper;
import com.byka.humanlibrary.data.NewsData;
import com.byka.humanlibrary.entity.News;
import com.byka.humanlibrary.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping(path = "/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping("/id/{id}")
    @ResponseBody
    public News getNews(@PathVariable("id") Long id) {
        return newsService.findById(id);
    }

    @GetMapping("/before/{date}")
    @ResponseBody
    public ListWrapper<NewsData> getBeforeDate(@PathVariable("date") Date date) {
        return new ListWrapper<>(newsService.getBeforeDate(date));
    }
}
