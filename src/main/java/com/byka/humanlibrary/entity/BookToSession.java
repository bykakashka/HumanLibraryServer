package com.byka.humanlibrary.entity;

import javax.persistence.*;
import java.util.List;

@IdClass(value = BookToSessionPK.class)
@Entity
@Table(name = "BOOK_TO_SESSION")
public class BookToSession {
    @Id
    @Column(name = "BOOK_ID")
    private Long bookId;

    @Id
    @Column(name = "SESSION_ID")
    private Long sessionId;

    @Column(name = "BOARD_NO")
    private Integer boardNo;

    @Column(name = "MAX_USERS")
    private Integer maxUsers;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID", insertable = false, updatable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "SESSION_ID", insertable = false, updatable = false)
    private Session session;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USER_TO_BOOK",
            joinColumns = {@JoinColumn(name = "SESSION_ID"), @JoinColumn(name = "BOOK_ID")},
            inverseJoinColumns = {@JoinColumn(name = "USER_ID")})
    private List<User> users;

    public Integer getMaxUsers() {
        return maxUsers;
    }

    public void setMaxUsers(Integer maxUsers) {
        this.maxUsers = maxUsers;
    }

    public Integer getBoardNo() {
        return boardNo;
    }

    public void setBoardNo(Integer boardNo) {
        this.boardNo = boardNo;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
