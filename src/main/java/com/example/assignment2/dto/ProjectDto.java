package com.example.assignment2.dto;

import java.io.Serializable;

public class ProjectDto implements Serializable,SuperDto {

    int code;
    String title;
    String description;

    public ProjectDto() {
    }

    public ProjectDto(int code, String title, String description) {
        this.code = code;
        this.title = title;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
