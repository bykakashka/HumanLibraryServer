package com.byka.humanlibrary.converter.impl;

import com.byka.humanlibrary.converter.AbstractConverter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class DefaultAbstractConverter<SOURCE, TARGET> implements AbstractConverter<SOURCE, TARGET> {
    @Override
    public List<TARGET> convert(Iterable<SOURCE> sourceList) {
        if (sourceList != null) {
            List<TARGET> result = new ArrayList<>();
            sourceList.forEach(s -> result.add(convert(s)));
            return result;
        } else {
            return Collections.emptyList();
        }
    }

    public abstract TARGET convert(SOURCE source);
}
