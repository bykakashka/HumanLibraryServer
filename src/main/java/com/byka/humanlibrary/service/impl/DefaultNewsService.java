package com.byka.humanlibrary.service.impl;

import com.byka.humanlibrary.converter.NewsConverter;
import com.byka.humanlibrary.data.NewsData;
import com.byka.humanlibrary.entity.News;
import com.byka.humanlibrary.repository.NewsRepository;
import com.byka.humanlibrary.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DefaultNewsService implements NewsService {
    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private NewsConverter newsConverter;

    @Override
    public News findById(Long id) {
        return newsRepository.findOne(id);
    }

    @Override
    public List<NewsData> getBeforeDate(Date date) {
        return newsConverter.convert(newsRepository.getBeforeDate(date));
    }
}
