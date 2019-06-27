package com.byka.humanlibrary.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID", nullable =  false, unique = true)
    private Long id;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private UserInfo userInfo;

    @JoinTable(name = "USER_ROLE",
            joinColumns = {@JoinColumn(name = "USER_ID")}
    )
    @Column(name = "ROLE")
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    private List<String> roles;

    @Column(name = "PASS")
    private String pass;

    @Column(name = "NICKNAME", nullable = false, unique = true)
    private String nickname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
