package com.byka.humanlibrary.service;

import com.byka.humanlibrary.data.BookData;
import com.byka.humanlibrary.data.EventData;
import com.byka.humanlibrary.data.SessionData;
import java.util.List;

public interface EventService {
    List<EventData> getLatest();

    List<BookData> getCatalog(Long id);

    List<SessionData> getSessions(Long eventId);

    void createOrUpdate(EventData data);
}
