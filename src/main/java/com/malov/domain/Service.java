package com.malov.domain;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String service;
    private Integer kratnost;

    public Service() {}

    public Service(String service, Integer kratnost) {
        this.service = service;
        this.kratnost = kratnost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Integer getKratnost() {
        return kratnost;
    }

    public void setKratnost(Integer kratnost) {
        this.kratnost = kratnost;
    }
}
