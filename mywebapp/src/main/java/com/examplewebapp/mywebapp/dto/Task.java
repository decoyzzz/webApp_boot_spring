package com.examplewebapp.mywebapp.dto;

public class Task {
    private Long id;
    private String description;
    private boolean isDone;

    public Task() {
    }

    public Task(Long id, String description, boolean isDone) {
        this.id = id;
        this.description = description;
        this.isDone = isDone;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }
}
