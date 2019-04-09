package com.byka.humanlibrary.converter.impl;

import com.byka.humanlibrary.converter.BookConverter;
import com.byka.humanlibrary.data.BookData;
import com.byka.humanlibrary.entity.Book;
import org.springframework.stereotype.Service;

@Service
public class DefaultBookConverter extends DefaultAbstractConverter<Book, BookData> implements BookConverter {
    @Override
    public BookData convert(Book book) {
        final BookData result = new BookData();
        result.setId(book.getId());
        result.setDescription(book.getShortDescription());
        result.setName(book.getName());
        result.setLongDescription(book.getLongDescription());
        return result;
    }
}
