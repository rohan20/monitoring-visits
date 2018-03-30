package com.rohantaneja.monitoringvisits.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by ralph on 30/03/18.
 */

@Entity(tableName = "visits",
        foreignKeys = @ForeignKey(
                entity = Task.class,
                parentColumns = {"id"},
                childColumns = {"taskId"}))
public class Visit {

    @PrimaryKey
    private int id;
    private int taskId;
    private String action;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
