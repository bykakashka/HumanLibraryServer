package com.byka.humanlibrary.data;

import java.io.Serializable;

public class RegistrationEvent implements Serializable {
    private Boolean isSuccess;
    private Long sessionId;
    private Integer boardNo;
    private BoardData boardData;

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getBoardNo() {
        return boardNo;
    }

    public void setBoardNo(Integer boardNo) {
        this.boardNo = boardNo;
    }

    public BoardData getBoardData() {
        return boardData;
    }

    public void setBoardData(BoardData boardData) {
        this.boardData = boardData;
    }
}
