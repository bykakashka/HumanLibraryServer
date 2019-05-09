package com.byka.humanlibrary.converter.impl;

import com.byka.humanlibrary.data.SessionData;
import com.byka.humanlibrary.entity.Session;
import com.byka.humanlibrary.helper.DateHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


@RunWith(MockitoJUnitRunner.class)
public class DefaultSessionModelConverterTest {
    @InjectMocks
    private DefaultSessionModelConverter sessionModelConverter;

    @Test
    public void convert() {
        SessionData data = new SessionData();

        Calendar calendar = new GregorianCalendar();

        calendar.setTime(new Date());
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        final Date startDate = calendar.getTime();

        calendar.add(Calendar.HOUR, 1);
        final Date endDate = calendar.getTime();

        Integer seq = 1;
        data.setEndDate(DateHelper.convertToString(endDate));
        data.setSequence(seq);
        data.setStartDate(DateHelper.convertToString(startDate));

        Session result = sessionModelConverter.convert(data);
        Assert.assertNotNull(result);
        Assert.assertEquals(startDate, result.getStartDate());
        Assert.assertEquals(endDate, result.getEndDate());
        Assert.assertEquals(seq, result.getSequence());
    }
}
