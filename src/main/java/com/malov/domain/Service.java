package com.malov.domain;

import javax.persistence.*;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String service;
    private Integer kratnost;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id" )
    private User author;

    public Service() {}

    public Service(String service, Integer kratnost, User user) {
        this.service = service;
        this.kratnost = kratnost;
        this.author = user;
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "null";
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
