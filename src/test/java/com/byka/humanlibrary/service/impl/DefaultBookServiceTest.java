package com.byka.humanlibrary.service.impl;

import com.byka.humanlibrary.converter.BookModelConverter;
import com.byka.humanlibrary.data.BookData;
import com.byka.humanlibrary.entity.Book;
import com.byka.humanlibrary.repository.BookRepository;
import com.byka.humanlibrary.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DefaultBookServiceTest {
    @Mock
    private BookModelConverter bookModelConverter;

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private DefaultBookService classUnderTest;

    private Book book;

    @Before
    public void init() {
        book = new Book();
        book.setLongDescription("long");
        book.setShortDescription("short");
    }

    @Test
    public void update_test() {
        BookData bookData = new BookData();
        Mockito.when(bookModelConverter.convert(bookData)).thenReturn(book);
        classUnderTest.createOrUpdateBook(bookData);

        Mockito.verify(bookRepository, Mockito.times(1)).save(book);
    }
}
