package com.byka.humanlibrary.entity;

import com.byka.humanlibrary.constants.InfoTypeEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "INFO_PAGE")
public class InfoPage {
    @Column(name = "TEXT", nullable = false, length = 5000)
    private String text;

    @Id
    @Column(name = "TYPE", nullable = false)
    private String type;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
