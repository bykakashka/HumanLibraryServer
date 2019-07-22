package com.byka.humanlibrary.data;

import java.util.List;

public class SessionData {
    private Integer sequence;
    private String startDate;
    private String endDate;
    private Long id;
    private List<BookToSessionData> booksToSession;
    private Boolean isRegistrationAvailable;

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

    public List<BookToSessionData> getBooksToSession() {
        return booksToSession;
    }

    public void setBooksToSession(List<BookToSessionData> booksToSession) {
        this.booksToSession = booksToSession;
    }

    public Boolean getRegistrationAvailable() {
        return isRegistrationAvailable;
    }

    public void setRegistrationAvailable(Boolean registrationAvailable) {
        isRegistrationAvailable = registrationAvailable;
    }
}
