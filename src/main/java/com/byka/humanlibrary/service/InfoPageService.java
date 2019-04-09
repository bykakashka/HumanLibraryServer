package com.byka.humanlibrary.service;

import com.byka.humanlibrary.constants.InfoTypeEnum;
import com.byka.humanlibrary.entity.InfoPage;
import org.springframework.stereotype.Service;

public interface InfoPageService {
    InfoPage getByType(InfoTypeEnum type);
}
