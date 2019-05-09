package com.byka.humanlibrary.entity;

import javax.persistence.*;

@Entity
public class Media {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID", nullable =  false, unique = true)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "URL")
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
