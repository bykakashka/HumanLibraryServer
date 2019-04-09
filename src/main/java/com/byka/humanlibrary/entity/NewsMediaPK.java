package com.byka.humanlibrary.entity;

import java.io.Serializable;

public class NewsMediaPK implements Serializable {
    private Long newsId;

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
