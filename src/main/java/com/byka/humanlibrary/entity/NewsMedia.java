package com.byka.humanlibrary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity(name = "NEWS_MEDIA")
@IdClass(value = NewsMediaPK.class)
public class NewsMedia {
    @Id
    @Column(name = "NEWS_ID")
    private Long newsId;

    @Id
    @Column(name = "MEDIA_ID")
    private Long mediaId;

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public Long getMediaId() {
        return mediaId;
    }

    public void setMediaId(Long mediaId) {
        this.mediaId = mediaId;
    }
}
