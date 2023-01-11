package model;

import java.sql.Timestamp;

public class Task {

    private String task;
    private Timestamp datecreated;
    private String description;

    public Task() {
    }

    public Task(String task, Timestamp datecreated, String description) {
        this.task = task;
        this.datecreated = datecreated;
        this.description = description;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Timestamp getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Timestamp datecreated) {
        this.datecreated = datecreated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
