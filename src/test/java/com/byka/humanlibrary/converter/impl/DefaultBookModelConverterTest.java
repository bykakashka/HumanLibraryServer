package com.byka.humanlibrary.converter.impl;

import com.byka.humanlibrary.data.BookData;
import com.byka.humanlibrary.entity.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DefaultBookModelConverterTest {
    @InjectMocks
    private DefaultBookModelConverter classUnderTest;

    @Test
    public void convert() {
        BookData bookData = new BookData();
        bookData.setLongDescription("long");
        bookData.setDescription("short");
        bookData.setId(1L);
        bookData.setName("name");
        Book result = classUnderTest.convert(bookData);

        Assert.assertNotNull(result);
        Assert.assertEquals(bookData.getDescription(), result.getShortDescription());
        Assert.assertEquals(bookData.getLongDescription(), result.getLongDescription());
        Assert.assertEquals(bookData.getId(), result.getId());
        Assert.assertEquals(bookData.getName(), result.getName());
    }
}
