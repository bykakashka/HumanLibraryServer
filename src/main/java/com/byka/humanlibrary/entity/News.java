package com.byka.humanlibrary.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class News {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text", nullable = false, length = 5000)
    private String text;

    @Column(name = "MEDIA_URL")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "NEWS_MEDIA",
            joinColumns = {@JoinColumn(name = "NEWS_ID")},
            inverseJoinColumns = {@JoinColumn(name = "MEDIA_ID")})
    private List<Media> images;

    @Column(name = "CREATION_DATE", nullable = false)
    private Date creationDate;

    @Column(name = "TITLE")
    private String title;

    @JoinColumn(name = "AUTHOR_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private User author;

    public News() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Media> getImages() {
        return images;
    }

    public void setImages(List<Media> images) {
        this.images = images;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
