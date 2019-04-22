package com.byka.humanlibrary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity(name = "USER_TO_BOARD")
@IdClass(UserToBoardPK.class)
public class UserToBoard {
    @Id
    @Column(name = "NICKNAME")
    private String nickname;

    @Id
    @Column(name = "SESSION_ID")
    private Long sessionId;

    @Id
    @Column(name = "BOARD_NO")
    private Integer boardNo;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
}
