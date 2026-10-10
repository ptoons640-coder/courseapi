package com.example.courseapi.model;

public class Course {

    private Long id;
    private String name;
    private String duration;

    public Course() {
    }

    public Course(Long id, String name, String duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }

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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}