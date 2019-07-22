package com.byka.humanlibrary.data;

public class BookToSessionData {
    private String bookName;
    private Long bookId;
    private Integer boardNo;
    private Integer maxUsers;
    private Integer registeredCount;
    private Long sessionId;
    private Boolean isCurrentRegistered;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Integer getBoardNo() {
        return boardNo;
    }

    public void setBoardNo(Integer boardNo) {
        this.boardNo = boardNo;
    }

    public Integer getMaxUsers() {
        return maxUsers;
    }

    public void setMaxUsers(Integer maxUsers) {
        this.maxUsers = maxUsers;
    }

    public Integer getRegisteredCount() {
        return registeredCount;
    }

    public void setRegisteredCount(Integer registeredCount) {
        this.registeredCount = registeredCount;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public Boolean getIsCurrentRegistered() {
        return isCurrentRegistered;
    }

    public void setIsCurrentRegistered(Boolean isCurrentRegistered) {
        this.isCurrentRegistered = isCurrentRegistered;
    }
}
