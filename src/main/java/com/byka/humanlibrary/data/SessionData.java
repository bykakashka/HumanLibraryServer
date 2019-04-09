package com.byka.humanlibrary.data;

import java.util.List;

public class SessionData {
    private Integer sequence;
    private String startDate;
    private String endDate;
    private List<BoardData> boards;
    private Long id;

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public List<BoardData> getBoards() {
        return boards;
    }

    public void setBoards(List<BoardData> boards) {
        this.boards = boards;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
