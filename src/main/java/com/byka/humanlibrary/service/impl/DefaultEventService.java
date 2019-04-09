package com.byka.humanlibrary.service.impl;

import com.byka.humanlibrary.converter.BookConverter;
import com.byka.humanlibrary.converter.EventConverter;
import com.byka.humanlibrary.converter.SessionConverter;
import com.byka.humanlibrary.data.BookData;
import com.byka.humanlibrary.data.EventData;
import com.byka.humanlibrary.data.SessionData;
import com.byka.humanlibrary.entity.Event;
import com.byka.humanlibrary.repository.EventRepository;
import com.byka.humanlibrary.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DefaultEventService implements EventService {
    private static final Logger LOG = LoggerFactory.getLogger(DefaultEventService.class);

    private static final Integer NEAREST_EVENT_SIZE = 2;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventConverter eventConverter;

    @Autowired
    private BookConverter bookConverter;

    @Autowired
    private SessionConverter sessionConverter;

    @Override
    public List<EventData> getLatest() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR, 0);

        return eventConverter.convert(eventRepository.getNearest(calendar.getTime(), new PageRequest(0, NEAREST_EVENT_SIZE)));
    }

    @Override
    public List<BookData> getCatalog(final Long eventId) {
        final Event event = eventRepository.findOne(eventId);
        return bookConverter.convert(event.getBooks());
    }

    @Override
    public List<SessionData> getSessions(Long eventId) {
        final Event event = eventRepository.findOne(eventId);
        return sessionConverter.convert(event.getSessions());
    }

    @Override
    public void update(EventData data) {
        Event event = eventRepository.findOne(data.getId());
        event.setInfo(data.getInfo());
        eventRepository.save(event);
    }
}
