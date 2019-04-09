package com.byka.humanlibrary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@IdClass(value = EventBookPK.class)
@Entity(name = "EVENT_BOOK")
public class EventBook {
    @Id
    @Column(name = "BOOK_ID")
    private Long bookId;

    @Id
    @Column(name = "EVENT_ID")
    private Long eventId;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
}
