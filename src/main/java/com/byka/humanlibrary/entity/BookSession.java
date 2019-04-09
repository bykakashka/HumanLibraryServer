package com.byka.humanlibrary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@IdClass(value = BookSessionPK.class)
@Entity(name = "BOOK_SESSION")
public class BookSession {
    @Id
    @Column(name = "BOOK_ID")
    private Long bookId;

    @Id
    @Column(name = "SESSION_ID")
    private Integer sessionId;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }
}
