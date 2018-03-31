package com.rohantaneja.monitoringvisits.model;

/**
 * Created by ralph on 31/03/18.
 */

public class TaskData {

    public static final int TYPE_DISTRICT = 0;
    public static final int TYPE_PROGRAMME = 1;

    private String title;
    private int type;
    private int tasksAssigned = 0;
    private int tasksCompleted = 0;
    private int visits = 0;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getTasksAssigned() {
        return tasksAssigned;
    }

    public void setTasksAssigned(int tasksAssigned) {
        this.tasksAssigned = tasksAssigned;
    }

    public int getTasksCompleted() {
        return tasksCompleted;
    }

    public void setTasksCompleted(int tasksCompleted) {
        this.tasksCompleted = tasksCompleted;
    }

    public int getVisits() {
        return visits;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }
}
