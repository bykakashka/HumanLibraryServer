package com.byka.humanlibrary.service.impl;

import com.byka.humanlibrary.converter.BookConverter;
import com.byka.humanlibrary.converter.BookModelConverter;
import com.byka.humanlibrary.data.BookData;
import com.byka.humanlibrary.entity.Book;
import com.byka.humanlibrary.repository.BookRepository;
import com.byka.humanlibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultBookService implements BookService {
    @Autowired
    private BookConverter bookConverter;

    @Autowired
    private BookModelConverter bookModelConverter;

    @Autowired
    private BookRepository repository;

    @Override
    public BookData getById(Long id) {
        Optional<Book> dbBook = repository.findById(id);
        return dbBook.map(book -> bookConverter.convert(book)).orElse(null);
    }

    @Override
    public List<BookData> getAll() {
        List<BookData> list = bookConverter.convert(repository.findAll());
        list.sort(Comparator.comparing(BookData::getId));
        return list;
    }

    @Override
    public void createOrUpdateBook(BookData bookData) {
        Book book = bookModelConverter.convert(bookData);
        repository.save(book);
    }
}
