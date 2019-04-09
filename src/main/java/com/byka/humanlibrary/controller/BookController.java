package com.byka.humanlibrary.controller;

import com.byka.humanlibrary.data.BookData;
import com.byka.humanlibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    @ResponseBody
    public BookData getById(@PathVariable("id") Long id) {
        return bookService.getById(id);
    }

}
