package com.byka.humanlibrary.service;

import com.byka.humanlibrary.data.BookData;

import java.util.List;

public interface BookService {
    BookData getById(final Long id);

    List<BookData> getAll();
}
