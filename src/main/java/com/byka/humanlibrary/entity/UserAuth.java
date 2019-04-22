package com.byka.humanlibrary.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "USER_AUTH")
public class UserAuth {
    @Id
    @Column(name = "NICKNAME", nullable = false, unique = true)
    private String nickname;

    @Column(name = "PASS")
    private String pass;

    @Column(name = "USER_ID", unique = true)
    private Long userId;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "NICKNAME")
    private List<UserRole> roles;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }
}
