package model;

import javafx.scene.control.TextField;

import java.sql.Timestamp;

public class Task {
    private int userId;
    private int taskId;
    private String task;
    private Timestamp datecreated;
    private String description;

    public Task() {
    }

    public Task(Timestamp datecreated, String description, String task, int userId) {
        this.datecreated = datecreated;
        this.description = description;
        this.task = task;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
}
