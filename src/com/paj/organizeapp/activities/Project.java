package com.paj.organizeapp.activities;

import com.paj.organizeapp.email.Email;
import com.paj.organizeapp.email.EmailService;
import com.paj.organizeapp.people.AbstractPeople;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("Duplicates")
public class Project extends Social implements Serializable {
    private String name;
    private ProjectType type;
    private LocalDateTime deadline;

    public Project(String name, ProjectType type, LocalDateTime deadline) {
        super();
        this.name = name;
        this.type = type;
        this.deadline = deadline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public ProjectType getType() {
        return type;
    }


    public void setType(ProjectType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", deadline=" + deadline +
                '}';
    }
}
