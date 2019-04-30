package com.byka.humanlibrary.entity;

import javax.persistence.*;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME_EN", nullable = false)
    private String nameEn;

    @Column(name = "NAME_RU")
    private String nameRu;

    @Column(name = "NAME_BY")
    private String nameBy;

    public City() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public String getNameBy() {
        return nameBy;
    }

    public void setNameBy(String nameBy) {
        this.nameBy = nameBy;
    }
}
