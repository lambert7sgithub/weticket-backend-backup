package com.thoughtworks.training.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Todo {
    @Id
    private String id;
    private String text;
    private Boolean done;

    public Todo() {
    }

    public Todo(String id, String text, Boolean done) {
        this.id = id;
        this.text = text;
        this.done = done;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
