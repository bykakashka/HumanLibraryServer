package com.byka.humanlibrary.service.impl;

import com.byka.humanlibrary.constants.InfoTypeEnum;
import com.byka.humanlibrary.entity.InfoPage;
import com.byka.humanlibrary.repository.InfoPageRepository;
import com.byka.humanlibrary.service.InfoPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultInfoPageService implements InfoPageService {
    @Autowired
    private InfoPageRepository repository;

    @Override
    public InfoPage getByType(InfoTypeEnum type) {
        return repository.findOne(type.name());
    }
}
