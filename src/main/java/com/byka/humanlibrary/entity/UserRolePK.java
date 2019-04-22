package com.byka.humanlibrary.entity;

import java.io.Serializable;

public class UserRolePK implements Serializable {
    private String nickname;

    private String role;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
