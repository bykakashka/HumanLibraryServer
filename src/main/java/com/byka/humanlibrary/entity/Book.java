package com.byka.humanlibrary.entity;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USER_ID")
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "USER_ID", insertable = false, updatable = false)
    private User user;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "SHORT_DESCR", length = 20)
    private String shortDescription;

    @Column(name = "LONG_DESCR", nullable = false, length = 5000)
    private String longDescription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
