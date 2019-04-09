package com.byka.humanlibrary.converter.impl;

import com.byka.humanlibrary.constants.EventConstants;
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

        data.setInfo(event.getInfo());
        String name = event.getName();

        if (name == null || name.isEmpty()) {
            data.setName(data.getCity() + "\n" + data.getAddress());
        } else {
            data.setName(event.getName());
        }
        data.setStatus(event.getStatus());
        if (EventConstants.PUBLISHED.equals(event.getStatus())) {
            data.setDate(DateHelper.convertToStringWithTime(event.getDate()));
        } else {
            data.setDate(DateHelper.convertToString(event.getDate()));
        }
        return data;
    }
}
