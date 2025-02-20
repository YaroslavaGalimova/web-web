package ru.itmo.wp.model.domain;

import java.util.Date;

public class Article {
    private Long id;
    private Long userId;
    private String title;
    private String text;
    private Date creationTime;

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }
    
    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}
