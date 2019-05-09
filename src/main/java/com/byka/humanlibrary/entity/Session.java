package com.byka.humanlibrary.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Session {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "EVENT_ID")
    private Long eventId;

    @Column(name = "SEQUENCE", nullable = false)
    private Integer sequence;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "BOOK_SESSION",
            joinColumns = {@JoinColumn(name = "SESSION_ID")},
            inverseJoinColumns = {@JoinColumn(name = "BOOK_ID")})
    private List<Book> books;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "REG_AVAILABLE")
    private Boolean isRegistrationAvailable;

    @OneToMany(mappedBy = "session", fetch = FetchType.LAZY)
    private List<Board> boards;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public List<Board> getBoards() {
        return boards;
    }

    public void setBoards(List<Board> boards) {
        this.boards = boards;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Boolean getRegistrationAvailable() {
        return Boolean.TRUE.equals(isRegistrationAvailable);
    }

    public void setRegistrationAvailable(Boolean registrationAvailable) {
        isRegistrationAvailable = registrationAvailable;
    }
}
