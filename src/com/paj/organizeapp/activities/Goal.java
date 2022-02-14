package com.paj.organizeapp.activities;

import java.time.LocalDateTime;

public class Goal {
    private String name;
    private String objective_description;
    private boolean achieved;

    public Goal(String name, String objective_description, boolean achieved) {
        this.name = name;
        this.objective_description = objective_description;
        this.achieved = achieved;
    }

    public boolean isAchieved() {
        return achieved;
    }

    public void setAchieved() {
        this.achieved = true;
    }

    public String getName() {
        return name;
    }

    public String getObjective_description() {
        return objective_description;
    }


    @Override
    public String toString() {
        return "Milestone{" +
                "name='" + name + '\'' +
                ", objective_description='" + objective_description + '\'' +
                '}';
    }
}
