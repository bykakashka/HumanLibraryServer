package com.byka.humanlibrary.converter.impl;

import com.byka.humanlibrary.converter.EventConverter;
import com.byka.humanlibrary.data.EventData;
import com.byka.humanlibrary.entity.Event;
import com.byka.humanlibrary.helper.DateHelper;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class DefaultEventConverter extends DefaultAbstractConverter<Event, EventData> implements EventConverter {

    @Override
    public EventData convert(@NotNull final Event event) {
        final EventData data = new EventData();
        data.setId(event.getId());
        data.setAddress(event.getAddress());
        data.setCity(event.getCity().getNameEn()); // TODO
        data.setCityId(event.getCityId());
        data.setInfo(event.getInfo());
        data.setTitle(event.getTitle());

        data.setStatus(event.getStatus());
        data.setDate(DateHelper.convertToString(event.getDate()));
        return data;
    }
}
