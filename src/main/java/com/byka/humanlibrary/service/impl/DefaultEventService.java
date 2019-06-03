package com.byka.humanlibrary.service.impl;

import com.byka.humanlibrary.constants.EventConstants;
import com.byka.humanlibrary.converter.BookConverter;
import com.byka.humanlibrary.converter.EventConverter;
import com.byka.humanlibrary.converter.EventModelConverter;
import com.byka.humanlibrary.converter.SessionConverter;
import com.byka.humanlibrary.data.BookData;
import com.byka.humanlibrary.data.EventData;
import com.byka.humanlibrary.data.SessionData;
import com.byka.humanlibrary.entity.Event;
import com.byka.humanlibrary.entity.EventBook;
import com.byka.humanlibrary.entity.EventBookPK;
import com.byka.humanlibrary.repository.EventBookRepository;
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

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventConverter eventConverter;

    @Autowired
    private BookConverter bookConverter;

    @Autowired
    private SessionConverter sessionConverter;

    @Autowired
    private EventModelConverter eventModelConverter;

    @Autowired
    private EventBookRepository eventBookRepository;

    @Override
    public List<EventData> getLatest(int pageSize) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR, 0);

        return eventConverter.convert(eventRepository.getNearest(calendar.getTime(), PageRequest.of(0, pageSize)));
    }

    @Override
    public List<BookData> getCatalog(final Long eventId) {
        final Event event = eventRepository.getOne(eventId);
        return bookConverter.convert(event.getBooks());
    }

    @Override
    public List<SessionData> getSessions(Long eventId) {
        final Event event = eventRepository.getOne(eventId);
        return sessionConverter.convert(event.getSessions());
    }

    @Override
    public void createOrUpdate(EventData data) {
        Event event = eventModelConverter.convert(data);
        if (event.getStatus() == null) {
            event.setStatus(EventConstants.NEW);
        }
        eventRepository.save(event);
    }

    @Override
    public EventData getById(Long id) {
        final Event event = eventRepository.getOne(id);
        return eventConverter.convert(event);
    }

    @Override
    public void addToCatalog(Long eventId, Long bookId) {
        EventBook eventBook = new EventBook();
        eventBook.setBookId(bookId);
        eventBook.setEventId(eventId);
        eventBookRepository.save(eventBook);
    }
}
