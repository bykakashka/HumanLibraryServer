package com.byka.humanlibrary.converter.impl;

import com.byka.humanlibrary.converter.BookModelConverter;
import com.byka.humanlibrary.data.BookData;
import com.byka.humanlibrary.entity.Book;
import org.springframework.stereotype.Service;

@Service
public class DefaultBookModelConverter extends DefaultAbstractConverter<BookData, Book> implements BookModelConverter {
    @Override
    public Book convert(BookData data) {
        Book book = new Book();
        book.setId(data.getId());
        book.setLongDescription(data.getLongDescription());
        book.setShortDescription(data.getDescription());
        book.setName(data.getName());
        book.setUserId(data.getUserId());
        return book;
    }
}
