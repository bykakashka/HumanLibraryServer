package com.byka.humanlibrary.converter.impl;

import com.byka.humanlibrary.converter.NewsConverter;
import com.byka.humanlibrary.data.NewsData;
import com.byka.humanlibrary.entity.News;
import org.springframework.stereotype.Service;

@Service
public class DefaultNewsConverter extends DefaultAbstractConverter<News, NewsData> implements NewsConverter {
    @Override
    public NewsData convert(News news) {
        final NewsData data = new NewsData();
        data.setId(news.getId());
        data.setTitle(news.getTitle());
        data.setText(news.getText());
        if (news.getAuthor() != null) {
            data.setAuthorId(news.getAuthor().getId());
        }
        return data;
    }
}
