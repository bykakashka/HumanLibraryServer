package com.byka.humanlibrary.service.impl;

import com.byka.humanlibrary.converter.BookConverter;
import com.byka.humanlibrary.data.BookData;
import com.byka.humanlibrary.repository.BookRepository;
import com.byka.humanlibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultBookService implements BookService {
    @Autowired
    private BookConverter bookConverter;

    @Autowired
    private BookRepository repository;

    @Override
    public BookData getById(Long id) {
        return bookConverter.convert(repository.findOne(id));
    }

    @Override
    public List<BookData> getAll() {
        return bookConverter.convert(repository.findAll());
    }
}
