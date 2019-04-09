package com.byka.humanlibrary.entity;

import javax.persistence.*;

@IdClass(value = BoardPK.class)
@Entity(name = "Board")
public class Board {
    @Id
    @Column(name = "BOARD_NO")
    private Integer boardNo;

    @Column(name = "MAX_USERS")
    private Integer maxUsers;

    @Id
    @Column(name = "SESSION_ID")
    private Long sessionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SESSION_ID", nullable = false, updatable = false, insertable = false)
    private Session session;

    @Column(name = "BOOK_ID")
    private Long bookId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOOK_ID", insertable = false, updatable = false)
    private Book book;

    public Integer getBoardNo() {
        return boardNo;
    }

    public void setBoardNo(Integer boardNo) {
        this.boardNo = boardNo;
    }

    public Integer getMaxUsers() {
        return maxUsers;
    }

    public void setMaxUsers(Integer maxUsers) {
        this.maxUsers = maxUsers;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }
}
