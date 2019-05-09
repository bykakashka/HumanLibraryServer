package com.byka.humanlibrary.converter.impl;

import com.byka.humanlibrary.converter.EventModelConverter;
import com.byka.humanlibrary.data.EventData;
import com.byka.humanlibrary.entity.Event;
import org.springframework.stereotype.Service;

@Service
public class DefaultEventModelConverter extends DefaultAbstractConverter<EventData, Event> implements EventModelConverter {
    @Override
    public Event convert(EventData data) {
        return null;
    }
}
