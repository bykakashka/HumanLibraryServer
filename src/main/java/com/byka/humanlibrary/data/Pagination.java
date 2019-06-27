package com.byka.humanlibrary.data;

public class Pagination {
    private int page;
    private int size;
    private String order = "id";

    public Pagination() {
        page = 1;
        size = 10;
    }

    public Pagination(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public Pagination(int page, int size, String order) {
        this.page = page;
        this.size = size;
        this.order = order;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
