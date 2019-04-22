package com.byka.humanlibrary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(UserRolePK.class)
public class UserRole {
    @Id
    @Column(name = "NICKNAME", nullable = false)
    private String nickname;

    @Id
    @Column(name = "ROLE", nullable = false)
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
