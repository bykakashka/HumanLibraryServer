package com.byka.humanlibrary.controller;

import com.byka.humanlibrary.data.EventData;
import com.byka.humanlibrary.data.NewsData;
import com.byka.humanlibrary.entity.Event;
import com.byka.humanlibrary.entity.News;
import com.byka.humanlibrary.service.EventService;
import com.byka.humanlibrary.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public List<NewsData> getBeforeDate(@PathVariable("date") Date date) {
        return newsService.getBeforeDate(date);
    }
}
