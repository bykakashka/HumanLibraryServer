package com.byka.humanlibrary.converter;

import java.util.List;

public interface AbstractConverter<SOURCE, TARGET> {
    TARGET convert(SOURCE source);

    List<TARGET> convert(Iterable<SOURCE> sourceList);
}
