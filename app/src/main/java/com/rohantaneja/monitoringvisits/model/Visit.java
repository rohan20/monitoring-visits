package com.rohantaneja.monitoringvisits.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

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
    @SerializedName("vid")
    private int id;
    @SerializedName("tid")
    private int taskId;
    @SerializedName("remarkOfficer")
    private String officerRemark;
    @SerializedName("remarkAdmin")
    private String adminRemark;
    private Double lat;
    private Double longitude;
    @Embedded
    @SerializedName("actionId")
    private VisitAction action;

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

    public VisitAction getAction() {
        return action;
    }

    public void setAction(VisitAction action) {
        this.action = action;
    }

    static class VisitAction {

        private int actionId;
        private String action;

        public int getActionId() {
            return actionId;
        }

        public void setActionId(int actionId) {
            this.actionId = actionId;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }
    }
}
