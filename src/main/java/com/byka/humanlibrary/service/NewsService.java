package com.byka.humanlibrary.service;

import com.byka.humanlibrary.data.NewsData;
import com.byka.humanlibrary.entity.News;

import java.util.Date;
import java.util.List;

public interface NewsService {
    News findById(Long id);

    List<NewsData> getBeforeDate(final Date date);
}
