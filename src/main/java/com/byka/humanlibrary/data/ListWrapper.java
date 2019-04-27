package com.byka.humanlibrary.data;

import java.util.List;

public class ListWrapper<T> {
    private List<T> content;

    public ListWrapper(List<T> list) {
        this.content = list;
    }

    public List<T> getContent() {
        return content;
    }
}
