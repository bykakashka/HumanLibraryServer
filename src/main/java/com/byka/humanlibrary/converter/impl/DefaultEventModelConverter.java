package com.byka.humanlibrary.converter.impl;

import com.byka.humanlibrary.converter.EventModelConverter;
import com.byka.humanlibrary.data.EventData;
import com.byka.humanlibrary.entity.Event;
import com.byka.humanlibrary.helper.DateHelper;
import com.byka.humanlibrary.service.impl.DefaultEventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DefaultEventModelConverter extends DefaultAbstractConverter<EventData, Event> implements EventModelConverter {
    private static final Logger LOG = LoggerFactory.getLogger(DefaultEventModelConverter.class);

    @Override
    public Event convert(EventData data) {
        final Event event = new Event();
        event.setId(data.getId());
        event.setStatus(data.getStatus());
        event.setInfo(data.getInfo());
        event.setAddress(data.getAddress());
        event.setCityId(data.getCityId());
        event.setTitle(data.getTitle());

        try {
            if (data.getDate() != null) {
                event.setDate(DateHelper.convertFromStringWithTime(data.getDate()));
            }
        } catch (Exception e) {
            LOG.error("Cannot parse date for event", e);
        }

        return event;
    }
}
