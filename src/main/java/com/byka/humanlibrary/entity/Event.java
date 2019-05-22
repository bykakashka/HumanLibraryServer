package com.byka.humanlibrary.entity;

import com.byka.humanlibrary.constants.EventConstants;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "Event")
public class Event {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "CITY_ID", nullable = false)
    private Long cityId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CITY_ID", nullable = false, insertable = false, updatable = false)
    private City city;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "TITLE", nullable = false, length = 500)
    private String title;

    @Column(name = "INFO", length = 2000)
    private String info;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "EVENT_BOOK",
            joinColumns = {@JoinColumn(name = "EVENT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "BOOK_ID")})
    @OrderBy(value = "ID")
    private List<Book> books;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "EVENT_ID")
    @OrderBy(value = "SEQUENCE")
    private List<Session> sessions;

    @Column(name = "STATUS", nullable = false)
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    @PrePersist
    public void prePersist() {
        this.status = EventConstants.NEW;
    }
}
